package tpe;

import java.util.ArrayList;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {
	
	private ArrayList<Arco> listaArcos;
	private ArrayList<Vertice> listaVertices;
	
	public GrafoDirigido() {
		this.listaArcos = new ArrayList<Arco>();
		this.listaVertices = new ArrayList<Vertice>();
	}
	
	@Override
	public void agregarVertice(int verticeId) {
		Vertice v1 = new Vertice(verticeId);
		if(!this.listaVertices.contains(v1))
			this.listaVertices.add(v1);
	}
	@Override
	public void borrarVertice(int verticeId) {
		for(Vertice v: listaVertices) {
			if(v.getVerticeId()==verticeId) {
				this.listaVertices.remove(v);
				return;
			}
		}
	
	}
	
	public String toString() {
		String resul = "";
		
		for(Vertice v: listaVertices) {
			resul += "["+v.getVerticeId()+"] ";
		}
		return resul;
	}
}

