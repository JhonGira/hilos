package com.jhon;
import java.util.Scanner;



public class Main{

	static class CantidadHilos{
        public static int cantidad;

    }



	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);

		System.out.print("Escriba la cantidad de hilos desea agregar: ");
		CantidadHilos.cantidad = sc.nextInt();

		Descargar[] des = new Descargar[CantidadHilos.cantidad];
		
		
		for (int i = 0; i < CantidadHilos.cantidad; i++){
			des[i] = new Descargar();	
			des[i].start();
			des[i].join();
		}
		
		Guardar gua = new Guardar();
		gua.start();
		gua.join();

		
		MostrarUbicacion mos = new MostrarUbicacion();
		mos.start();
		
		
		
		
		
		
		
	}


}