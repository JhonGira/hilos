package com.jhon;



public class MostrarUbicacion extends Thread {

	

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

	@Override

	public void run(){

		System.out.print("\nDescargas: ");
		
		ImprimirUbicacion(listas.descargas);
		
		
		System.out.print("\nDocumentos: ");
		
		ImprimirUbicacion(listas.documentos);
		
		

	}
	}







	
