package ru.orangesoftware.financemanagementapp.utils;

import android.content.Context;

import com.mtramin.rxfingerprint.RxFingerprint;

import ru.orangesoftware.financemanagementapp.R;

public class FingerprintUtils {

    public static boolean fingerprintUnavailable(Context context) {
        return RxFingerprint.isUnavailable(context);
    }

    public static String reasonWhyFingerprintUnavailable(Context context) {
        if (!RxFingerprint.isHardwareDetected(context)) {
            return context.getString(R.string.fingerprint_unavailable_hardware);
        } else if (!RxFingerprint.hasEnrolledFingerprints(context)) {
            return context.getString(R.string.fingerprint_unavailable_enrolled_fingerprints);
        } else {
            return context.getString(R.string.fingerprint_unavailable_unknown);
        }
    }

}
