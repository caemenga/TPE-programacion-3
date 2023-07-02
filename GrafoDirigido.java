package tpe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class GrafoDirigido<T> implements Grafo<T> {
	
	private HashMap<Integer, HashMap<Integer, Arco<T>>> vertices;
	
	public GrafoDirigido() {
		this.vertices = new HashMap();
	}
	
	/**
	 * 
	 */
	@Override
	public void agregarVertice(int verticeId) {
		
		if(!this.contieneVertice(verticeId))
			this.vertices.put(verticeId, new HashMap());
	}
	@Override
	public void borrarVertice(int verticeId) {
		vertices.remove(verticeId);
		
		for(HashMap hm: vertices.values()) {
			hm.remove(verticeId);
		}
	
	}
	
	public boolean contieneVertice(int verticeId) {
		return vertices.containsKey(verticeId);
	}
	
	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		if(this.contieneVertice(verticeId1) && this.contieneVertice(verticeId2))
			this.vertices.get(verticeId1).put(verticeId2, new Arco(verticeId1, verticeId2, etiqueta));
	}
	
	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		if(this.contieneVertice(verticeId1) && this.contieneVertice(verticeId2))
			this.vertices.get(verticeId1).remove(verticeId2);
		
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		ArrayList<Integer> keys = new ArrayList<Integer>();
		
		for(Integer i : vertices.keySet()) {
			keys.add(i);
		}
		
		return keys.iterator();	
	}


	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		ArrayList<Integer> adyacentes = new ArrayList<>();
		
		for(Integer i : vertices.get(verticeId).keySet()) {
			adyacentes.add(i);
		}
		
		return adyacentes.iterator();
	}


	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		ArrayList<Arco<T>> arcos = new ArrayList<>();
		
		for(HashMap hm: this.vertices.values()) {
			arcos.addAll(hm.values());
		}
		
		return arcos.iterator();
	}


	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		HashMap<Integer, Arco<T>> arcos = vertices.get(verticeId);
		
		return arcos.values().iterator();
	}

}

