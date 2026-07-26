package com.jhon;
import java.io.*;
import java.net.*;
import java.util.*;

public class ServerJuego {

		public static int min(int contador) {
		if (contador >= 0 && contador < 5) {
			return 1;
			
		}else if (contador >= 5 && contador < 10) {
			return 10;
		}else if (contador >= 10 && contador < 15){
			return 20;
		}
		return -1;
	}
	
	public static int max(int contador) {
		if (contador >= 0 && contador < 5) {
			return 10;
			
		}else if (contador >= 5 && contador < 10) {
			return 20;
		}else if (contador >= 10 && contador < 15) {
			return 30;
		}
		return -1;
		
	}

	
	public static void inicio(PrintWriter out, BufferedReader in){
		
			out.println("Quiz de operaciones matematicas on aumento de dificultad. Presione s para empezar.");
			String iniciar;
            while (true) {
				try {
					iniciar = in.readLine();
					if (iniciar.equals("s")){
						break;
					}else{
						out.println("Tecla incorrecta.");
					}
							
				} catch (Exception e) {
					e.printStackTrace();
				}
						
			}
		}               	
	

	public static void PluralSingular(int puntos, Socket socket){
		if(puntos == 1){
			System.out.println("Usuario " + socket + " acerto " + puntos + " operacion.");
		}else{
			System.out.println("Usuario " + socket + " acerto " + puntos + " operaciones.");
		}

	}



  
    public static void main(String[] args) throws IOException {
        
        ServerSocket servidor = new ServerSocket(5000);
        System.out.println("Servidor iniciado en el puerto 5000.");


        while (true) {
            Socket socket = servidor.accept();
            System.out.println("Usuario conectado "+ socket);

            new Thread(() -> {
                try {
                    BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                    
                    PrintWriter out = new PrintWriter(
                        socket.getOutputStream(), true);

					inicio(out, in);

                    String entrada;
                    int puntos = 0;
                   	int contador = 0; 
					  
                    while (contador < 15) {

							int tope1 = min(contador);
							int tope2 = max(contador);
		
							int num1 = new Random().nextInt((tope2 - tope1)+1) + tope1 ;
							int num2 = new Random().nextInt((tope2 - tope1)+1) + tope1 ;

			                String[] operadores = {"+","-","*","/"};
			                Random random = new Random();
			                String operador = operadores[random.nextInt(operadores.length)];
			
			                if (operador == "+") {
				                out.println(num1 + " + " + num2);
								
								while (true) {
									try{
									entrada = in.readLine();
				                	int respuesta = Integer.parseInt(entrada);
				                	if ((num1 + num2) == respuesta) {
					                	puntos++;
					                	contador++;
										break;
				                	}else {
					                	puntos = puntos + 0;
                                    	contador++;
										break;
				                	}
									}catch(NumberFormatException e){
										out.println("El dato ingresado no es un numero entero.");
									}
								}
							

				
			                }else if (operador == "-") {
				                out.println(num1 + " - " + num2);

								while (true) {
									try{
									entrada = in.readLine();
				                	int respuesta = Integer.parseInt(entrada);
				                	if ((num1 - num2) == respuesta) {
					                	puntos++;
					                	contador++;
										break;
				                	}else {
					                	puntos = puntos + 0;
                                    	contador++;
										break;
				                	}
									}catch(NumberFormatException e){
										out.println("El dato ingresado no es un numero entero.");
									}
								}
						
						
			                }else if(operador == "*"){
				                out.println(num1 + " * " + num2);

								while (true) {
									try{
									entrada = in.readLine();
				                	int respuesta = Integer.parseInt(entrada);
				                	if ((num1 * num2) == respuesta) {
					                	puntos++;
					                	contador++;
										break;
				                	}else {
					                	puntos = puntos + 0;
                                    	contador++;
										break;
				                	}
									}catch(NumberFormatException e){
										out.println("El dato ingresado no es un numero entero.");
									}
								}
						
			                }                                                          
                    }
                    out.println("Respuestas correctas: " + puntos);
					PluralSingular(puntos, socket);
					
					
                    socket.close();


                } catch (IOException e) {
                    e.printStackTrace();
                }

            }).start();
            
        }
        

    }

}
