package com.jhon;

public class TareaDescargas extends Thread {
	
	public String[] descargas = new String[100];
	public String[] documentos = new String[100];
	
	private String archivo;
	private String ubicacion;
	
	public TareaDescargas(String archivo, String ubicacion) {
		this.archivo = archivo;
		this.ubicacion = ubicacion;
	}
	
	public static void InsertarArchivo(String[] ubicacion, String archivo ) {
		int indice = 0;
		
		while(true) {
			if (ubicacion[indice] == null) {
				ubicacion[indice] = archivo;
				break;
			}else {
				indice++;
			}	
		}	
		
	}
	
	
	public static void dormir() {
		 try {
             Thread.sleep(1000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
	}
	
	
	@Override
	public void run() {
		System.out.println("Descargando " + archivo + ".....");
		dormir();
		System.out.println(archivo + " guardado en " + ubicacion);
		dormir();
		
		switch (ubicacion.toLowerCase()) {
		case "descargas":
			InsertarArchivo(descargas, archivo);
			break;
			
		case "documentos":
			InsertarArchivo(documentos, archivo);
			break;
			
		default:
			System.out.println("Ubicacion no encontrada.");;
		}
			
	}
}