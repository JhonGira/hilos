package com.jhon;
import java.net.*;
import java.io.*
;

public class ClienteJuego {

    public static void main(String[] args) throws UnknownHostException, IOException{

        Socket socket = new Socket("localhost", 5000);

        BufferedReader in = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader tecaldo = new BufferedReader(new InputStreamReader(System.in));

        String servidor;
        while((servidor = in.readLine()) != null){
            System.out.println("Servidor: " + servidor);

            if (servidor.contains("correctas")){
                break;
            }
            System.out.print("Respuesta: ");
            String respuesta = tecaldo.readLine();
            out.println(respuesta);


        }
        
                 
        socket.close();


    }

}
