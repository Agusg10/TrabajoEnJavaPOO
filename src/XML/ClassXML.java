package XML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;


public class ClassXML {
    public void loadArch(){
        try {
            File fileXML = new File("/Users/agustinlopez/Desktop/Facultad/AYED 2/Trabajo Grupal/estadis/src/XML/ClassXML.java");//introducir ruta del archivo XML

            DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder DB = DBF.newDocumentBuilder();
            Document DOC = DB.parse(fileXML);
            DOC.getDocumentElement().normalize(); //obtengo la raiz del XML

            System.out.println("Root : "+ DOC.getDocumentElement().getNodeName());//puedo imprimir la raiz para verificar que me ubique ahi

            NodeList nodeList = DOC.getElementsByTagName("Instagram");
            for (int i=0; i<nodeList.getLength();i++){

                Node node = nodeList.item(i);

                System.out.println("Actual Node name: "+node.getNodeName());//imprimo nombre del NODO ACTUAL

                if (node.getNodeType() == Node.ELEMENT_NODE){//verifico si un objeto Node es un nodo de elemento en el DOM (Document Object Model).
                    if (node instanceof Element) {// verifico si el objeto Node se puede convertir a un objeto Element de manera segura para evitar excepcion
                        Element eElement = (Element) node;
                        System.out.println(eElement.getElementsByTagName("FirstName"));
                        //obtengo e imprimo atributos
                        System.out.println("name: "+eElement.getElementsByTagName("FirstName").item(0).getTextContent());
                        System.out.println("lastname: "+eElement.getElementsByTagName("LastName").item(0).getTextContent());
                        System.out.println("contact: "+eElement.getElementsByTagName("ContactNo").item(0).getTextContent());
                        System.out.println("email: "+eElement.getElementsByTagName("Email").item(0).getTextContent());

                    } else {// El objeto Node no es un objeto Element, no se puede acceder a los métodos y propiedades específicos de los elementos
                        System.out.println("hello there");
                    }
                }
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
