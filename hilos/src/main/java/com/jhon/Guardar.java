package com.jhon;



class listas{
    public static String[] descargas = new String[100];
	public static String[] documentos = new String[100];
}

public class Guardar extends Thread {

    
	
	
	
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
      


		for (int i = 0; Temp.Temporaldesca[i] != null; i++) {
    		System.out.println("Guardando " + Temp.Temporaldesca[i] + " en descargas");
			System.out.println(Temp.Temporaldesca[i] + " guardado en descargas");
    		InsertarArchivo(listas.descargas, Temp.Temporaldesca[i]);

			dormir();
		}

		for (int i = 0; Temp.TemporalDocu[i] != null; i++) {
    		System.out.println("Guardando " + Temp.TemporalDocu[i] + " en documentos");
			System.out.println(Temp.TemporalDocu[i] + " guardado en descargas");
    		InsertarArchivo(listas.documentos, Temp.TemporalDocu[i]);

			dormir();
		
		}

		 
	}
}


