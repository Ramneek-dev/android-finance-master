package ru.orangesoftware.financemanagementapp.app;

import android.content.Context;
import android.content.res.Configuration;
import androidx.multidex.MultiDexApplication;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EApplication;

import ru.orangesoftware.financemanagementapp.bus.GreenRobotBus;
import ru.orangesoftware.financemanagementapp.export.drive.GoogleDriveClient;
import ru.orangesoftware.financemanagementapp.utils.MyPreferences;

@EApplication
public class FinancistoApp extends MultiDexApplication {

    @Bean
    public GreenRobotBus bus;

    @Bean
    public GoogleDriveClient driveClient;

    @AfterInject
    public void init() {
        bus.register(driveClient);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(MyPreferences.switchLocale(base));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        MyPreferences.switchLocale(this);
    }
}
