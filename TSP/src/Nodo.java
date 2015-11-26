import java.util.ArrayList;

public class Nodo {
	ArrayList<Integer> rama = new ArrayList();
	private int POSICION;
	public Nodo(ArrayList<Integer> ramaPrevia){
		this.rama = ramaPrevia;
	}
	public int getPOSICION() {
		return POSICION;
	}
	public void setPOSICION(int posicion) {
		POSICION = posicion;
	}
}
