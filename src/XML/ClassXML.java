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
            File fileXML = new File("/Users/agustinlopez/Desktop/Facultad/AYED 2/Trabajo Grupal/estadis/src/XML/DatosTP.xml");//introducir ruta del archivo XML

            DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder DB = DBF.newDocumentBuilder();
            Document document = DB.parse(fileXML);
            document.getDocumentElement().normalize(); //obtengo la raiz del XML

            //System.out.println("Elemento raíz: " + document.getDocumentElement().getNodeName());
            NodeList profiles = document.getElementsByTagName("Profile");

            for (int i = 0; i < profiles.getLength(); i++) {

                Node profileNode = profiles.item(i);

                if (profileNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element profileElement = (Element) profileNode;

                    String user = profileElement.getElementsByTagName("User").item(0).getTextContent();
                    String name = profileElement.getElementsByTagName("Name").item(0).getTextContent();
                    String surname = profileElement.getElementsByTagName("Surname").item(0).getTextContent();
                    System.out.println("User: " + user);
                    System.out.println("Name: " + name);
                    System.out.println("Surname: " + surname);

                    System.out.println();

                    NodeList publications = profileElement.getElementsByTagName("Publication");

                    for (int j = 0; j < publications.getLength(); j++) {

                        Node publicationNode = publications.item(j);

                        if (publicationNode.getNodeType() == Node.ELEMENT_NODE) {//

                            Element publicationElement = (Element) publicationNode;

                            String type = publicationElement.getElementsByTagName("Type").item(0).getTextContent();
                            System.out.println("Type: " + type);

                            if (type.equals("Video")) {

                                String duration = publicationElement.getElementsByTagName("Duration").item(0).getTextContent();
                                String resX = publicationElement.getElementsByTagName("X").item(0).getTextContent();
                                String resY = publicationElement.getElementsByTagName("Y").item(0).getTextContent();
                                String frameAmount = publicationElement.getElementsByTagName("FrameAmount").item(0).getTextContent();

                                System.out.println("Duration: " + duration);
                                System.out.println("Resolution: " + resX + "x" + resY);
                                System.out.println("Frame Amount: " + frameAmount);

                            } else if (type.equals("Image")) {

                                String resX = publicationElement.getElementsByTagName("X").item(0).getTextContent();
                                String resY = publicationElement.getElementsByTagName("Y").item(0).getTextContent();
                                String length = publicationElement.getElementsByTagName("lenght").item(0).getTextContent();
                                String height = publicationElement.getElementsByTagName("height").item(0).getTextContent();

                                System.out.println("Resolution: " + resX + "x" + resY);
                                System.out.println("Lenght: " + length);
                                System.out.println("Height: " + height);

                            } else if (type.equals("Audio")) {

                                String duration = publicationElement.getElementsByTagName("Duration").item(0).getTextContent();
                                String bits = publicationElement.getElementsByTagName("Bits").item(0).getTextContent();

                                System.out.println("Duration: " + duration);
                                System.out.println("Bits: " + bits);

                            }

                            String description = publicationElement.getElementsByTagName("Description").item(0).getTextContent();
                            String uploadDate = publicationElement.getElementsByTagName("UploadDate").item(0).getTextContent();
                            String likes = publicationElement.getElementsByTagName("Likes").item(0).getTextContent();

                            System.out.println("Description: " + description);
                            System.out.println("UploadDate: " + uploadDate);
                            System.out.println("Likes: " + likes);

                            NodeList hashtagList = publicationElement.getElementsByTagName("Hashtags");

                            System.out.println("Hashtags: ");

                            for (int l = 0; l < hashtagList.getLength(); l++) {

                                Node hashtagNode = hashtagList.item(i);
                                String hashtag = hashtagNode.getTextContent();
                                System.out.println(hashtag);

                            }

                            NodeList commentList = publicationElement.getElementsByTagName("Comments");

                            System.out.println("Comments: ");

                            for (int l = 0; l < commentList.getLength(); l++) {

                                Node commentNode = commentList.item(i);
                                String comment = commentNode.getTextContent();
                                System.out.println(comment);

                            }

                            System.out.println("---------------------------");

                        }
                    }
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
