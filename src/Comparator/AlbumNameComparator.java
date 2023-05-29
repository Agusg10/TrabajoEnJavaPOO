package Comparator;

import DomainClasses.Album;

import java.util.Comparator;

/**
 * The {@code AlbumNameComparator} class implements the {@code Comparator} interface to compare albums based on their names.
 */
public class AlbumNameComparator implements Comparator<Album> {

    /**
     * Compares two albums based on their names.
     *
     * @param a the first album to compare
     * @param b the second album to compare
     * @return a negative integer, zero, or a positive integer as the first album name is less than, equal to, or greater than the second album name
     */
    public int compare(Album a, Album b) {
        return a.getAlbumName().compareTo(b.getAlbumName());
    }
}