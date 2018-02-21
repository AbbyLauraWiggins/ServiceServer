package com.degree.abbylaura.bindingservices;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    BoundService boundService;
    boolean bound = false;

    TextView messageFromServer;
    EditText messageToServer;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageFromServer = (TextView) findViewById(R.id.message_from_server);
        messageToServer = (EditText) findViewById(R.id.message_to_server);
        send = (Button) findViewById(R.id.send_button);


    }

    public void onSendClick(View view) {

        if(bound){
            System.out.println("on click: " + messageToServer);

            boundService.setMessageToServer(messageToServer.getText().toString());

            messageFromServer.setText(boundService.getMessageFromServer());
        } else{
            System.out.println("SERVICE NOT BOUND");
        }


    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("in MA onstart");
        Intent intent = new Intent(this, BoundService.class);

        //startService(intent); //unsure if needed

        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("in MA onstop");

        unbindService(serviceConnection);
        bound = false;
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            System.out.println("in MA onserviceconnect");


            BoundService.MyBinder myBinder = (BoundService.MyBinder) iBinder;
            boundService = myBinder.getService();
            bound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            System.out.println("in MA onserviceDISconnected");

            bound = false;
        }
    };
}
