import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TSP {

	public TSP() {
		try {

			File xmlFile = new File("br17.xml");
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

					if (ejeI.getNodeType() == ejeI.ELEMENT_NODE) {

						Element student = (Element) ejeI;
						M.setCasilla(fila, i, student.getAttribute("cost"));
						i++;

					}
				}

			}
			M.show();
			M.caminoMinimo(3);
			System.out.println("Cota superior: " + M.cotaSuperior());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		TSP a = new TSP();
	}
}
