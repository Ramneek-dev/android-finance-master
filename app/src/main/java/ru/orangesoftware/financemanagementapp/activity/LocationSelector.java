package ru.orangesoftware.financemanagementapp.activity;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import java.util.List;

import ru.orangesoftware.financemanagementapp.R;
import ru.orangesoftware.financemanagementapp.db.DatabaseAdapter;
import ru.orangesoftware.financemanagementapp.db.MyEntityManager;
import ru.orangesoftware.financemanagementapp.model.MyLocation;
import ru.orangesoftware.financemanagementapp.utils.MyPreferences;
import ru.orangesoftware.financemanagementapp.utils.TransactionUtils;

public class LocationSelector<A extends AbstractActivity> extends MyEntitySelector<MyLocation, A> {

    public LocationSelector(A activity, DatabaseAdapter db, ActivityLayout x) {
        this(activity, db, x, R.string.current_location);
    }

    public LocationSelector(A activity, DatabaseAdapter db, ActivityLayout x, int emptyId) {
        super(MyLocation.class, activity, db, x, MyPreferences.isShowLocation(activity),
                R.id.location, R.id.location_add, R.id.location_clear, R.string.location, emptyId,
                R.id.location_show_list, R.id.location_close_filter, R.id.location_show_filter);
    }

    @Override
    protected Class getEditActivityClass() {
        return LocationActivity.class;
    }

    @Override
    protected List<MyLocation> fetchEntities(MyEntityManager em) {
        return em.getActiveLocationsList(true);
    }

    @Override
    protected ListAdapter createAdapter(Activity activity, List<MyLocation> entities) {
        return TransactionUtils.createLocationAdapter(activity, entities);
    }

    @Override
    protected ArrayAdapter<MyLocation> createFilterAdapter() {
        return TransactionUtils.locationFilterAdapter(activity, em);
    }

    @Override
    protected boolean isListPickConfigured() {
        return MyPreferences.isLocationSelectorList(activity);
    }

}
