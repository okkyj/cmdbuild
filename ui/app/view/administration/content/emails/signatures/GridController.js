Ext.define('CMDBuildUI.view.administration.content.emails.signatures.GridController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.administration-content-emails-signatures-grid',
    listen: {
        global: {
            signatureupdated: 'onSignatureUpdated',
            signaturecreated: 'onSignatureCreated'
        }
    },
    control: {
        tableview: {
            rowdblclick: 'onRowDblclick'
        }
    },

    /**
     * 
     * @param {Ext.data.Model} record
     */
    onSignatureUpdated: function (record) {

        var view = this.getView();
        view.getPlugin('administration-forminrowwidget').view.fireEventArgs('itemupdated', [this.getView(), record, this]);
    },

    /**
     * 
     * @param {Ext.data.Model} record
     */
    onSignatureCreated: function (record) {
        var view = this.getView();
        var store = view.getStore();
        view.getView().refresh();
        store.load();
        store.on('load', function (records, operation, success) {
            Ext.asap(function () {
                var store = view.getStore();
                var index = store.findExact("_id", record.getId());
                var storeItem = store.getAt(index);
                view.getPlugin('administration-forminrowwidget').view.fireEventArgs('togglerow', [null, storeItem, index]);
            });
        });
    },

    /** 
     * @param {*} row 
     * @param {*} record 
     * @param {*} element 
     * @param {*} rowIndex 
     * @param {*} e 
     * @param {*} eOpts 
     */
    onRowDblclick: function (row, record, element, rowIndex, e, eOpts) {
        var container = Ext.getCmp(CMDBuildUI.view.administration.DetailsWindow.elementId) || Ext.create(CMDBuildUI.view.administration.DetailsWindow);
       
        var formInRow = row.ownerGrid.getPlugin('administration-forminrowwidget');
        formInRow.removeAllExpanded(record);
        row.setSelection(record);
        
        this.getView().ownerGrid.getPlugin('administration-forminrowwidget').view.fireEventArgs('togglerow', [null, record, rowIndex]);
        container.removeAll();
        container.add({
            xtype: 'administration-content-emails-signatures-card-card',
            viewModel: {
                links: {
                    theSignature: {
                        type: 'CMDBuildUI.model.emails.Signature',
                        id: record.get('_id')
                    }
                },
                data: {
                    actions: {
                        view: false,
                        edit: true,
                        add: false
                    }
                }
            }
        });
    }
});