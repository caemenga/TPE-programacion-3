package tpe.segundaEntrega;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tpe.auxiliares.Arco;


public class Main {

	public static void main(String[] args) {
		
		System.out.println("Dataset1");
		String path = "../programacion-3/src/tpe/datasets/dataset1.txt";
		CSVReader reader = new CSVReader(path);
		reader.read();
		
		ArrayList<Arco> distancias = reader.getDistacias();
		ArrayList<Integer> estaciones = reader.getEstaciones();
	
		
		ServicioGreedy servicio = new ServicioGreedy(estaciones, distancias);
		BackTrackingTPE servicioBack = new BackTrackingTPE(estaciones, distancias);
		
		servicio.servicioGreedy();
		servicioBack.solucionBacktracking();
		
		
		System.out.println("Dataset2");
		String path2 = "../programacion-3/src/tpe/datasets/dataset2.txt";
		CSVReader reader2 = new CSVReader(path2);
		reader2.read();
		
		ArrayList<Arco> distancias2 = reader2.getDistacias();
		ArrayList<Integer> estaciones2 = reader2.getEstaciones();
		
		ServicioGreedy servicioGreedy2 = new ServicioGreedy(estaciones2, distancias2);
		BackTrackingTPE servicioBack2 = new BackTrackingTPE(estaciones2, distancias2);
		
		servicioGreedy2.servicioGreedy();
		servicioBack2.solucionBacktracking();
		
		//dataset 3
		
		System.out.println("Dataset3");
		String path3 = "../programacion-3/src/tpe/datasets/dataset3.txt";
		CSVReader reader3 = new CSVReader(path3);
		reader3.read();
		
		ArrayList<Arco> distancias3 = reader3.getDistacias();
		ArrayList<Integer> estaciones3 = reader3.getEstaciones();
		
		ServicioGreedy servicioGreedy3 = new ServicioGreedy(estaciones3, distancias3);
		BackTrackingTPE servicioBack3 = new BackTrackingTPE(estaciones3, distancias3);
		
		servicioGreedy3.servicioGreedy();
		
		//el backtracking del dataset3 no llega a completar por la cantidad de recursiones que tiene que hacer
		//servicioBack3.solucionBacktracking();
		
		
		
			
	}

}


