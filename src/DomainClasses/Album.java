package DomainClasses;

import java.util.ArrayList;

/**
 * The {@code Album} class represents an album containing publications and sub-albums.
 */
public class Album {
    private String albumName;
    private ArrayList<Publication> publications; // add setters
    private ArrayList<Album> subAlbums; // add setters

    /**
     * Constructs an {@code Album} object with the specified album name.
     *
     * @param albumName the name of the album
     */
    public Album(String albumName) {
        this.albumName = albumName;
        this.publications = null;
        this.subAlbums = null;
    }

    /**
     * Returns the name of the album.
     *
     * @return the name of the album
     */
    public String getAlbumName() {
        return albumName;
    }

    /**
     * Returns the list of publications in the album.
     *
     * @return the list of publications in the album
     */
    public ArrayList<Publication> getPublications() {
        return publications;
    }

    /**
     * Returns the list of sub-albums in the album.
     *
     * @return the list of sub-albums in the album
     */
    public ArrayList<Album> getSubAlbums() {
        return subAlbums;
    }

    /**
     * Sets the list of publications in the album.
     *
     * @param publications the list of publications to set
     */
    public void setPublications(ArrayList<Publication> publications) {
        this.publications = publications;
    }

    /**
     * Adds a publication to the album.
     *
     * @param publi the publication to add
     */
    public void addPubli(Publication publi) {
        if (this.publications == null) {
            ArrayList<Publication> newPublicationList = new ArrayList<>();
            newPublicationList.add(publi);
            this.publications = newPublicationList;
        } else {
            this.publications.add(publi);
        }
    }

    /**
     * Deletes a publication from the album.
     *
     * @param publi the publication to delete
     */
    public void deletePubli(Publication publi) {
        this.publications.remove(publi);
    }

    /**
     * Adds a sub-album to the album.
     *
     * @param subAlb the sub-album to add
     */
    public void addSubAlbum(Album subAlb) {
        if (this.subAlbums == null) {
            ArrayList<Album> newSubAlbumList = new ArrayList<>();
            newSubAlbumList.add(subAlb);
            this.subAlbums = newSubAlbumList;
        } else {
            this.subAlbums.add(subAlb);
        }
    }

    /**
     * Displays the available publications in the album.
     */
    public void showPublicationsAlbum() {
        if (publications == null || publications.isEmpty()) {
            System.out.println("No existen publicaciones disponibles.");
        } else {
            System.out.println("Publicaciones disponibles:");
            for (Publication publication : publications) {
                System.out.println("- " + publication.getPublicationName());
            }
        }
    }

    /**
     * Returns a string representation of the album.
     *
     * @return a string representation of the album
     */
    public String toString() {
        String aux = "";
        if (this.albumName != null)
            aux = aux + albumName;
        if (this.publications != null)
            aux = aux + " \n     Publications: \n" + publications;
        if (this.subAlbums != null)
            aux = aux + " \n\n     SubAlbums: \n" + subAlbums;
        return aux + "\n";
    }
}
