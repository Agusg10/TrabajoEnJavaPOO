package DomainClasses;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Filters {

    public static ArrayList<Publication> filterByLikes(ArrayList<Publication> publications, int minLikes) {
        ArrayList<Publication> filteredPublications = new ArrayList<>();
        for (Publication publication : publications) {
            if (publication.getLikes() >= minLikes) {
                filteredPublications.add(publication);
            }
        }
        return filteredPublications;
    }

    public static ArrayList<Publication> filterByDuration(List<Publication> publications, int maxDuration) {
        ArrayList<Publication> filteredPublications = new ArrayList<>();
        for (Publication publication : publications) {
            if (publication instanceof Video) {
                if (((Video) publication).getDuration() <= maxDuration) {
                    filteredPublications.add(publication);
                }
            } else if (publication instanceof Audio) {
                if (((Audio)publication).getDuration() <= maxDuration) {
                    filteredPublications.add(publication);
                }
            }
        }
        return filteredPublications;
    }



    public static ArrayList<Publication> filterByUploadDate(List<Publication> publications, Date uploadDateMin, Date uploadDateMax) {
        ArrayList<Publication> filteredPublications = new ArrayList<>();
        for (Publication publication : publications) {
            Date uploadDate = publication.getUploadDate();
            if ((uploadDate.after(uploadDateMin) || uploadDate.equals(uploadDateMin)) && (uploadDate.before(uploadDateMax) || uploadDate.equals(uploadDateMax))) {
                filteredPublications.add(publication);
            }
        }
        return filteredPublications;
    }


    public static ArrayList<Publication> filterByHashtag(List<Publication> publications, String hashtag) {
        ArrayList<Publication> filteredPublications = new ArrayList<>();
        for (Publication publication : publications) {
            if (publication.getHashtags().contains(hashtag)) {
                filteredPublications.add(publication);
            }
        }
        return filteredPublications;
    }

}