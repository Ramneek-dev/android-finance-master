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
import ru.orangesoftware.financemanagementapp.model.Category;
import ru.orangesoftware.financemanagementapp.model.Currency;

import static ru.orangesoftware.financemanagementapp.db.DatabaseHelper.V_REPORT_CATEGORY;

public class CategoryReportAll extends Report {

	public CategoryReportAll(Context context, Currency currency) {
		super(ReportType.BY_CATEGORY, context, currency);
	}

	@Override
	public ReportData getReport(DatabaseAdapter db, WhereFilter filter) {
        cleanupFilter(filter);
		return queryReport(db, V_REPORT_CATEGORY, filter);
	}
	
	@Override
	public Criteria getCriteriaForId(DatabaseAdapter db, long id) {
		Category c = db.getCategoryWithParent(id);
		return Criteria.btw(BlotterFilter.CATEGORY_LEFT, String.valueOf(c.left), String.valueOf(c.right));
	}

    @Override
    public boolean shouldDisplayTotal() {
        return false;
    }

    @Override
    protected Class<? extends BlotterActivity> getBlotterActivityClass() {
        return SplitsBlotterActivity.class;
    }

}
