import java.util.ArrayList;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Matriz {
	double Matrix[][];
	ArrayList<Integer> listaMinima = new ArrayList<Integer>();
	ArrayList<Integer> rama = new ArrayList<Integer>();
	public Matriz(int size) {
		Matrix = new double[size][size];
	}

	public void setCasilla(int i, int j, String dato) {
		Matrix[i][j] = Double.parseDouble(dato);
	}
	public double cotaSuperior(){
		double minimo = 9999999;
		double aux = 0;
		for (int i = 0; i < Matrix.length; i++) {
			aux = caminoMinimo(i);
			if (aux < minimo) {
				minimo = aux;
			}
		}
		return minimo;
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
					costo =  costo + Matrix[node][i];
				}
			}
			
			node =  bestCase;
			
			listaMinima.add(node);
		}
		//System.out.println(listaMinima);
		System.out.println("Coste:"+ costo);
		return costo;
	}
	
	
	public void arbolMinimo(){
		rama.add(0);
		
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
