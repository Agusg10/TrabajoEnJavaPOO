package Comparator;

import DomainClasses.Publication;

import java.util.Comparator;

/**
 * The {@code PublicationNameComparator} class implements the {@code Comparator} interface to compare publications based on their names.
 */
public class PublicationNameComparator implements Comparator<Publication> {

    /**
     * Compares two publications based on their names.
     *
     * @param a the first publication to compare
     * @param b the second publication to compare
     * @return a negative integer, zero, or a positive integer as the first publication name is less than, equal to, or greater than the second publication name
     */
    public int compare(Publication a, Publication b) {
        return a.getPublicationName().compareTo(b.getPublicationName());
    }
}