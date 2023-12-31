Ext.define('CMDBuildUI.view.dms.attachment.CreateModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.dms-attachment-create',

    formulas: {
        DMSModelClassNameCalculation: {
            bind: {
                DMSCategoryTypeName: '{dms-attachment-create.DMSCategoryTypeName}',
                DMSCategoryTypeValue: '{dms-attachment-create.DMSCategoryValue}'
            },
            get: function (data) {
                if (data.DMSCategoryTypeName && data.DMSCategoryTypeValue) {
                    var DMSCatygoryType = CMDBuildUI.model.dms.DMSCategoryType.getCategoryTypeFromName(data.DMSCategoryTypeName);

                    DMSCatygoryType.getCategoryValues().then(function (categoryValues) {
                        // this.getView().setDMSCategoryType(DMSCatygoryType);
                        var r = categoryValues.findRecord('_id', data.DMSCategoryTypeValue);

                        if (r) {
                            var DMSModelClassName = r.get('modelClass') || 'BaseDocument';
                            this.getView().setDMSModelClassName(DMSModelClassName);
                        }

                    }, Ext.emptyFn, Ext.emptyFn, this);
                }
            }
        },

        DMSClassCalculation: {
            bind: '{dms-attachment-create.DMSModelClassName}',
            get: function (DMSModelClassName) {

                if (DMSModelClassName) {
                    return CMDBuildUI.util.helper.ModelHelper.getDMSModelFromName(DMSModelClassName);
                }
            }
        },

        DMSmodelClassCalculation: {
            bind: '{dms-attachment-create.DMSModelClassName}',
            get: function (modelClassName) {
                if (modelClassName) {
                    CMDBuildUI.util.helper.ModelHelper.getModel(
                        CMDBuildUI.util.helper.ModelHelper.objecttypes.dmsmodel,
                        modelClassName
                    ).then(function (model) {
                        this.getView().setDMSModelClass(model);
                    }, Ext.emptyFn, Ext.emptyFn, this);
                }
            }
        },

        updatTheObject: {
            bind: {
                objectTypeName: '{dms-attachment-create.objectTypeName}',
                objectId: '{dms-attachment-create.objectId}',
                objectType: '{dms-attachment-create.objectType}',
                DMSModelClass: '{dms-attachment-create.DMSModelClass}',
                DMSCategoryValue: '{dms-attachment-create.DMSCategoryValue}'
            },
            get: function (data) {
                if (data.DMSModelClass && data.DMSCategoryValue) {
                    var theObject = Ext.create(data.DMSModelClass.getName(), {
                        _id: null,//seems it doesn't work. Autogenerated id is created even with this config
                        category: data.DMSCategoryValue
                    });
                    this.getView().setTheObject(theObject);
                }

                if (data.objectTypeName && data.objectId && data.objectType && data.DMSModelClass && data.DMSCategoryValue) {

                    var proxyUrl;
                    switch (data.objectType) {
                        case CMDBuildUI.util.helper.ModelHelper.objecttypes.klass:
                            proxyUrl = CMDBuildUI.util.api.Classes.getAttachments(data.objectTypeName, data.objectId);
                            break;
                        case CMDBuildUI.util.helper.ModelHelper.objecttypes.calendar:
                            proxyUrl = CMDBuildUI.util.api.Calendar.getAttachmentsUrl(data.objectId);
                            break;
                        case CMDBuildUI.util.helper.ModelHelper.objecttypes.process:
                            proxyUrl = CMDBuildUI.util.api.Processes.getAttachmentsUrl(data.objectTypeName, data.objectId);
                            break;
                        default:
                            CMDBuildUI.util.Notifier.showErrorMessage(Ext.String.format('No attachments url for {0} object', data.objectType));
                            return;
                    }

                    theObject.getProxy().setUrl(proxyUrl);
                }
            }
        },

        DMSWidgets: {
            bind: '{DMSClassCalculation}',
            get: function(dmsmodel) {
                return dmsmodel.widgets();
            }
        }
    }

});
