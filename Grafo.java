package tpe;

import java.util.ArrayList;
import java.util.Iterator;

public interface Grafo<T> {
	// Agrega un vertice
	public void agregarVertice(int verticeId);
	// Borra un vertice
	public void borrarVertice(int verticeId);
	
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta);
	public void borrarArco(int verticeId1, int verticeId2);


	public boolean contieneVertice(int verticeId);
	
	public Iterator<Integer> obtenerVertices();

	// Obtiene un iterador que me permite recorrer todos los vertices adyacentes a verticeId 
	public Iterator<Integer> obtenerAdyacentes(int verticeId);

	// Obtiene un iterador que me permite recorrer todos los arcos del grafo
	public Iterator<Arco<T>> obtenerArcos();
		
	// Obtiene un iterador que me permite recorrer todos los arcos que parten desde verticeId
	public Iterator<Arco<T>> obtenerArcos(int verticeId);
	
	}

