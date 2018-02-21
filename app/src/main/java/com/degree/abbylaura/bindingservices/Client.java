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
    ClientHelper helper;

    public Client(String clientID) {
        super();
        System.out.println("in client constructor");

        this.clientID = clientID;

        helper = new ClientHelper(clientID);


        new ClientThread(helper).start();

    }


    public void setMessageToServer(String message){
        System.out.println("in client set message");

        helper.setMessageToServer(message);
    }

    public String getMessageFromServer(){
        System.out.println("in client getmessage");

        return helper.getMessageFromServer();
    }

}
