package DomainClasses;

import java.util.ArrayList;
import java.util.Date;

public class Publication {
    private String user;
    private Date uploadDate;
    private int likes;
    ArrayList<String> hashtags; //add setters
    ArrayList<String> comments; //add setters

    public Publication() {
    }

    public Publication(String user, Date uploadDate, int likes) {
        this.user = user;
        this.uploadDate = uploadDate;
        this.likes = likes;
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
}

