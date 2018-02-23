package com.degree.abbylaura.bindingservices;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import static com.degree.abbylaura.bindingservices.ClientHelper.setMessageFromServer;

/**
 * Created by abbylaura on 21/02/2018.
 */

public class ClientThread extends Thread {

    private Socket socket;
    private static final String TAG = "ClientThread";

    String messageFromServer = null;
    String messageToServer = null;

    BufferedReader inFromServer = null;
    PrintWriter outToServer = null;

    //ClientHelper helper;

    public ClientThread(String msg) {
        super();
        this.messageToServer = msg;

    }





    public void run(){


         try{

             socket = new Socket("10.0.2.2", 9000);

             inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

             outToServer = new PrintWriter(socket.getOutputStream(), true);

             Boolean communicating = true;



             while (communicating) {

                 System.out.println("client communicatibg");

                 outToServer.println(messageToServer);


                 setMessageFromServer(inFromServer.readLine());


                 /*

                 response = inFromServer.readLine();
                 //System.out.println(myresponse + " : " + response);
                 myresponse = ClientHelper.messageToServer;

                 if(response.equals("FIRST TO CLIENT")){
                     //outToServer.println(myresponse);
                     ClientHelper.setMessageFromServer(response);

                 }else if(response.equals("SECOND TO CLIENT")){
                     //outToServer.println(myresponse);
                     ClientHelper.setMessageFromServer(response);

                 }else if(response.equals(null)){
                     ClientHelper.setMessageFromServer("message null");

                 }

                 ClientHelper.setMessageFromServer(response);

                 outToServer.println(myresponse);
                // outToServer.flush();

                */




             }

             return;

         } catch (UnknownHostException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
    }
}
