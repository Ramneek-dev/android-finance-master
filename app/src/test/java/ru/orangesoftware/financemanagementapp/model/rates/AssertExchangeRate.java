package ru.orangesoftware.financemanagementapp.model.rates;

import ru.orangesoftware.financemanagementapp.db.AbstractDbTest;
import ru.orangesoftware.financemanagementapp.rates.ExchangeRate;
import ru.orangesoftware.financemanagementapp.test.DateTime;

import static org.junit.Assert.*;

public abstract class AssertExchangeRate extends AbstractDbTest {

    public static void assertRate(DateTime date, double rate, ExchangeRate r) {
        assertEquals(rate, r.rate, 0.00001d);
        assertEquals(date.atMidnight().asLong(), r.date);
    }

}
