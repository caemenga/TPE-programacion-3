package tpe.auxiliares;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class UnionFind {
	
	private HashMap<Integer, Nodo<Integer>> valores;
	private ArrayList<Arco> tunelMasCorto;
	private int distancia;
	
	public UnionFind(Collection<Integer> v) {
		this.valores = new HashMap(v.size());
		tunelMasCorto = new ArrayList<Arco>();
		this.distancia = 0;
		cargarConjuntos(v);
	}
	
	private void cargarConjuntos(Collection<Integer> v) {
		Iterator<Integer> it = v.iterator();
		Integer auxiliar;
		while (it.hasNext()) {
			auxiliar = it.next();
			valores.put(auxiliar, new Nodo(auxiliar));
		}
	}
	
	
	
	
	public void Union(Arco arco) {
		Nodo<Integer> auxOrigen = getIdConjunto(arco.getVerticeOrigen());
		Nodo<Integer> auxDestino = getIdConjunto(arco.getVerticeDestino());
		
		if(auxOrigen.getValue() != auxDestino.getValue()) {
			this.distancia += (int)arco.getEtiqueta();
			auxDestino.setPadre(auxOrigen);
			
			Nodo<Integer> auxDestino2 = getIdConjunto(arco.getVerticeDestino());
			
			tunelMasCorto.add(arco);
			
		}
	}	
			
	
		
	
	
		
	
	private Nodo<Integer> getIdConjunto(Integer value) {
		Nodo<Integer> nodoActual = this.valores.get(value);

		if(nodoActual.getPadre()==null) {
			return nodoActual;
		}
		else {
		
			return this.getIdConjunto((int)nodoActual.getPadre().getValue());
	}
	}
	
	public ArrayList<Arco> getTunelMasCorto(){
		return new ArrayList<>(tunelMasCorto);
	}
	
	public boolean haySolucion() {
		Set<Integer> keys = this.valores.keySet();
		Iterator<Integer> it = keys.iterator();
		
		
		Nodo<Integer> auxiliar = this.getIdConjunto(it.next()); //obtengo el id de la primer estacion. En caso de tener la misma id que todas las estaciones, el problema esta resuelto
		while(it.hasNext()) {
			if(auxiliar.getValue() != this.getIdConjunto(it.next()).getValue())
				return false;
			}
		
		return true;
	}

	public int getDistancia() {
		return distancia;
	}
	

}
