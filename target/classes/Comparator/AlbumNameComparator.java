package Comparator;

import DomainClasses.Album;

import java.util.Comparator;

public class AlbumNameComparator implements Comparator<Album> {
    public int compare(Album a, Album b){
        return a.getAlbumName().compareTo(b.getAlbumName());
    }
}
