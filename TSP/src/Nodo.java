import java.util.ArrayList;

public class Nodo {
	ArrayList<Integer> visitados = new ArrayList<Integer>();
	ArrayList<Nodo> hijos = new ArrayList<Nodo>();
	private Nodo previo;
	private int POSICION;
	public Nodo(Nodo padre, int pos){
		this.setPrevio(padre);
		this.POSICION = pos;
		
		ArrayList<Integer> clone = (ArrayList<Integer>) padre.visitados.clone();
		this.visitados = clone;

		padre.addHijo(this);
	}
	
	private ArrayList<Integer> extracted(ArrayList<Integer> visitados2) {
		// TODO Auto-generated method stub
		return null;
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
		hijos.add(hijo);
	}
	
	public void mostrarHijos() {
		System.out.println("HIJOS: ");
		for (int i = 0; i < this.hijos.size(); i++) {
			System.out.print(this.hijos.get(i).POSICION + "_");
		}
	}
}
