package Comparator;
import DomainClasses.Publication;

import java.util.*;

public class PublicationDescriptionComparator implements Comparator<Publication>{
    public int compare(Publication a, Publication b){
        return a.getDescription().compareTo(b.getDescription());
    }
}
