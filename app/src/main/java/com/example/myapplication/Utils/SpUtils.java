package com.example.myapplication.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;

import com.example.myapplication.AccountConstants;
import com.example.myapplication.R;


public final class SpUtils{
    private static final String KEY_ENTERPRISE_UPDATE_ID = "enterprise_update_id";

    private static SharedPreferences getWritePreferences( Context context, String key) {
        SharedPreferences preferences = null;
        try {
            String packageName = context.getResources().getText(R.string.app_share_package).toString();
            Context targetContext = context.createPackageContext(packageName, Context.CONTEXT_RESTRICTED);
            preferences = targetContext.getSharedPreferences(key, Context.MODE_PRIVATE |
                    Activity.MODE_PRIVATE);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return preferences;
    }

    private static SharedPreferences getReadPreferences( Context context, String key) {
        SharedPreferences preferences = null;
        try {
            String packageName = context.getResources().getText(R.string.app_share_package).toString();
                Context targetContext = context.createPackageContext(packageName, Context.CONTEXT_RESTRICTED);
            preferences = targetContext.getSharedPreferences(key, Context.MODE_PRIVATE | Activity.MODE_PRIVATE);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return preferences;
    }

    public static void setValue(Context context, String key, String value) {
        setPreferences(context, key, value);
    }

    public static String getValue(Context context, String key) {
        return getReadPreferences(context, key).getString(key, AccountConstants.SP_DEFAULT_STR);
    }

    private static void setPreferences(Context context, String key, String value) {
        SharedPreferences preferences = getWritePreferences(context, key);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

}
