package tpe;


public class Vertice {
	private Integer verticeId;
	private Integer d;
	private Integer f;
	
	public Vertice(Integer valor) {
		this.verticeId = valor;
		this.d = 0;
		this.f = 0;
	}
	
	
	public Integer getVerticeId() {
		return this.verticeId;
	}
	public void setD(Integer t) {
		this.d = t;
	}

	public Integer getF() {
		return f;
	}

	public void setF(Integer f) {
		this.f = f;
	}

	public int getD() {
		return this.d;
	}
	
}
