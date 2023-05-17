package tpe;

public class Main {

	public static void main(String[] args) {
	GrafoDirigido GD = new GrafoDirigido();
	
	GD.agregarVertice(1);
	GD.agregarVertice(33);
	GD.agregarVertice(28);
	GD.agregarVertice(10);
	GD.agregarVertice(23);
	GD.agregarVertice(5);
	GD.agregarVertice(17);
	GD.agregarVertice(0);
	GD.agregarVertice(11);
	
	
	System.out.println(GD);
	
	GD.borrarVertice(0);
	
	System.out.println(GD);
	
	
	}

}
