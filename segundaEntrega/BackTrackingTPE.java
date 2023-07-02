package tpe.segundaEntrega;


import java.util.ArrayList;
import java.util.Stack;

import tpe.auxiliares.Arco;

public class BackTrackingTPE {
	private Stack<Arco> listaTuneles;
	private ArrayList<Integer> estaciones;
	private int metrica;
	private int distancia;

	public BackTrackingTPE(ArrayList<Integer> estaciones, ArrayList<Arco> tuneles) {
		this.listaTuneles = new Stack<Arco>();
		this.estaciones = new ArrayList<>(estaciones);
		this.metrica = 0;
		this.distancia = 0;
		llenarListaTuneles(tuneles);
	}
	
	public BackTrackingTPE(String path) {
		CSVReader r = new CSVReader(path);
		this.estaciones = new ArrayList<>(r.getEstaciones());
		this.metrica=0;
		this.distancia =0;
		llenarListaTuneles(r.getDistacias());
		
	}

	private void llenarListaTuneles(ArrayList<Arco> tuneles) {
		for (Arco a : tuneles) {
			listaTuneles.push(a);
		}
	}

	public void solucionBacktracking() {
		this.metrica++;
		int distanciaAux = 0;
		ArrayList<Arco> solucion = new ArrayList<Arco>();
		ArrayList<Arco> caminoActual = new ArrayList<Arco>();

		this.getTuneles(solucion, caminoActual, distanciaAux);
		 System.out.println("Backtracking");
		 System.out.println(solucion);
		 System.out.println(distancia + " kms");
		 System.out.println(metrica + " metrica");

	}

	private void getTuneles(ArrayList<Arco> solucion, ArrayList<Arco> caminoActual, int distanciaAux) {
		
		this.metrica++;
		if (listaTuneles.isEmpty()) {
			if (solucionFactible(solucion, caminoActual)) {
				this.distancia = distanciaAux;
				solucion.clear();
				ArrayList<Arco> auxCamino = new ArrayList<>(caminoActual);
				solucion.addAll(auxCamino);
			}
		} else {

			Arco tunel = listaTuneles.pop();
			getTuneles(solucion, caminoActual, distanciaAux);

			caminoActual.add(tunel);
			distanciaAux += (int) tunel.getEtiqueta();

			getTuneles(solucion, caminoActual,  distanciaAux);
			caminoActual.remove(tunel);
			distanciaAux -= (int)tunel.getEtiqueta();
			listaTuneles.push(tunel);

		}
	}
	
	private boolean solucionFactible(ArrayList<Arco> solucion, ArrayList<Arco> caminoActual) {
		if(!completeEstaciones(caminoActual))
			return false;
		
		if(this.getDistancia(solucion) < this.getDistancia(caminoActual) && !solucion.isEmpty())
			return false;
		
		ArrayList<Integer> estacionesAux = new ArrayList<>();
		for(Arco a: caminoActual) {
				if(!existeVertices(a, caminoActual)) 
					return false;
						
		}
		return true;
			
	}

	private boolean existeVertices(Arco arco,  ArrayList<Arco> caminoActual) {
		
		for(Arco a: caminoActual) {
			if(!a.equals(arco)) {
				if((a.getVerticeOrigen()==arco.getVerticeOrigen()) || (a.getVerticeDestino()==arco.getVerticeDestino())
					|| (a.getVerticeOrigen() == arco.getVerticeDestino()) || (a.getVerticeDestino() == arco.getVerticeOrigen())){
				
					return true;
			}
		}
	}
		return false;
	}

	private boolean completeEstaciones(ArrayList<Arco> camino) {
		ArrayList<Integer> estacionesCopia = new ArrayList<>();
		ArrayList<Integer> destino = new ArrayList<>();
		if (estaciones.size()-1==camino.size()) {
			for (Integer i : estaciones) {
				int pos = 0;
				while (pos < camino.size()) {
					if ((camino.get(pos).getVerticeOrigen() == i) || (camino.get(pos).getVerticeDestino() == i)) {
						estacionesCopia.add(i);
						pos = camino.size();
					} else
						pos++;

				}
			}
		}else
			return false;
		
		return estacionesCopia.size() == estaciones.size() ;
	}

	private int getDistancia(ArrayList<Arco> camino) {
		int distancia = 0;
		
		for (Arco a : camino) {
			distancia += (int) a.getEtiqueta();
		}
		
		return distancia;
	}
	public int getMetrica() {
		return this.metrica;
	}
}
