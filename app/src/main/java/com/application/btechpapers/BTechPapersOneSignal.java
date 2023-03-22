package com.application.btechpapers;

import android.app.Application;

import com.onesignal.OneSignal;

public class BTechPapersOneSignal extends Application {
    private static final String ONESIGNAL_APP_ID = "37f6f867-26b7-4e28-b04d-855f6afc0463";
    @Override
    public void onCreate() {
        super.onCreate();

        // OneSignal Initialization
        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);

    }
}
