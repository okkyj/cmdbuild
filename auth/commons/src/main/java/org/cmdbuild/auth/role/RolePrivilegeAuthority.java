/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cmdbuild.auth.role;

public class RolePrivilegeAuthority {

    /* BEGIN */
    public static final String ADMIN_ALL_AUTHORITY = "ROLE_ADMIN_ALL";
    public static final String ADMIN_ALL_READONLY_AUTHORITY = "ROLE_ADMIN_ALL_READONLY";
    public static final String BASE_ALL_AUTHORITY = "ROLE_BASE_ALL";
    public static final String IMPERSONATE_ALL_AUTHORITY = "ROLE_IMPERSONATE_ALL";
    public static final String BASE_ACCESS_AUTHORITY = "ROLE_BASE_ACCESS";
    public static final String ADMIN_ACCESS_AUTHORITY = "ROLE_ADMIN_ACCESS";
    public static final String SYSTEM_ACCESS_AUTHORITY = "ROLE_SYSTEM_ACCESS";
    public static final String DATA_ALL_READ_AUTHORITY = "ROLE_DATA_ALL_READ";
    public static final String DATA_ALL_WRITE_AUTHORITY = "ROLE_DATA_ALL_WRITE";
    public static final String PROCESS_ALL_EXEC_AUTHORITY = "ROLE_PROCESS_ALL_EXEC";
    public static final String REPORT_ALL_READ_AUTHORITY = "ROLE_REPORT_ALL_READ";
    public static final String VIEW_ALL_READ_AUTHORITY = "ROLE_VIEW_ALL_READ";
    public static final String DATA_ALL_TENANT_AUTHORITY = "ROLE_DATA_ALL_TENANT";
    public static final String ETLGATE_ALL_AUTHORITY = "ROLE_ETLGATE_ALL";
    public static final String CQL_ALL_AUTHORITY = "ROLE_CQL_ALL";
    public static final String BULKUPDATE_ACCESS_AUTHORITY = "ROLE_BULKUPDATE_ACCESS";
    public static final String CHANGEPASSWORD_ACCESS_AUTHORITY = "ROLE_CHANGEPASSWORD_ACCESS";
    public static final String CLASS_ACCESS_AUTHORITY = "ROLE_CLASS_ACCESS";
    public static final String CUSTOMPAGES_ACCESS_AUTHORITY = "ROLE_CUSTOMPAGES_ACCESS";
    public static final String DASHBOARD_ACCESS_AUTHORITY = "ROLE_DASHBOARD_ACCESS";
    public static final String DATAVIEW_ACCESS_AUTHORITY = "ROLE_DATAVIEW_ACCESS";
    public static final String EXPORTCSV_ACCESS_AUTHORITY = "ROLE_EXPORTCSV_ACCESS";
    public static final String IMPORTCSV_ACCESS_AUTHORITY = "ROLE_IMPORTCSV_ACCESS";
    public static final String PROCESS_ACCESS_AUTHORITY = "ROLE_PROCESS_ACCESS";
    public static final String REPORT_ACCESS_AUTHORITY = "ROLE_REPORT_ACCESS";
    public static final String CALENDAR_ACCESS_AUTHORITY = "ROLE_CALENDAR_ACCESS";
    public static final String CALENDAR_EVENT_CREATE_AUTHORITY = "ROLE_CALENDAR_EVENT_CREATE";
    public static final String GIS_ACCESS_AUTHORITY = "ROLE_GIS_ACCESS";
    public static final String BIM_ACCESS_AUTHORITY = "ROLE_BIM_ACCESS";
    public static final String RELGRAPH_ACCESS_AUTHORITY = "ROLE_RELGRAPH_ACCESS";
    public static final String ETLGATE_ACCESS_AUTHORITY = "ROLE_ETLGATE_ACCESS";
    public static final String CHAT_ACCESS_AUTHORITY = "ROLE_CHAT_ACCESS";
    public static final String BULK_EDIT_AUTHORITY = "ROLE_BULK_EDIT";
    public static final String BULK_DELETE_AUTHORITY = "ROLE_BULK_DELETE";
    public static final String CARD_TAB_ATTACHMENT_ACCESS_READ_AUTHORITY = "ROLE_CARD_TAB_ATTACHMENT_ACCESS_READ";
    public static final String CARD_TAB_DETAIL_ACCESS_READ_AUTHORITY = "ROLE_CARD_TAB_DETAIL_ACCESS_READ";
    public static final String CARD_TAB_EMAIL_ACCESS_READ_AUTHORITY = "ROLE_CARD_TAB_EMAIL_ACCESS_READ";
    public static final String CARD_TAB_HISTORY_ACCESS_READ_AUTHORITY = "ROLE_CARD_TAB_HISTORY_ACCESS_READ";
    public static final String CARD_TAB_NOTE_ACCESS_READ_AUTHORITY = "ROLE_CARD_TAB_NOTE_ACCESS_READ";
    public static final String CARD_TAB_RELATION_ACCESS_READ_AUTHORITY = "ROLE_CARD_TAB_RELATION_ACCESS_READ";
    public static final String CARD_TAB_SCHEDULE_ACCESS_READ_AUTHORITY = "ROLE_CARD_TAB_SCHEDULE_ACCESS_READ";
    public static final String CARD_TAB_ATTACHMENT_ACCESS_WRITE_AUTHORITY = "ROLE_CARD_TAB_ATTACHMENT_ACCESS_WRITE";
    public static final String CARD_TAB_DETAIL_ACCESS_WRITE_AUTHORITY = "ROLE_CARD_TAB_DETAIL_ACCESS_WRITE";
    public static final String CARD_TAB_EMAIL_ACCESS_WRITE_AUTHORITY = "ROLE_CARD_TAB_EMAIL_ACCESS_WRITE";
    public static final String CARD_TAB_HISTORY_ACCESS_WRITE_AUTHORITY = "ROLE_CARD_TAB_HISTORY_ACCESS_WRITE";
    public static final String CARD_TAB_NOTE_ACCESS_WRITE_AUTHORITY = "ROLE_CARD_TAB_NOTE_ACCESS_WRITE";
    public static final String CARD_TAB_RELATION_ACCESS_WRITE_AUTHORITY = "ROLE_CARD_TAB_RELATION_ACCESS_WRITE";
    public static final String CARD_TAB_SCHEDULE_ACCESS_WRITE_AUTHORITY = "ROLE_CARD_TAB_SCHEDULE_ACCESS_WRITE";
    public static final String FLOW_TAB_ATTACHMENT_ACCESS_READ_AUTHORITY = "ROLE_FLOW_TAB_ATTACHMENT_ACCESS_READ";
    public static final String FLOW_TAB_DETAIL_ACCESS_READ_AUTHORITY = "ROLE_FLOW_TAB_DETAIL_ACCESS_READ";
    public static final String FLOW_TAB_EMAIL_ACCESS_READ_AUTHORITY = "ROLE_FLOW_TAB_EMAIL_ACCESS_READ";
    public static final String FLOW_TAB_HISTORY_ACCESS_READ_AUTHORITY = "ROLE_FLOW_TAB_HISTORY_ACCESS_READ";
    public static final String FLOW_TAB_NOTE_ACCESS_READ_AUTHORITY = "ROLE_FLOW_TAB_NOTE_ACCESS_READ";
    public static final String FLOW_TAB_RELATION_ACCESS_READ_AUTHORITY = "ROLE_FLOW_TAB_RELATION_ACCESS_READ";
    public static final String FLOW_TAB_ATTACHMENT_ACCESS_WRITE_AUTHORITY = "ROLE_FLOW_TAB_ATTACHMENT_ACCESS_WRITE";
    public static final String FLOW_TAB_DETAIL_ACCESS_WRITE_AUTHORITY = "ROLE_FLOW_TAB_DETAIL_ACCESS_WRITE";
    public static final String FLOW_TAB_EMAIL_ACCESS_WRITE_AUTHORITY = "ROLE_FLOW_TAB_EMAIL_ACCESS_WRITE";
    public static final String FLOW_TAB_HISTORY_ACCESS_WRITE_AUTHORITY = "ROLE_FLOW_TAB_HISTORY_ACCESS_WRITE";
    public static final String FLOW_TAB_NOTE_ACCESS_WRITE_AUTHORITY = "ROLE_FLOW_TAB_NOTE_ACCESS_WRITE";
    public static final String FLOW_TAB_RELATION_ACCESS_WRITE_AUTHORITY = "ROLE_FLOW_TAB_RELATION_ACCESS_WRITE";
    public static final String ADMIN_CLASSES_VIEW_AUTHORITY = "ROLE_ADMIN_CLASSES_VIEW";
    public static final String ADMIN_CLASSES_MODIFY_AUTHORITY = "ROLE_ADMIN_CLASSES_MODIFY";
    public static final String ADMIN_PROCESSES_VIEW_AUTHORITY = "ROLE_ADMIN_PROCESSES_VIEW";
    public static final String ADMIN_PROCESSES_MODIFY_AUTHORITY = "ROLE_ADMIN_PROCESSES_MODIFY";
    public static final String ADMIN_DOMAINS_VIEW_AUTHORITY = "ROLE_ADMIN_DOMAINS_VIEW";
    public static final String ADMIN_DOMAINS_MODIFY_AUTHORITY = "ROLE_ADMIN_DOMAINS_MODIFY";
    public static final String ADMIN_LOOKUPS_VIEW_AUTHORITY = "ROLE_ADMIN_LOOKUPS_VIEW";
    public static final String ADMIN_LOOKUPS_MODIFY_AUTHORITY = "ROLE_ADMIN_LOOKUPS_MODIFY";
    public static final String ADMIN_VIEWS_VIEW_AUTHORITY = "ROLE_ADMIN_VIEWS_VIEW";
    public static final String ADMIN_VIEWS_MODIFY_AUTHORITY = "ROLE_ADMIN_VIEWS_MODIFY";
    public static final String ADMIN_DASHBOARDS_VIEW_AUTHORITY = "ROLE_ADMIN_DASHBOARDS_VIEW";
    public static final String ADMIN_DASHBOARDS_MODIFY_AUTHORITY = "ROLE_ADMIN_DASHBOARDS_MODIFY";
    public static final String ADMIN_REPORTS_VIEW_AUTHORITY = "ROLE_ADMIN_REPORTS_VIEW";
    public static final String ADMIN_REPORTS_MODIFY_AUTHORITY = "ROLE_ADMIN_REPORTS_MODIFY";
    public static final String ADMIN_MENUS_VIEW_AUTHORITY = "ROLE_ADMIN_MENUS_VIEW";
    public static final String ADMIN_MENUS_MODIFY_AUTHORITY = "ROLE_ADMIN_MENUS_MODIFY";
    public static final String ADMIN_NAVTREES_VIEW_AUTHORITY = "ROLE_ADMIN_NAVTREES_VIEW";
    public static final String ADMIN_NAVTREES_MODIFY_AUTHORITY = "ROLE_ADMIN_NAVTREES_MODIFY";
    public static final String ADMIN_ROLES_VIEW_AUTHORITY = "ROLE_ADMIN_ROLES_VIEW";
    public static final String ADMIN_ROLES_MODIFY_AUTHORITY = "ROLE_ADMIN_ROLES_MODIFY";
    public static final String ADMIN_USERS_VIEW_AUTHORITY = "ROLE_ADMIN_USERS_VIEW";
    public static final String ADMIN_USERS_MODIFY_AUTHORITY = "ROLE_ADMIN_USERS_MODIFY";
    public static final String ADMIN_JOBS_VIEW_AUTHORITY = "ROLE_ADMIN_JOBS_VIEW";
    public static final String ADMIN_JOBS_MODIFY_AUTHORITY = "ROLE_ADMIN_JOBS_MODIFY";
    public static final String ADMIN_EMAIL_VIEW_AUTHORITY = "ROLE_ADMIN_EMAIL_VIEW";
    public static final String ADMIN_EMAIL_MODIFY_AUTHORITY = "ROLE_ADMIN_EMAIL_MODIFY";
    public static final String ADMIN_UICOMPONENTS_VIEW_AUTHORITY = "ROLE_ADMIN_UICOMPONENTS_VIEW";
    public static final String ADMIN_UICOMPONENTS_MODIFY_AUTHORITY = "ROLE_ADMIN_UICOMPONENTS_MODIFY";
    public static final String ADMIN_CORECOMPONENTS_VIEW_AUTHORITY = "ROLE_ADMIN_CORECOMPONENTS_VIEW";
    public static final String ADMIN_CORECOMPONENTS_MODIFY_AUTHORITY = "ROLE_ADMIN_CORECOMPONENTS_MODIFY";
    public static final String ADMIN_CALENDAR_VIEW_AUTHORITY = "ROLE_ADMIN_CALENDAR_VIEW";
    public static final String ADMIN_CALENDAR_MODIFY_AUTHORITY = "ROLE_ADMIN_CALENDAR_MODIFY";
    public static final String ADMIN_ETL_VIEW_AUTHORITY = "ROLE_ADMIN_ETL_VIEW";
    public static final String ADMIN_ETL_MODIFY_AUTHORITY = "ROLE_ADMIN_ETL_MODIFY";
    public static final String ADMIN_LOCALIZATION_VIEW_AUTHORITY = "ROLE_ADMIN_LOCALIZATION_VIEW";
    public static final String ADMIN_LOCALIZATION_MODIFY_AUTHORITY = "ROLE_ADMIN_LOCALIZATION_MODIFY";
    public static final String ADMIN_GIS_VIEW_AUTHORITY = "ROLE_ADMIN_GIS_VIEW";
    public static final String ADMIN_GIS_MODIFY_AUTHORITY = "ROLE_ADMIN_GIS_MODIFY";
    public static final String ADMIN_BIM_VIEW_AUTHORITY = "ROLE_ADMIN_BIM_VIEW";
    public static final String ADMIN_BIM_MODIFY_AUTHORITY = "ROLE_ADMIN_BIM_MODIFY";
    public static final String ADMIN_SYSCONFIG_VIEW_AUTHORITY = "ROLE_ADMIN_SYSCONFIG_VIEW";
    public static final String ADMIN_SYSCONFIG_MODIFY_AUTHORITY = "ROLE_ADMIN_SYSCONFIG_MODIFY";
    public static final String ADMIN_SEARCHFILTERS_VIEW_AUTHORITY = "ROLE_ADMIN_SEARCHFILTERS_VIEW";
    public static final String ADMIN_SEARCHFILTERS_MODIFY_AUTHORITY = "ROLE_ADMIN_SEARCHFILTERS_MODIFY";
    public static final String ADMIN_DMS_VIEW_AUTHORITY = "ROLE_ADMIN_DMS_VIEW";
    public static final String ADMIN_DMS_MODIFY_AUTHORITY = "ROLE_ADMIN_DMS_MODIFY";
    /* END */
}
