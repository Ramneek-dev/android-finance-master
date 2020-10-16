/*
 * Copyright (c) 2012 Denis Solonenko.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 */
package ru.orangesoftware.financemanagementapp.blotter;

import android.content.Context;
import android.widget.TextView;
import ru.orangesoftware.financemanagementapp.db.DatabaseAdapter;
import ru.orangesoftware.financemanagementapp.db.TransactionsTotalCalculator;
import ru.orangesoftware.financemanagementapp.filter.WhereFilter;
import ru.orangesoftware.financemanagementapp.model.Total;

public class BlotterTotalCalculationTask extends TotalCalculationTask {

	private final DatabaseAdapter db;
	private final WhereFilter filter;

	public BlotterTotalCalculationTask(Context context, DatabaseAdapter db, WhereFilter filter, TextView totalText) {
        super(context, totalText);
		this.db = db;
		this.filter = filter;
	}

    @Override
    public Total getTotalInHomeCurrency() {
        TransactionsTotalCalculator calculator = new TransactionsTotalCalculator(db, filter);
        return calculator.getBlotterBalanceInHomeCurrency();
    }

    @Override
    public Total[] getTotals() {
        TransactionsTotalCalculator calculator = new TransactionsTotalCalculator(db, filter);
        return calculator.getTransactionsBalance();
    }

}
