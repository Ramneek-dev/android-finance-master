package ru.orangesoftware.financemanagementapp.utils;

import android.content.Context;

import ru.orangesoftware.financemanagementapp.R;

import static ru.orangesoftware.financemanagementapp.utils.AndroidUtils.isInstalledOnSdCard;

public class IntegrityCheckInstalledOnSdCard implements IntegrityCheck {

    private final Context context;

    public IntegrityCheckInstalledOnSdCard(Context context) {
        this.context = context;
    }

    @Override
    public Result check() {
        if (isInstalledOnSdCard(context)) {
            return new Result(Level.WARN, context.getString(R.string.installed_on_sd_card_warning));
        }
        return Result.OK;
    }

}
