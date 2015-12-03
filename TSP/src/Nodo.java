import java.util.ArrayList;

public class Nodo {
	ArrayList<Integer> visitados = new ArrayList<Integer>();
	ArrayList<Nodo> hijos = new ArrayList<Nodo>();
	private Nodo previo;
	private int POSICION;
	public Nodo(Nodo padre, int pos){
		this.setPrevio(padre);
		this.POSICION = pos;
		this.visitados = padre.visitados;
		this.visitados.add(pos);
		padre.addHijo(this);
	}
	
	public Nodo(int pos){
		this.setPrevio(null);
		this.POSICION = pos;
		this.visitados.add(pos);	}
	public int getPOSICION() {
		return POSICION;
	}
	public void setPOSICION(int posicion) {
		POSICION = posicion;
	}

	public Nodo getPrevio() {
		return previo;
	}

	public void setPrevio(Nodo previo) {
		this.previo = previo;
	}
	
	public void addHijo(Nodo hijo) {
		ArrayList<Integer> aux;
		aux = this.visitados;
		aux.add(hijo.POSICION);
		
		hijos.add(hijo);
	}
}
