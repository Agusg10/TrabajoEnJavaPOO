package XML;

import DomainClasses.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class ClassXML {
    public InstagramProfile loadXML() {
        try {
            File xmlFile = new File("C:/Users/agust/OneDrive/Escritorio/DatosTP.xml"); // Replace with the actual XML file path

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            Element profileElement = (Element) doc.getElementsByTagName("Profile").item(0);
            String username = profileElement.getElementsByTagName("User").item(0).getTextContent();
            String name = profileElement.getElementsByTagName("Name").item(0).getTextContent();
            String surname = profileElement.getElementsByTagName("Surname").item(0).getTextContent();
            String password = profileElement.getElementsByTagName("Password").item(0).getTextContent();
            InstagramProfile profile = new InstagramProfile(username, name, surname,password);

            ArrayList<Publication> publications = new ArrayList<>();
            NodeList publicationNodes = profileElement.getElementsByTagName("Publication");
            for (int i = 0; i < publicationNodes.getLength(); i++) {
                Node publicationNode = publicationNodes.item(i);
                if (publicationNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element publicationElement = (Element) publicationNode;

                    NodeList hashtagNodes = publicationElement.getElementsByTagName("Hashtag");
                    ArrayList<String> hashtags = new ArrayList<>();
                    for (int j = 0; j < hashtagNodes.getLength(); j++) {
                        hashtags.add(hashtagNodes.item(j).getTextContent());
                    }

                    NodeList commentNodes = publicationElement.getElementsByTagName("Comment");
                    ArrayList<String> comments = new ArrayList<>();
                    for (int j = 0; j < commentNodes.getLength(); j++) {
                        comments.add(commentNodes.item(j).getTextContent());
                    }

                    String type = publicationElement.getElementsByTagName("Type").item(0).getTextContent();
                    String publicationName = publicationElement.getElementsByTagName("PublicationName").item(0).getTextContent();
                    Date uploadDate = new SimpleDateFormat("dd/MM/yyyy").parse(publicationElement.getElementsByTagName("UploadDate").item(0).getTextContent());
                    int likes = Integer.parseInt(publicationElement.getElementsByTagName("Likes").item(0).getTextContent());

                    Publication publication = null;
                    if (type.equals("Video")) {
                        int duration = Integer.parseInt(publicationElement.getElementsByTagName("Duration").item(0).getTextContent());
                        int[] resolution = new int[2];
                        resolution[0] = Integer.parseInt(publicationElement.getElementsByTagName("X").item(0).getTextContent());
                        resolution[1] = Integer.parseInt(publicationElement.getElementsByTagName("Y").item(0).getTextContent());
                        int frameAmount = Integer.parseInt(publicationElement.getElementsByTagName("FrameAmount").item(0).getTextContent());
                        publication = new Video(username, uploadDate, likes, publicationName, hashtags, comments, duration, resolution, frameAmount);
                    } else if (type.equals("Image")) {
                        int[] resolution = new int[2];
                        resolution[0] = Integer.parseInt(publicationElement.getElementsByTagName("X").item(0).getTextContent());
                        resolution[1] = Integer.parseInt(publicationElement.getElementsByTagName("Y").item(0).getTextContent());
                        int length = Integer.parseInt(publicationElement.getElementsByTagName("lenght").item(0).getTextContent()); // Typo in XML, it should be "length"
                        int height = Integer.parseInt(publicationElement.getElementsByTagName("height").item(0).getTextContent());
                        publication = new Image(username, uploadDate, likes, publicationName, hashtags, comments, resolution, length, height);
                    } else if (type.equals("Audio")) {
                        int duration = Integer.parseInt(publicationElement.getElementsByTagName("Duration").item(0).getTextContent());
                        int bits = Integer.parseInt(publicationElement.getElementsByTagName("Bits").item(0).getTextContent());
                        publication = new Audio(username, uploadDate, likes, publicationName, hashtags, comments, duration, bits);
                    }else if (type.equals("Text")){
                        //double characterAmount = Double.parseDouble(publicationElement.getElementsByTagName("CharacterAmount").item(0).getTextContent());
                        int characteramount = Integer.parseInt(publicationElement.getElementsByTagName("CharacterAmount").item(0).getTextContent());
                        String font = publicationElement.getElementsByTagName("Font").item(0).getTextContent();
                        double size = Double.parseDouble(publicationElement.getElementsByTagName("Size").item(0).getTextContent());
                        publication = new Text(username,uploadDate,likes,publicationName,hashtags,comments,characteramount,font,size);
                    }
                    publications.add(publication);
                }
            }
            profile.setPublications(publications);
            return profile;
        } catch (Exception e) {
            e.printStackTrace();
        }
        //return new InstagramProfile(loadXML().getUser(), loadXML().getName(), loadXML().getSurname());
        return new InstagramProfile("null","null","null","null");
    }
}


