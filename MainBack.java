package tpe;

import java.util.ArrayList;

public class MainBack {

	public static void main(String[] args) {
		String path = "../programacion-3/src/tpe/dataset2.txt";
		CSVReader reader = new CSVReader(path);
		reader.read();
		
		ArrayList<Arco> distancias = reader.getDistacias();
		ArrayList<Integer> estaciones = reader.getEstaciones();
		
		
		BackTrackingTPE back = new BackTrackingTPE(distancias, estaciones);
		
		back.solucionBacktracking();
	
		
		
	}

}
