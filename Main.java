package tpe;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Main {

	public static void main(String[] args) {

		String path = "../programacion-3/src/tpe/dataset3.txt";
		CSVReader reader = new CSVReader(path);
		reader.read();
		
		ArrayList<Arco> distancias = reader.getDistacias();
		ArrayList<Integer> estaciones = reader.getEstaciones();
	
		
		ServicioGreedy servicio = new ServicioGreedy(estaciones, distancias);
		
		servicio.servicioGreedy();
		
		
			
	}

}


