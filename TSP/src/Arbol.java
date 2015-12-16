import java.util.ArrayList;

public class Arbol {
	//private Nodo padre = new Nodo(0);
	private Matriz Matrix;
	private ArrayList<Nodo> mejores = new ArrayList<Nodo>();

	public Arbol(Matriz M) {
		this.Matrix = M;
		this.Matrix.setCota(this.Matrix.caminoMinimo(M.peorNodo()));
		//obteniendo la cota del peor nodo evitamos descartar posibles caminos mejores
	}

	public ArrayList<Nodo> expandirArbol(Nodo nodo) {
		ArrayList<Integer> visited = nodo.visitados;
		
		if (nodo.visitados.size() == Matrix.getNodos()) {
			mejores.add(nodo);
		}
		if (nodo.visitados.size() < Matrix.getNodos()) {
			for (int i = 0; i < Matrix.getNodos(); i++) {
				if (visited.contains(i) == false) {
					visited.add(i); 
				    
					if (Matrix.caminoMinimoFijo(visited) <= Matrix.cota) {
						new Nodo(nodo, i);
					}

					visited.remove(visited.size() - 1);
				}
			}	
		}
		return nodo.hijos;
	}
	
	public void mostrarMejores() {
		int posMejor = 0;
		for (int i = 1; i < mejores.size(); i++) {
			if (Matrix.caminoMinimoFijo(mejores.get(posMejor).visitados) > Matrix.caminoMinimoFijo(mejores.get(i).visitados)) {
				posMejor = i;
			}
		}
		System.out.print("Mejor nodo: " + mejores.get(posMejor).getPOSICION() + ", recorrido: " + mejores.get(posMejor).visitados);
		System.out.println(", coste del recorrido: " + Matrix.caminoMinimoFijo(mejores.get(posMejor).visitados));
	}
}
