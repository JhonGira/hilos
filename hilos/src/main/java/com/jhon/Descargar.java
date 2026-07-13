package com.jhon;
import java.util.Scanner;

class Temp{
    public static String[] Temporaldesca = new String[100];
	public static String[] TemporalDocu = new String[100];
}





 



public class Descargar extends Thread {

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

  
    @Override

    public void run(){

        System.out.println("Ejecutando " + getName());

        Scanner sc = new Scanner(System.in);

          System.out.print("Escriba el tipo de archivo que quiere descargar: ");
		    String archivo = sc.nextLine();
			
		    System.out.print("Escriba el destino de guardado(descargas o documentos): ");
		    String ubicacion = sc.nextLine();

            switch (ubicacion.toLowerCase()) {
		case "descargas":
			InsertarArchivo(Temp.Temporaldesca, archivo);
			break;
			
		case "documentos":
			InsertarArchivo(Temp.TemporalDocu, archivo);
			break;
			
		default:
			System.out.println("Ubicacion no encontrada.");;
		}


        

        
    }
}


 