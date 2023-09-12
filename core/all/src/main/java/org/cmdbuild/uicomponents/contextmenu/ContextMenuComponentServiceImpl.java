/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cmdbuild.uicomponents.contextmenu;

import static com.google.common.base.Objects.equal;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static java.lang.String.format;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.toList;
import javax.activation.DataHandler;
import org.cmdbuild.auth.user.OperationUserSupplier;
import org.cmdbuild.ui.TargetDevice;
import org.cmdbuild.uicomponents.UiComponentInfo;
import org.cmdbuild.uicomponents.data.UiComponentData;
import org.cmdbuild.uicomponents.data.UiComponentDataImpl;
import org.cmdbuild.uicomponents.data.UiComponentRepository;
import static org.cmdbuild.uicomponents.data.UiComponentType.UCT_CONTEXTMENU;
import org.cmdbuild.uicomponents.utils.UiComponentUtils;
import static org.cmdbuild.uicomponents.utils.UiComponentUtils.checkUglifyJs;
import static org.cmdbuild.uicomponents.utils.UiComponentUtils.getCodeFromExtComponentData;
import static org.cmdbuild.uicomponents.utils.UiComponentUtils.getComponentFile;
import static org.cmdbuild.uicomponents.utils.UiComponentUtils.normalizeComponentData;
import static org.cmdbuild.uicomponents.utils.UiComponentUtils.toComponentInfo;
import static org.cmdbuild.utils.io.CmIoUtils.newDataHandler;
import static org.cmdbuild.utils.lang.CmPreconditions.checkNotBlank;
import static org.cmdbuild.utils.lang.CmStringUtils.normalize;
import org.springframework.stereotype.Component;

@Component
public class ContextMenuComponentServiceImpl implements ContextMenuComponentService {

    private final UiComponentRepository repository;
    private final OperationUserSupplier user;

    public ContextMenuComponentServiceImpl(UiComponentRepository repository, OperationUserSupplier user) {
        this.repository = checkNotNull(repository);
        this.user = checkNotNull(user);
    }

    @Override
    public List<UiComponentInfo> getAll() {
        return repository.getAllByType(UCT_CONTEXTMENU).stream().map(UiComponentUtils::toComponentInfo).collect(toList());
    }

    @Override
    public List<UiComponentInfo> getAllActive() {
        return getAll().stream().filter(UiComponentInfo::isActive).collect(toList());
    }

    @Override
    public UiComponentInfo get(long id) {
        return toComponentInfo(repository.getById(id));
    }

    @Override
    public UiComponentInfo getByCode(String componentId) {
        return toComponentInfo(repository.getByTypeAndName(UCT_CONTEXTMENU, checkNotBlank(componentId)));
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }

    @Override
    public UiComponentInfo deleteForTargetDevice(long id, TargetDevice targetDevice) {
        return toComponentInfo(repository.update(UiComponentDataImpl.copyOf(repository.getById(id)).withoutDataForTargetDevice(targetDevice).build()));
    }

    @Override
    public UiComponentInfo createOrUpdate(List<byte[]> data) {
        String name = getCodeFromExtComponentData(data);
        UiComponentData componentData = repository.getByTypeAndNameOrNull(UCT_CONTEXTMENU, name);
        if (componentData == null) {
            return create(data);
        } else {
            return update(componentData.getId(), data);
        }
    }

    @Override
    public UiComponentInfo create(List<byte[]> data) {
        UiComponentData componentData = repository.create(UiComponentDataImpl.builder().withData(normalizeComponentData(data)).withName(getCodeFromExtComponentData(data)).withType(UCT_CONTEXTMENU).build());
        checkUglifyJs(componentData);
        return toComponentInfo(componentData);
    }

    @Override
    public UiComponentInfo update(long id, List<byte[]> data) {
        UiComponentData componentData = repository.getById(id);
        checkArgument(equal(componentData.getName(), getCodeFromExtComponentData(data)), "invalid component code mismatch");
        Map<TargetDevice, byte[]> mergedData = componentData.getData();
        mergedData.putAll(normalizeComponentData(data));
        UiComponentData newData = UiComponentDataImpl.copyOf(componentData).withData(mergedData).build();
        checkUglifyJs(newData);
        componentData = repository.update(newData);
        return toComponentInfo(componentData);
    }

    @Override
    public UiComponentInfo update(UiComponentInfo component) {
        UiComponentData data = repository.getById(component.getId());
        data = repository.update(UiComponentDataImpl.copyOf(data)
                .withActive(component.isActive())
                .withDescription(component.getDescription()).build());
        return toComponentInfo(data);
    }

    @Override
    public byte[] getContextMenuFile(String name, String filePath) {
        UiComponentData componentData = repository.getByTypeAndName(UCT_CONTEXTMENU, name);
        return getComponentFile(componentData, componentData.getData(user.getUser().getTargetDevice()), filePath, true);//TODO js compression config
    }

    @Override
    public DataHandler getContextMenuData(String code, TargetDevice targetDevice) {
        UiComponentData componentData = repository.getByTypeAndName(UCT_CONTEXTMENU, code);
        return newDataHandler(componentData.getData(targetDevice), "application/zip", format("%s.zip", normalize(componentData.getName())));
    }

}
