package com.jhon;

import java.io.*;
import java.net.*;





public class ClienteAdivina {

        public static void main(String[] args) throws IOException {
        // Cambia "localhost" por la IP real si te conectas desde otro
        Socket socket = new Socket("localhost", 5000);

        BufferedReader in = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader teclado = new BufferedReader(
            new InputStreamReader(System.in));

        String mensajeServidor;
        while ((mensajeServidor = in.readLine()) != null) {
            System.out.println("Servidor: " + mensajeServidor);

            if (mensajeServidor.contains("¡Correcto!")) {
                break; // Termina el juego si aciertas
            }

            System.out.print("Tu intento: ");
            String intento = teclado.readLine();
            out.println(intento);
        }

        socket.close();
    }
}


    


