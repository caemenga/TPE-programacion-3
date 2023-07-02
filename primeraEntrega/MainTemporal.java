package tpe.primeraEntrega;

import java.util.List;

public class MainTemporal {

	public static void main(String[] args) {

		GrafoDirigido<Integer> g = new GrafoDirigido<Integer>();

		// Cargamos un grafo dirigido
		// Primero los vértices
		g.agregarVertice(1);
		g.agregarVertice(2);
		g.agregarVertice(3);
		g.agregarVertice(4);
		g.agregarVertice(5);
		g.agregarVertice(6);
		g.agregarVertice(7);

		// Luego los arcos
		g.agregarArco(1, 2, 12);
		g.agregarArco(1, 3, 13);
		g.agregarArco(1, 4, 14);
		g.agregarArco(2, 6, 26);
		g.agregarArco(3, 5, 35);
		g.agregarArco(4, 7, 47);
		g.agregarArco(5, 6, 56);
		
		ServicioCaminos caminos = new ServicioCaminos(g, 1, 6, 5);
	    List<List<Integer>> resultado =  caminos.caminos();
	    
	    //CAMINOS
	    System.out.println("Caminos de 1 a 6 limite 5:([[1, 2, 6], [1, 3, 5, 6]])");
	    System.out.println(resultado);
	    
	    resultado.clear();
	    caminos = new ServicioCaminos(g, 1, 6, 3);
	    resultado = caminos.caminos();
	    
	    System.out.println("Caminos de 1 a 6 limite 3: [[1, 2, 6], [1, 3, 5, 6], [1, 4, 7, 6], [1, 1, 2, 6]]");
	    System.out.println(resultado);

	}

}
