/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cmdbuild.dao.driver.postgres.q3.stats;

import java.util.List;

public interface DaoStatsQueryOptions {

    List<AggregateQuery> getAggregateQueries();

}
