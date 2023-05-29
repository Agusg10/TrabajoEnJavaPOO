package Comparator;

import DomainClasses.Publication;

import java.util.Comparator;

/**
 * The {@code PublicationLikesComparator} class implements the {@code Comparator} interface to compare publications based on their number of likes.
 */
public class PublicationLikesComparator implements Comparator<Publication> {

    /**
     * Compares two publications based on their number of likes.
     *
     * @param a the first publication to compare
     * @param b the second publication to compare
     * @return a negative integer, zero, or a positive integer as the number of likes of the first publication is less than, equal to, or greater than the number of likes of the second publication
     */
    public int compare(Publication a, Publication b) {
        return Integer.compare(a.getLikes(), b.getLikes());
    }
}
