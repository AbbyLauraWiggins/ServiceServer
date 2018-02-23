package com.degree.abbylaura.bindingservices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by abbylaura on 21/02/2018.
 */

public class Client {


    String clientID = null;
    ClientThread thread;

    String msg;
    //ClientHelper helper;

    public Client(String clientID) {
        super();
        System.out.println("in client constructor");

        this.clientID = clientID;

        //helper = new ClientHelper(clientID);



    }



    public void setMessageToServer(String message){
        msg = message;


        thread = new ClientThread(msg);

        thread.start();
    }

    public String getMessageFromServer(){
        //return thread.getMessageFromServer();
        thread.interrupt();
        return ClientHelper.messageFromServer;
    }

}
