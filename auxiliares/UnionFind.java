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

	/**
	 * Complejidad: O(n^2) donde n son las dos veces que recorre los nodos para
	 * averiguar su id de conjunto en getIdConjunto(int v).
	 */

	public void Union(Arco arco) {
		Nodo<Integer> auxOrigen = getIdConjunto(arco.getVerticeOrigen());
		Nodo<Integer> auxDestino = getIdConjunto(arco.getVerticeDestino());

		if (auxOrigen.getValue() != auxDestino.getValue()) {
			this.distancia += (int) arco.getEtiqueta();
			auxDestino.setPadre(auxOrigen);

			Nodo<Integer> auxDestino2 = getIdConjunto(arco.getVerticeDestino());

			tunelMasCorto.add(arco);

		}
	}

	/**
	 * Complejidad: O(n) donde n es la cantidad de Nodos que tenga que recorrer para
	 * obtener la id, en el mejor caso es solo una vez, en el peor debe a su "raiz".
	 */

	private Nodo<Integer> getIdConjunto(Integer value) {
		Nodo<Integer> nodoActual = this.valores.get(value);

		if (nodoActual.getPadre() == null) {
			return nodoActual;
		} else {

			return this.getIdConjunto((int) nodoActual.getPadre().getValue());
		}
	}

	/**
	 * Complejidad: O(n) donde n es la cantidad de elementos que haya en
	 * tunelMasCorto. El ArrayList tiene que agregarlos uno por uno.
	 */

	public ArrayList<Arco> getTunelMasCorto() {
		return new ArrayList<>(tunelMasCorto);
	}

	/**
	 * Complejidad: O(n^2) donde n son la cantidad de elementos que tiene las
	 * "listas" que debe recorrer (getIdConjunto, keys.iterator().
	 */

	public boolean haySolucion() {
		Iterator<Integer> it = this.valores.keySet().iterator();

		Nodo<Integer> auxiliar = this.getIdConjunto(it.next()); // obtengo el id de la primer estacion. En caso de tener
																// la misma id que todas las estaciones, el problema
																// esta resuelto
		while (it.hasNext()) {
			if (auxiliar.getValue() != this.getIdConjunto(it.next()).getValue())
				return false;
		}

		return true;
	}

	public int getDistancia() {
		return distancia;
	}

}
