package com.degree.abbylaura.bindingservices;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by abbylaura on 21/02/2018.
 */

public class BoundService extends Service {

    private final IBinder binder = new MyBinder();
    private Client client;

    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("in BS onbind");
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        client = new Client("1");

        System.out.println("in on create");
    }

    public String getMessageFromServer(){
        System.out.println("in BS getmessage");
        return client.getMessageFromServer();
    }

    public void setMessageToServer(String message){
        System.out.println("in BS setmessage");

        client.setMessageToServer(message);
    }

    public class MyBinder extends Binder{
        public BoundService getService(){

            System.out.println("in BS my binder getservice");

            return BoundService.this;
        }
    }
}
