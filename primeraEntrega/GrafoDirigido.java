package tpe.primeraEntrega;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import tpe.auxiliares.Arco;

public class GrafoDirigido<T> implements Grafo<T> {

	private HashMap<Integer, HashMap<Integer, Arco<T>>> vertices;

	public GrafoDirigido() {
		this.vertices = new HashMap();
	}

	/**
	 * Complejidad: O(1) donde 1 la entrada que hace para verificar e insertar un
	 * valor;
	 */
	@Override
	public void agregarVertice(int verticeId) {

		if (!this.contieneVertice(verticeId))
			this.vertices.put(verticeId, new HashMap());
	}

	/**
	 * Complejidad: O(n) donde n es la cantidad de valores que haya en
	 * vertices.values().
	 */
	@Override
	public void borrarVertice(int verticeId) {
		vertices.remove(verticeId);

		for (HashMap hm : vertices.values()) {
			hm.remove(verticeId);
		}

	}

	/**
	 * Complejidad: O(1) donde 1 es la entrada a la consulta.
	 */

	public boolean contieneVertice(int verticeId) {
		return vertices.containsKey(verticeId);
	}

	/**
	 * Complejidad: O(1) donde 1 es la entrada a para verificar y la entrada para
	 * agregar.
	 */
	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		if (this.contieneVertice(verticeId1) && this.contieneVertice(verticeId2))
			this.vertices.get(verticeId1).put(verticeId2, new Arco(verticeId1, verticeId2, etiqueta));
	}

	/**
	 * Complejidad: O(1) donde 1 es la entrada a para verificar y la entrada para
	 * remover.
	 */
	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		if (this.contieneVertice(verticeId1) && this.contieneVertice(verticeId2))
			this.vertices.get(verticeId1).remove(verticeId2);

	}

	/**
	 * Complejidad: O(1) donde 1 es la consulta para obtener el iterador de las key.
	 */
	@Override
	public Iterator<Integer> obtenerVertices() {

		return vertices.keySet().iterator();
	}

	/**
	 * Complejidad: O(1) donde 1 es la consulta para obtener el iterador del
	 * conjunto de keys.
	 */
	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		ArrayList<Integer> adyacentes = new ArrayList<>();

		return this.vertices.get(verticeId).keySet().iterator();
	}

	/**
	 * Complejidad: O(n) donde n es la cantidad de valores que tiene la collection
	 * veritces.values().
	 */

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		ArrayList<Arco<T>> arcos = new ArrayList<>();

		for (HashMap hm : this.vertices.values()) {
			arcos.addAll(hm.values());
		}

		return arcos.iterator();
	}

	/**
	 * Complejidad: O(n) donde n es la cantidad de valores que tiene la collection
	 * veritces.values().
	 */
	
	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		HashMap<Integer, Arco<T>> arcos = vertices.get(verticeId);

		return arcos.values().iterator();
	}

	/**
	 * Complejidad: O(1) donde 1 es la entrada que hace en contieneVertice(id) y la
	 * entrada que se realiza para obtener el value en el HashMap.
	 */
	
	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		Arco aux = new Arco(verticeId1, verticeId2);

		if (this.contieneVertice(verticeId1) && this.contieneVertice(verticeId2)) {
			if (this.vertices.get(verticeId1).containsKey(verticeId2))
				return true;
		}

		return false;

	}

	/**
	 * Complejidad: O(1) donde 1 es la entrada que hace en contieneVertice(id) y la
	 * entrada que se realiza para obtener el value en el HashMap.
	 */
	
	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {

		if (this.contieneVertice(verticeId1) && (this.contieneVertice(verticeId2)))
			return this.vertices.get(verticeId1).get(verticeId2);

		return null;
	}

	/**
	 * Complejidad: O(1) donde 1 es la entrada que hace en la clase Set para saber
	 * cual es el tamaño del arreglo
	 */
	
	public int cantidadVertices() {

		return vertices.keySet().size();
	}

	/**
	 * Complejidad: O(n) donde n es la cantidad de valores que tiene la collecion
	 * que devuelve el metodo keySet().
	 */
	
	@Override
	public int cantidadArcos() {
		int suma = 0;
		for (Integer v : vertices.keySet()) {
			{
				for (Integer v1 : vertices.get(v).keySet()) {
					if (vertices.get(v).get(v1) != null)
						suma++;
				}

			}
		}
		return suma;

	}
}
