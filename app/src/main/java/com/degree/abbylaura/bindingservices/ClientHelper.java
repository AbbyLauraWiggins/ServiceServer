package com.degree.abbylaura.bindingservices;

/**
 * Created by abbylaura on 21/02/2018.
 */

public class ClientHelper {

    public static String messageFromServer = null;
    public static String messageToServer = null;


    public ClientHelper(){
        super();
    }



    public static void setMessageToServer(String message){
        messageToServer = message;
        //System.out.println("message to server: " + message);
    }


    public static void setMessageFromServer(String message){
        messageFromServer = message;
        //System.out.println("message from server: " + message);
    }


}
