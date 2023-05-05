package DomainClasses;

import java.util.ArrayList;
import java.util.Date;

public class Publication {
    private String user;
    private Date uploadDate;
    private int likes;
    private String description; //sort by name
    ArrayList<String> hashtags; //add setters
    ArrayList<String> comments; //add setters

    public Publication() {
    }

    public Publication(String user, Date uploadDate, int likes, String description,ArrayList<String> hashtags, ArrayList<String> comments) {
        this.user = user;
        this.uploadDate = uploadDate;
        this.likes = likes;
        this.description = description;
        this.hashtags = hashtags;
        this.comments = comments;
    }

    public String getUser() {
        return user;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public int getLikes() {
        return likes;
    }

    public String getDescription(){ return description; }

    public String toString(){
        //getHashtags(hashtags);
        return "User: "+user+" Upload Date: "+uploadDate+" Likes: "+likes+" Description: "+description+" Hashtags: "+hashtags.toString();
    }
}

