package Comparator;
import DomainClasses.Publication;

import java.util.*;

public class PublicationNameComparator implements Comparator<Publication>{
    public int compare(Publication a, Publication b){
        return a.getPublicationName().compareTo(b.getPublicationName());
    }
}
