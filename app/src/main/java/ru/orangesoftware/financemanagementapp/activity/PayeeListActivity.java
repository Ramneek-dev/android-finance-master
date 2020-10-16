/*******************************************************************************
 * Copyright (c) 2010 Denis Solonenko.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * <p/>
 * Contributors:
 * Denis Solonenko - initial API and implementation
 ******************************************************************************/
package ru.orangesoftware.financemanagementapp.activity;

import ru.orangesoftware.financemanagementapp.R;
import ru.orangesoftware.financemanagementapp.blotter.BlotterFilter;
import ru.orangesoftware.financemanagementapp.filter.Criteria;
import ru.orangesoftware.financemanagementapp.model.Payee;

public class PayeeListActivity extends MyEntityListActivity<Payee> {

    public PayeeListActivity() {
        super(Payee.class, R.string.no_payees);
    }

    @Override
    protected Class<PayeeActivity> getEditActivityClass() {
        return PayeeActivity.class;
    }

    @Override
    protected Criteria createBlotterCriteria(Payee p) {
        return Criteria.eq(BlotterFilter.PAYEE_ID, String.valueOf(p.id));
    }

}
