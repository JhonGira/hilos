package com.jhon;

import java.io.*;
import java.net.*;
import java.util.*;

public class ServerAdivina {

        public static void main(String[] args) throws IOException {

        ServerSocket servidor = new ServerSocket(5000);
        System.out.println("Servidor iniciado en el puerto 5000...");

        int numeroSecreto = new Random().nextInt(100) + 1;
        //System.out.println("Número secreto generado: " + numeroSecreto);

        while (true) {
            Socket socket = servidor.accept();
            System.out.println("Cliente conectado: " + socket);

            new Thread(() -> {
                try {
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));

                    PrintWriter out = new PrintWriter(
                            socket.getOutputStream(), true);

                    out.println("Bienvenido al juego. Adivina un número entre 1 y 100.");
                    

                    String mensaje;
                    while ((mensaje = in.readLine()) != null) {
                        try {
                            int intento = Integer.parseInt(mensaje);

                            if (intento < numeroSecreto) {
                                out.println("Muy bajo");
                            } else if (intento > numeroSecreto) {
                                out.println("Muy alto");
                            } else {
                                out.println("¡Correcto! El número era " + numeroSecreto);
                                System.out.println("Cliente " + socket + " adivinó el número.");
                                break;
                            }

                        } catch (NumberFormatException e) {
                            out.println("Por favor, ingresa un número válido.");
                        }
                    }

                    socket.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}


