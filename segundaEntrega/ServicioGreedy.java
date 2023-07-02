package tpe.segundaEntrega;

import java.util.ArrayList;
import java.util.Iterator;

import tpe.auxiliares.Arco;
import tpe.auxiliares.Nodo;
import tpe.auxiliares.ServicioMergeSort;
import tpe.auxiliares.UnionFind;

public class ServicioGreedy {

	private ArrayList<Integer> estaciones;
	private ArrayList<Arco> tuneles;
	private int distanciaTotal;
	private int metrica;

	public ServicioGreedy(ArrayList<Integer> estaciones, ArrayList<Arco> tuneles) {
		this.estaciones = new ArrayList<>(estaciones);
		this.tuneles = new ArrayList<>(tuneles);
		this.distanciaTotal = 0;
		this.metrica = 0;
	}

	public ServicioGreedy(String path) {
		CSVReader r = new CSVReader(path);

		this.estaciones = new ArrayList<>(r.getEstaciones());
		this.tuneles = new ArrayList<>(r.getDistacias());
		this.distanciaTotal = 0;
		this.metrica = 0;
	}
	
	/**
	 * Complejidad: O(n^3) donde n es la cantidad de tuneles y
	 * las 2 listas de nodos que recorre en el Servicio UnionFind.
	 */
	
	public void servicioGreedy() {

		ArrayList<Arco> candidatos = new ArrayList<>(this.tuneles);
		ServicioMergeSort servicioMerge = new ServicioMergeSort(candidatos);
		UnionFind servicioUnion = new UnionFind(estaciones);
		servicioMerge.sort(); // se ordena la lista de candidatos de menor a mayor sengun la distancia.

		while ((!candidatos.isEmpty()) && (!servicioUnion.haySolucion())) {
			this.metrica += 1;
			Arco arco = candidatos.get(0);
			candidatos.remove(candidatos.get(0));

			servicioUnion.Union(arco); // ocurre la union en caso de que ambas estaciones no esten ya conectadas.

		}
		if (servicioUnion.haySolucion()) {
			System.out.println("Greedy");
			System.out.println(servicioUnion.getTunelMasCorto());
			System.out.println(servicioUnion.getDistancia() + " kms");
			System.out.println(this.metrica + " metrica");
		} else
			System.out.println("No hay solucion");
	}

}