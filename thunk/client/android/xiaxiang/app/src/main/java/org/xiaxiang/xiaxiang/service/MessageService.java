package org.xiaxiang.xiaxiang.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by gz on 2016/8/13.
 */
public class MessageService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
