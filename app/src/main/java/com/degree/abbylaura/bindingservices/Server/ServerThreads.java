package com.degree.abbylaura.bindingservices.Server;

/**
 * Created by abbylaura on 21/02/2018.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThreads extends Thread{

    private Socket clientSocket;

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
            outToClient.println("Connection accepted");
            System.out.println("Connection accepted");

            String response = null;
            String previous = null;

            int count = 0;

            while(communicating){

                System.out.println("communicating");

                response = inFromClient.readLine();

                if(!response.equals(previous)){ //if message from client is not the same as last
                    count ++;
                    outToClient.println(String.valueOf(count));
                }

                previous = response;

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

