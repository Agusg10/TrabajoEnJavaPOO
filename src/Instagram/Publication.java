package Instagram;

import java.util.ArrayList;

public class Publication {
    private String user;
    private String uploadDate;
    private int likes;
    ArrayList<String> hashtags; //add setters
    ArrayList<String> comments; //add setters

    public Publication() {
    }

    public Publication(String user, String uploadDate, int likes, ArrayList<String> hashtags, ArrayList<String> comments) {
        this.user = user;
        this.uploadDate = uploadDate;
        this.likes = likes;
        this.hashtags = hashtags;
        this.comments = comments;
    }

    public String getUser() {
        return user;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public int getLikes() {
        return likes;
    }
}

