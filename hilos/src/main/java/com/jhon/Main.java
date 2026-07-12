package com.jhon;
import java.util.Scanner;


public class Main {
	
public static void ImprimirUbicacion(String[] ubicacion){
		
		int indice = 0;
		
		while(true) {
			if (ubicacion[indice] != null) {
				System.out.print(ubicacion[indice] + ",");
				indice++;
			}else {
				break;
			}
		}
		
	}

		
	
	
	public static void main(String[] args) throws InterruptedException {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("Escriba la cantidad de hilos desea agregar: ");
		int cantidad = sc.nextInt();
		sc.nextLine();
		
		TareaDescargas[] hilos =  new TareaDescargas[cantidad];
		
		
		
		
		for (int i = 0;i < cantidad; i++) {
			System.out.print("Escriba el tipo de archivo que quiere descargar: ");
			String fichero = sc.nextLine();
			
			System.out.print("Escriba el destino de guardado(descargas o documentos): ");
			String destino = sc.nextLine();
			hilos[i] = new TareaDescargas(fichero, destino);
            hilos[i].setName("Descarga " + (i+1));
            
		}

		System.out.println();
		for (int i = 0;i < cantidad;i++) {
            System.out.println(hilos[i].getName() + " iniciada...");
			hilos[i].start();
		}
		
		for (int i = 0;i < cantidad;i++) {
			hilos[i].join();
		}
		
		
		System.out.print("\nDescargas: ");
		for (int i = 0;i < cantidad;i++) {
			ImprimirUbicacion(hilos[i].descargas);
		}
		
		System.out.print("\nDocumentos: ");
		for (int i = 0;i < cantidad;i++) {
			ImprimirUbicacion(hilos[i].documentos);
		}
		

	}

}