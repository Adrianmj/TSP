import java.util.ArrayList;

public class Matriz {
	double Matrix[][];
	int num_nodos;
	double cota;
	ArrayList<Integer> listaMinima = new ArrayList<Integer>();

	public Matriz(int size) {
		num_nodos = size;
		Matrix = new double[size][size];
	}
	
	public int getNodos() {
		return num_nodos;
	}
	
	public double getCota() {
		return cota;
	}
	
	public void setCota(double x) {
		cota = x;
	}

	public void setCasilla(int i, int j, String dato) {
		Matrix[i][j] = Double.parseDouble(dato);
	}
	
	public int mejorNodo(){
		double minimo = 9999999;
		double aux = 0;
		int mejorNodo = 0;
		for (int i = 0; i < Matrix.length; i++) {
			aux = caminoMinimo(i);
			if (aux < minimo) {
				minimo = aux;
				mejorNodo = i;
			}
		}
		return mejorNodo;
	}
	
	public int peorNodo(){
		double minimo = 0;
		double aux = 0;
		int peorNodo = 0;
		for (int i = 0; i < Matrix.length; i++) {
			aux = caminoMinimo(i);
			if (aux > minimo) {
				minimo = aux;
				peorNodo = i;
			}
		}

		return peorNodo;
	}
	
	public double caminoMinimo(int node) {
		listaMinima.clear();
		listaMinima.add(node);
		
		double costo = 0;
		while (listaMinima.size() < Matrix.length) {
			
			double min = 999999999;
			int bestCase = 0;
			
			for (int i = 0; i < Matrix.length; i++) {
				if (Matrix[node][i] <= min & listaMinima.contains(i) == false) {
					min = Matrix[node][i];
					bestCase = i;	
				}
			}
			costo +=  min;
			node =  bestCase;
			listaMinima.add(node);
		}
		
		costo += Matrix[node][listaMinima.get(0)]; //sumamos el coste de vuelta al nodo principal
		//System.out.println(listaMinima);
		return costo;
	}
	
	public double caminoMinimoFijo(ArrayList<Integer> visitados) {
		listaMinima.clear();
		ArrayList<Integer> clone = (ArrayList<Integer>) visitados.clone();
		listaMinima = clone;
		int node = listaMinima.get(listaMinima.size() - 1);
		double costo = 0;
		
		for (int i = 0; i < listaMinima.size() - 1; i++) {
			costo =  costo + Matrix[listaMinima.get(i)][listaMinima.get(i+1)];
		}

		while (listaMinima.size() < Matrix.length) {
			
			double min = 999999999;
			int bestCase = 0;
			
			for (int i = 0; i < Matrix.length; i++) {
				if (Matrix[node][i] < min & listaMinima.contains(i) == false) {
					min = Matrix[node][i];
					bestCase = i;
				}
			}

			costo +=  min;
			node =  bestCase;

			listaMinima.add(node);
		}
		costo += Matrix[node][listaMinima.get(0)]; //sumamos el coste de vuelta al nodo principal
		//System.out.println(listaMinima);
		return costo;
	}
	
	public void arbolMinimo(){

		
	}
	public void show() {
		for (int k = 0; k < Matrix.length; k++) {
			System.out.print("\t"+k);
		}
		System.out.println();
		for (int i = 0; i < Matrix.length; i++) {
			System.out.print(i +" ");
			for (int j = 0; j < Matrix.length; j++) {
				System.out.print("\t" + Matrix[i][j]);
			}
			System.out.println();
		}
	}
}
