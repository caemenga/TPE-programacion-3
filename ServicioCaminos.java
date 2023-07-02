package tpe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ServicioCaminos {

	private Grafo<?> grafo;
	private int origen;
	private int destino;
	private int lim;
	private int contArcos;

	// Servicio caminos
	public ServicioCaminos(Grafo<?> grafo, int origen, int destino, int lim) {
		this.grafo = grafo;
		this.origen = origen;
		this.destino = destino;
		this.lim = lim;
		this.contArcos = 0;
	}

	public List<List<Integer>> caminos() {
		List<List<Integer>> caminos = new ArrayList<List<Integer>>();
		ArrayList<Integer> caminoActual = new ArrayList<Integer>();
		ArrayList<Arco> arcosVisitados = new ArrayList<Arco>();

		this.obtenerCaminos(origen, caminoActual, caminos, arcosVisitados);

		return new ArrayList<>(caminos);
	}

	private <T> void obtenerCaminos(int vertice, ArrayList<Integer> caminoActual, List<List<Integer>> caminos,
			ArrayList<Arco> arcosVisitados) {

		caminoActual.add(vertice);
		if ((vertice == destino) && (contArcos <= lim))
			caminos.add(new ArrayList<Integer>(caminoActual));

		if (contArcos >= lim) {
			caminoActual.remove(caminoActual.size() - 1);
			return;
		}

		Iterator<?> arcos = grafo.obtenerArcos(vertice);
		while (arcos.hasNext()) {
			Arco<T> arco = (Arco<T>) arcos.next();

			if (!arcosVisitados.contains(arco)) {
				Integer adyacente = arco.getVerticeDestino();
				arcosVisitados.add(arco);
				contArcos++;
				obtenerCaminos(adyacente, caminoActual, caminos, arcosVisitados);
				arcosVisitados.remove(arco);
				contArcos--;
			}

		}

		caminoActual.remove(caminoActual.size() - 1);
	}
}