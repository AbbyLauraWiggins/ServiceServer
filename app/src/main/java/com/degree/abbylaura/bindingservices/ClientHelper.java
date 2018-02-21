package com.degree.abbylaura.bindingservices;

/**
 * Created by abbylaura on 21/02/2018.
 */

public class ClientHelper {

    String messageFromServer = null;
    String messageToServer = null;
    String clientID = null;

    public ClientHelper(String clientID){
        super();

        this.clientID = clientID;
    }



    public void setMessageToServer(String message){
        System.out.println("in client helper set message to server");

        messageToServer = message;
    }

    public String getMessageToServer(){
        System.out.println("in client helper get message to server");

        return messageToServer;
    }




    public String getMessageFromServer(){
        System.out.println("in client helper getmessage from server");

        return messageFromServer;
    }

    public void setMessageFromServer(String message){
        System.out.println("in client helper set message from server");

        messageFromServer = message;
    }
}
