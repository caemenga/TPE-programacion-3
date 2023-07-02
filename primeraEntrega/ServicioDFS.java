package tpe.primeraEntrega;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ServicioDFS {

	private Grafo<?> grafo;
	private ArrayList<Integer> visitados;

	public ServicioDFS(Grafo<?> grafo) {
		this.grafo = grafo;
		this.visitados = new ArrayList<Integer>();
	}

	public List<Integer> dfsForest() {
		Iterator<Integer> vertices = grafo.obtenerVertices();

		while (vertices.hasNext()) {
			Integer v = vertices.next();

			if (!visitados.contains(v)) {
				dfs_Visit(v);
			}

		}

		ArrayList<Integer> dfsForest = new ArrayList<Integer>(this.visitados);
		visitados.clear();
		return dfsForest;
	}

	// tocamos hasta aca
	public void dfs_Visit(int v) {

		this.visitados.add(v);
		Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(v);
		while (adyacentes.hasNext()) {
			Integer v1 = adyacentes.next();
			if (!visitados.contains(v1)) {
				dfs_Visit(v1);
			}
		}

	}

	}
