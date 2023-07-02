package tpe.primeraEntrega;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ServicioBFS {

	private Grafo<Integer> grafo;
	ArrayList<Integer> visitados;
	
	public ServicioBFS(Grafo<Integer> grafo) {
		this.grafo = grafo;
		this.visitados = new ArrayList<Integer>();
	}
	
	/**
	 * Complejidad: O(n^3) donde n^3 son las 3 iteraciones 
	 * de las colecciones con n elementos 
	 * que realiza el metodo para obtener el resultado
	 */
	
	public List<Integer> bfsForest() {
		Queue<Integer> cola = new LinkedList<Integer>();
		Iterator<Integer> vertices = grafo.obtenerVertices();
		
		while(vertices.hasNext()) {
			
			Integer v = vertices.next();
			
			if(!this.visitados.contains(v)) {
				this.visitados.add(v);
				cola.offer(v);
				
				while(!cola.isEmpty()) {
					Integer v1 = cola.poll();
					
					Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(v1);
					while(adyacentes.hasNext()) {
						Integer adyacente = adyacentes.next();
						if(!this.visitados.contains(adyacente)) {
							cola.offer(adyacente);
							this.visitados.add(adyacente);
							
						}
					}
				}
			}
		}
		return new ArrayList<Integer>(this.visitados);
	}
	
	
}