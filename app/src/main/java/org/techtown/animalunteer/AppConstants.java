package org.techtown.animalunteer;

import android.os.Handler;
import android.util.Log;

public class AppConstants {
    public static String DATABASE_NAME = "memo.db";

    public static final int MODE_INSERT = 1;
    public static final int MODE_MODIFY = 2;

    private static Handler handler = new Handler();
    private static final String TAG = "AppConstants";
    public static void println(final String data) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, data);
            }
        });
    }
}
