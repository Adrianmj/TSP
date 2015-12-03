import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TSP {


	private static TSP a;

	public TSP() {
		try {

			File xmlFile = new File("bayg29.xml"); //bayg29 optimo = 1610 
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			Document doc = documentBuilder.parse(xmlFile);

			doc.getDocumentElement().normalize();
			NodeList verticeList = doc.getElementsByTagName("vertex");

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			Matriz M = new Matriz(verticeList.getLength());

			for (int fila = 0; fila < verticeList.getLength(); fila++) {

				NodeList listaEjes = verticeList.item(fila).getChildNodes();
				int i = 0;
				for (int columna = 0; columna < listaEjes.getLength(); columna++) {

					Node ejeI = listaEjes.item(columna);

					if (ejeI.getNodeType() == Node.ELEMENT_NODE) {

						Element student = (Element) ejeI;
						if (fila == i)  {
							M.setCasilla(i, i, "0");
							i++;
						}
						M.setCasilla(fila, i, student.getAttribute("cost"));
						i++;		
					}
				}

			}
			M.show();

			System.out.println("Cota superior: " + M.cotaSuperior());
						
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		a = new TSP();
	}
}
