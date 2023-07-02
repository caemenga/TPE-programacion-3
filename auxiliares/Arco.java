package tpe.auxiliares;

public class Arco<T> {

	private Integer verticeOrigen;
	private Integer verticeDestino;
	private T etiqueta;

	public Arco(int verticeOrigen, int verticeDestino, T etiqueta) {
		this.verticeOrigen = verticeOrigen;
		this.verticeDestino = verticeDestino;
		this.etiqueta = etiqueta;
	}
	
	public Arco(int origen, int destino) {
		this.verticeOrigen = origen;
		this.verticeDestino = destino;
		this.etiqueta = null;
	}

	public int getVerticeOrigen() {
		return verticeOrigen;
	}
	
	public int getVerticeDestino() {
		return verticeDestino;
	}

	public T getEtiqueta() {
		return etiqueta;
	}
	@Override
	public boolean equals(Object o) {
		Arco<T> arco= (Arco<T>) o;
		return ((arco.getVerticeOrigen()== this.verticeOrigen)&&(arco.getVerticeDestino()== this.verticeDestino));
	}
	@Override
	public String toString() {
		
		
		return "E"+this.getVerticeOrigen() +" - E"+ this.getVerticeDestino();
	}
}
