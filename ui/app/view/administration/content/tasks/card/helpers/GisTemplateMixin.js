Ext.define('CMDBuildUI.view.administration.content.tasks.card.helpers.GisTemplateMixin', {
    mixinId: 'administration-task-importdatabasemixin',
    mixins: [
        'CMDBuildUI.view.administration.content.tasks.card.helpers.AllInputsMixin'
    ],
    requires: [
        'CMDBuildUI.util.administration.helper.FormHelper'
    ],
    gistemplate: {
        getGeneralPropertyPanel: function (theVmObject, step, data, ctx) {
            var items = [
                ctx.getRowFieldContainer(
                    [
                        ctx.getNameInput(theVmObject, 'code'),
                        ctx.getDescriptionInput(theVmObject, 'description')
                    ]
                )
            ];

            return items;

        },


        getCronPanel: function (theVmObject, step, data, ctx) {
            var items = [
                /**
                 * Cron: combo con valori: Every hour, Every day, Every month, Every year, Custom.
                 * Se Cron è Custom allora compariranno i campi per impostare il cron, come per i task asincroni in CMDBuild 2.5.
                 */
                ctx.getRowFieldContainer(
                    [
                        ctx.getBasicCronInput(theVmObject, 'config.cronExpression')
                    ]
                ),
                ctx.getRowFieldContainer(
                    [
                        ctx.getAdvancedCronInput(theVmObject, 'config.cronExpression')
                    ], {
                    layout: 'fit'
                }
                )
            ];

            return items;
        },

        getSettingsPanel: function (theVmObject, step, data, ctx) {
            var items = [
                ctx.getRowFieldContainer(
                    [
                        ctx.getRowFieldContainer(
                            [
                                ctx.getETLGateTemplateInput(theVmObject, 'config.gateconfig_handlers_1_target', {
                                    allowBlank: false
                                })
                            ]
                        ),

                        ctx.getRowFieldContainer(
                            [
                                ctx.getDWGSourceTypeInput(theVmObject, 'config.gateconfig_handlers_0_type')
                            ]
                        ),

                        ctx.getRowFieldContainer(
                            [
                                ctx.getDirectoryInput(theVmObject, 'config.gateconfig_handlers_0_directory', {
                                    allowBlank: true
                                }),
                                ctx.getFilepatternInput(theVmObject, 'config.gateconfig_handlers_0_filePattern', {
                                    allowBlank: true
                                })
                            ], {
                            bind: {
                                hidden: '{' + theVmObject + '.config.gateconfig_handlers_0_type !== "filereader"}'
                            },
                            hidden: true,
                            listeners: {
                                hide: function (component, eOpts) {
                                    var directoryInput = component.down('#gateconfig_handlers_0_directory_input');
                                    directoryInput.setValue('');
                                    CMDBuildUI.util.administration.helper.FieldsHelper.setAllowBlank(directoryInput, true, directoryInput.up('form'));

                                    var filePatternInput = component.down('#gateconfig_handlers_0_filePattern_input');
                                    filePatternInput.setValue('');
                                },
                                show: function (component, eOpts) {
                                    var directoryInput = component.down('#gateconfig_handlers_0_directory_input');
                                    CMDBuildUI.util.administration.helper.FieldsHelper.setAllowBlank(directoryInput, false, directoryInput.up('form'));
                                }
                            }
                        }
                        ),
                        ctx.getRowFieldContainer(
                            [
                                ctx.getPostImportActionInput(theVmObject, 'config.gateconfig_handlers_0_postImportAction'),
                                ctx.getTargetDirectoryInput(theVmObject, 'config.gateconfig_handlers_0_targetDirectory', {
                                    allowBlank: true,
                                    fieldcontainer: {
                                        bind: {
                                            hidden: '{!isMoveFiles}'
                                        },
                                        hidden: true,
                                        listeners: {
                                            hide: function (component, eOpts) {
                                                var input = component.down('#gateconfig_handlers_0_targetDirectory_input');
                                                input.setValue('');
                                                CMDBuildUI.util.administration.helper.FieldsHelper.setAllowBlank(input, true, input.up('form'));
                                            },
                                            show: function (component, eOpts) {
                                                var input = component.down('#gateconfig_handlers_0_targetDirectory_input');
                                                CMDBuildUI.util.administration.helper.FieldsHelper.setAllowBlank(input, false, input.up('form'));
                                            }
                                        }
                                    }
                                })
                            ], {
                            hidden: true,
                            bind: {
                                hidden: '{' + theVmObject + '.config.gateconfig_handlers_0_type !== "filereader"}'
                            },
                            listeners: {
                                hide: function (component, eOpts) {
                                    var postImportActionInput = component.down('#gateconfig_handlers_0_postImportAction_input');
                                    postImportActionInput.setValue('');
                                    CMDBuildUI.util.administration.helper.FieldsHelper.setAllowBlank(postImportActionInput, true, postImportActionInput.up('form'));
                                },
                                show: function (component, eOpts) {
                                    var postImportActionInput = component.down('#gateconfig_handlers_0_postImportAction_input');
                                    CMDBuildUI.util.administration.helper.FieldsHelper.setAllowBlank(postImportActionInput, false, postImportActionInput.up('form'));
                                }
                            }
                        }
                        ),

                        ctx.getRowFieldContainer(
                            [
                                ctx.getURLInput(theVmObject, 'config.gateconfig_handlers_0_url', {
                                    allowBlank: true
                                })
                            ], {
                            bind: {
                                hidden: '{' + theVmObject + '.config.gateconfig_handlers_0_type !== "urlreader"}'
                            },
                            hidden: true,
                            listeners: {
                                hide: function (component, eOpts) {
                                    var directoryInput = component.down('#gateconfig_handlers_0_url_input');
                                    directoryInput.setValue('');
                                    CMDBuildUI.util.administration.helper.FieldsHelper.setAllowBlank(directoryInput, true, directoryInput.up('form'));
                                },
                                show: function (component, eOpts) {
                                    var directoryInput = component.down('#gateconfig_handlers_0_url_input');
                                    CMDBuildUI.util.administration.helper.FieldsHelper.setAllowBlank(directoryInput, false, directoryInput.up('form'));
                                }
                            }
                        }
                        )
                    ]
                )
            ];

            return items;
        },

        getNotificationPanel: function (theVmObject, step, data, ctx) {
            var items = [

                ctx.getRowFieldContainer([
                    ctx.getNotificationInput(theVmObject, 'config.notificationMode')
                ]),
                ctx.getRowFieldContainer([
                    /*
                     * Error email template: combo con elenco dei template delle email. Placeholder: Use the one defined in template.
                     * Account: combo con elenco degli account. Placeholder: Use the one defined in template.
                     */
                    ctx.getRowFieldContainer(
                        [
                            ctx.getErrorEmailTemplateInput(theVmObject, 'config.errorTemplate'),
                            ctx.getErrorEmailAccountInput(theVmObject, 'config.errorAccount')
                        ], {
                        bind: {
                            // hidden: '{!isImport}'
                        }
                    }),
                    /**
                     * email template: combo con elenco dei template delle email. Placeholder: Use the one defined in template.
                     * Account: combo con elenco degli account. Placeholder: Use the one defined in template.
                     */

                    ctx.getRowFieldContainer(
                        [
                            ctx.getNotificationEmailTemplateInput(theVmObject, 'config.notificationTemplate'),
                            ctx.getAttachImportReport(theVmObject, 'config.attachImportReport')
                        ], {
                        bind: {
                            // hidden: '{!isImport}'
                        }
                    })
                ], {
                    bind: {
                        hidden: '{isNeverNotification}'
                    },
                    hidden: true,
                    listeners: {
                        hide: function (component, eOpts) {
                            var input = component.down('#notificationTemplate_input');
                            input.setValue('');
                            CMDBuildUI.util.administration.helper.FieldsHelper.setAllowBlank(input, true, input.up('form'));
                        },
                        show: function (component, eOpts) {
                            var input = component.down('#notificationTemplate_input');
                            CMDBuildUI.util.administration.helper.FieldsHelper.setAllowBlank(input, false, input.up('form'));
                        }
                    }
                })


            ];

            return items;
        },

        validateForm: function (form) {

            var _form = form.form,
                vm = form.lookupViewModel(),
                invalid = [];
            _form.getFields().items.forEach(function (field) {
                if (!field.validate()) {
                    invalid.push(field);
                }
            });

            invalid = CMDBuildUI.util.administration.helper.CronValidatorHelper.taskCronValidation(vm, invalid);
            if (invalid.length) {
                CMDBuildUI.util.administration.helper.FormHelper.showInvalidFieldsMessage({ items: invalid });
            }

            return invalid;
        },
        setAllowBlank: function (field, value, form) {
            CMDBuildUI.util.administration.helper.FieldsHelper.setAllowBlank(field, value, form);
        }

    }



});