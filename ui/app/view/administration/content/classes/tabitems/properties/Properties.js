Ext.define('CMDBuildUI.view.administration.content.classes.tabitems.properties.Properties', {
    extend: 'Ext.form.Panel',

    requires: [
        'CMDBuildUI.view.administration.content.classes.tabitems.properties.PropertiesController'
    ],

    alias: 'widget.administration-content-classes-tabitems-properties-properties',
    controller: 'administration-content-classes-tabitems-properties-properties',
    autoScroll: false,
    modelValidation: true,
    fieldDefaults: CMDBuildUI.util.administration.helper.FormHelper.fieldDefaults,
    layout: 'border',
    items: [{
        xtype: 'panel',
        region: 'center',
        scrollable: 'y',
        items: [{
                xtype: 'administration-content-classes-tabitems-properties-fieldsets-generaldatafieldset'
            },
            {
                xtype: 'administration-content-classes-tabitems-properties-fieldsets-classparametersfieldset' /*, bind: { hidden: '{actions.add}' } */
            },
            {
                xtype: 'administration-content-classes-tabitems-properties-fieldsets-attachmentsfieldset'
            },
            {
                xtype: 'administration-content-classes-tabitems-properties-fieldsets-defaultordersfieldset',
                bind: {
                    hidden: '{actions.add}'
                }
            },
            {
                xtype: 'administration-content-classes-tabitems-properties-fieldsets-groupingsordersfieldset'
            },
            {
                xtype: 'administration-content-classes-tabitems-properties-fieldsets-mobilefieldset'
            },
            {
                xtype: 'administration-content-classes-tabitems-properties-fieldsets-valididationfieldset' /*, bind: { hidden: '{actions.add}' }*/
            },
            {
                xtype: 'administration-content-classes-tabitems-properties-fieldsets-triggersfieldset' /*, bind: { hidden: '{actions.add}' } */
            },
            {
                xtype: 'administration-content-classes-tabitems-properties-fieldsets-contextmenusfieldset' /*, bind: { hidden: '{actions.add}' }*/
            },
            {
                xtype: 'administration-content-classes-tabitems-properties-fieldsets-formwidgetfieldset' /*, bind: { hidden: '{actions.add}' }*/
            },
            {
                xtype: 'administration-content-classes-tabitems-properties-fieldsets-contentmanagementfieldset'
            },
            {
                xtype: 'administration-content-classes-tabitems-properties-fieldsets-iconfieldset'
            }
        ]
    }],

    dockedItems: [{
        xtype: 'components-administration-toolbars-formtoolbar',
        region: 'top',
        borderBottom: 0,
        items: CMDBuildUI.util.administration.helper.FormHelper.getTools({
                edit: true, // #editBtn set true for show the button
                'delete': true, // #deleteBtn set true for show the button
                activeToggle: true // #enableBtn and #disableBtn set true for show the buttons
            },

            /* testId */
            'class',

            /* viewModel object needed only for activeTogle */
            'theObject',

            /* add custom tools[] on the left of the bar */
            [],

            /* add custom tools[] before #editBtn*/
            [],

            /* add custom tools[] after at the end of the bar*/
            [{

                xtype: 'button',
                align: 'right',
                itemId: 'printBtn',
                iconCls: 'x-fa fa-print',
                cls: 'administration-tool',
                tooltip: CMDBuildUI.locales.Locales.administration.classes.properties.toolbar.printBtn.tooltip,
                menu: {
                    items: [{
                        text: CMDBuildUI.locales.Locales.administration.classes.properties.toolbar.printBtn.printAsPdf,
                        listeners: {
                            click: 'onPrintMenuItemClick'
                        },
                        fileType: 'PDF',
                        cls: 'menu-item-nospace',
                        autoEl: {
                            'data-testid': 'administration-class-print-pdf'
                        }
                    }, {
                        text: CMDBuildUI.locales.Locales.administration.classes.properties.toolbar.printBtn.printAsOdt,
                        listeners: {
                            click: 'onPrintMenuItemClick'
                        },
                        fileType: 'ODT',
                        cls: 'menu-item-nospace',
                        autoEl: {
                            'data-testid': 'administration-class-print-odf'
                        }
                    }]
                },
                visible: false,
                autoEl: {
                    'data-testid': 'administration-class-print'
                },
                bind: {
                    disabled: '{toolbarHiddenButtons.print}'
                }
            }]
        ),
        bind: {
            hidden: '{formtoolbarHidden}'
        }
    }, {
        xtype: 'toolbar',
        dock: 'bottom',
        ui: 'footer',
        hidden: true,
        bind: {
            hidden: '{actions.view}'
        },
        items: CMDBuildUI.util.administration.helper.FormHelper.getSaveCancelButtons()
    }]

});