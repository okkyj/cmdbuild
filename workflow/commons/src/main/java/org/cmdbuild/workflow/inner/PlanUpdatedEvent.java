/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cmdbuild.workflow.inner;

public interface PlanUpdatedEvent {

    String getPlanId();

    String getClassId();

}
