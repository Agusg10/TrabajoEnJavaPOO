package Comparator;

import DomainClasses.Publication;

import java.util.*;

public class PublicationLikesComparator implements Comparator<Publication> {
    public int compare(Publication a , Publication b){
        return Integer.compare(a.getLikes(),b.getLikes());
    }
}
