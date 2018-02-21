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

public class ClientThread extends Thread {

    private Socket socket;
    private String HOST_NAME = "localhost";
    private int PORT_NUMBER = 9000;

    String messageFromServer = null;
    String messageToServer = null;

    BufferedReader inFromServer = null;
    PrintWriter outToServer = null;

    ClientHelper helper;

    public ClientThread(ClientHelper helper){
        super();

        System.out.println("in CH constructor");

        this.helper = helper;
    }


    public void run(){
        System.out.println("in CH run");


         try{

             System.out.println("lets create a CH socket");
             socket = new Socket(HOST_NAME, PORT_NUMBER);

             inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

             outToServer = new PrintWriter(socket.getOutputStream(), true);

             Boolean communicating = true;


             while (communicating) {
                 messageFromServer = inFromServer.readLine();
                 helper.setMessageFromServer(messageFromServer);

                 messageToServer = helper.getMessageToServer();
                 outToServer.println(messageToServer);

             }

             return;

         } catch (UnknownHostException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
    }
}
