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

import static ru.orangesoftware.financemanagementapp.db.DatabaseHelper.V_REPORT_LOCATIONS;

import ru.orangesoftware.financemanagementapp.R;
import ru.orangesoftware.financemanagementapp.blotter.BlotterFilter;
import ru.orangesoftware.financemanagementapp.filter.WhereFilter;
import ru.orangesoftware.financemanagementapp.filter.Criteria;
import ru.orangesoftware.financemanagementapp.db.DatabaseAdapter;
import android.content.Context;
import ru.orangesoftware.financemanagementapp.model.Currency;

public class LocationsReport extends Report {

	public LocationsReport(Context context, Currency currency) {
		super(ReportType.BY_LOCATION, context, currency);
	}

	@Override
	public ReportData getReport(DatabaseAdapter db, WhereFilter filter) {
        cleanupFilter(filter);
		return queryReport(db, V_REPORT_LOCATIONS, filter);
	}

	@Override
	protected String alterName(long id, String name) {
		return id == 0 ? context.getString(R.string.no_fix) : name;
	}

	@Override
	public Criteria getCriteriaForId(DatabaseAdapter db, long id) {
		return Criteria.eq(BlotterFilter.LOCATION_ID, String.valueOf(id));
	}		
	
}
