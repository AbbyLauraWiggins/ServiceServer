package com.degree.abbylaura.bindingservices.Server;

/**
 * Created by abbylaura on 21/02/2018.
 */

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThreads extends Thread{

    private Socket clientSocket;
    private static final String TAG = "ServerThread";


    public ServerThreads(Socket clientSocket){
        super();
        this.clientSocket = clientSocket;

        System.out.println("in server threads constructor");
    }

    public void run(){

        System.out.println("in ST run");

        try {
            BufferedReader inFromClient = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));

            PrintWriter outToClient =
                    new PrintWriter(clientSocket.getOutputStream(), true);


            Boolean communicating = true;

            String response = null;
            String myresponse = null;

            outToClient.println("FIRST TO CLIENT");

            while(communicating){


                response = inFromClient.readLine();

                outToClient.println("Server recieved: " + response);



            }

            clientSocket.close();
            return;



        } catch (IOException e) {
            e.printStackTrace();


        } finally {
            try{
                clientSocket.close();
            }

            catch (IOException e){
                e.printStackTrace();
            }
        }




    }
}

