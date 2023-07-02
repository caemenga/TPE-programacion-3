package tpe.auxiliares;

public class Nodo<T> {
	private T value;
	private Nodo<T> padre;
	
	
	
	public Nodo(T value) {
		this.value = value;
		this.setPadre() ;
	}
	
	public void setPadre(Nodo<T> padre){
		this.padre = padre;
	}
	public void setPadre() {
		this.padre = null;
	}
	
	public T getValue() {
		return this.value;
	}
	
	public Nodo getPadre() {
		return this.padre;
	}
	
}
