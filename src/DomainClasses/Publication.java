package DomainClasses;

import java.util.ArrayList;
import java.util.Date;

/**
 * Represents a publication made by a user.
 */
public class Publication {
    private String user;
    private Date uploadDate;
    private int likes;
    private String publicationName; //sort by name
    ArrayList<String> hashtags; //add setters
    ArrayList<String> comments; //add setters

    /**
     * Constructs an empty publication.
     */
    public Publication() {
    }

    /**
     * Constructs a publication with the specified details.
     *
     * @param user            the user who made the publication
     * @param uploadDate      the date when the publication was uploaded
     * @param likes           the number of likes the publication has
     * @param publicationName the name of the publication
     * @param hashtags        the list of hashtags associated with the publication
     * @param comments        the list of comments on the publication
     */
    public Publication(String user, Date uploadDate, int likes, String publicationName, ArrayList<String> hashtags, ArrayList<String> comments) {
        this.user = user;
        this.uploadDate = uploadDate;
        this.likes = likes;
        this.publicationName = publicationName;
        this.hashtags = hashtags;
        this.comments = comments;
    }

    /**
     * Returns the user who made the publication.
     *
     * @return the user who made the publication
     */
    public String getUser() {
        return user;
    }

    /**
     * Returns the date when the publication was uploaded.
     *
     * @return the upload date of the publication
     */
    public Date getUploadDate() {
        return uploadDate;
    }

    /**
     * Returns the number of likes the publication has.
     *
     * @return the number of likes of the publication
     */
    public int getLikes() {
        return likes;
    }

    /**
     * Returns the name of the publication.
     *
     * @return the name of the publication
     */
    public String getPublicationName() {
        return publicationName;
    }

    /**
     * Returns the list of hashtags associated with the publication.
     *
     * @return the list of hashtags of the publication
     */
    public ArrayList<String> getHashtags() {
        return hashtags;
    }

    /**
     * Returns the list of comments on the publication.
     *
     * @return the list of comments on the publication
     */
    public ArrayList<String> getComments() {
        return comments;
    }

    /**
     * Returns a string representation of the publication.
     *
     * @return a string representation of the publication
     */
    public String toString() {
        return "\n\n     User: " + user +
                "\n     Upload Date: " + uploadDate +
                "\n     Likes: " + likes +
                "\n     Publication Name: " + publicationName +
                "\n     Hashtags: " + getHashtags() +
                "\n     Comments: " + getComments();
    }
}

