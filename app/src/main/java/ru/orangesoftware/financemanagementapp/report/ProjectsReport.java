/*******************************************************************************
 * Copyright (c) 2010 Denis Solonenko.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     Denis Solonenko - initial API and implementation
 ******************************************************************************/
package ru.orangesoftware.financemanagementapp.report;

import android.content.Context;
import ru.orangesoftware.financemanagementapp.activity.BlotterActivity;
import ru.orangesoftware.financemanagementapp.activity.SplitsBlotterActivity;
import ru.orangesoftware.financemanagementapp.blotter.BlotterFilter;
import ru.orangesoftware.financemanagementapp.filter.WhereFilter;
import ru.orangesoftware.financemanagementapp.filter.Criteria;
import ru.orangesoftware.financemanagementapp.db.DatabaseAdapter;
import ru.orangesoftware.financemanagementapp.model.Currency;

import static ru.orangesoftware.financemanagementapp.db.DatabaseHelper.V_REPORT_PROJECTS;

public class ProjectsReport extends Report {

	public ProjectsReport(Context context, Currency currency) {
		super(ReportType.BY_PROJECT, context, currency);
	}

	@Override
	public ReportData getReport(DatabaseAdapter db, WhereFilter filter) {
        cleanupFilter(filter);
		return queryReport(db, V_REPORT_PROJECTS, filter);
	}

	@Override
	public Criteria getCriteriaForId(DatabaseAdapter db, long id) {
		return Criteria.eq(BlotterFilter.PROJECT_ID, String.valueOf(id));
	}

    @Override
    protected Class<? extends BlotterActivity> getBlotterActivityClass() {
        return SplitsBlotterActivity.class;
    }

}
