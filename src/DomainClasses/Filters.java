package DomainClasses;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 The Filters class provides methods for filtering publications based on different criteria.
 */
public class Filters {
    /**
     * Filters the given list of publications based on the minimum number of likes.
     *
     * @param publications The list of publications to be filtered.
     * @param minLikes     The minimum number of likes.
     * @return An ArrayList of publications that have at least the minimum number of likes.
     */
    public static ArrayList<Publication> filterByLikes(ArrayList<Publication> publications, int minLikes) {
        ArrayList<Publication> filteredPublications = new ArrayList<>();
        for (Publication publication : publications) {
            if (publication.getLikes() >= minLikes) {
                filteredPublications.add(publication);
            }
        }
        return filteredPublications;
    }

    /**
     * Filters the given list of publications based on the maximum duration.
     *
     * @param publications The list of publications to be filtered.
     * @param maxDuration  The maximum duration allowed.
     * @return An ArrayList of publications that have a duration less than or equal to the maximum duration.
     */
    public static ArrayList<Publication> filterByDuration(List<Publication> publications, int maxDuration) {
        ArrayList<Publication> filteredPublications = new ArrayList<>();
        for (Publication publication : publications) {
            if (publication instanceof Video) {
                if (((Video) publication).getDuration() <= maxDuration) {
                    filteredPublications.add(publication);
                }
            } else if (publication instanceof Audio) {
                if (((Audio) publication).getDuration() <= maxDuration) {
                    filteredPublications.add(publication);
                }
            }
        }
        return filteredPublications;
    }

    /**
     * Filters the given list of publications based on the upload date range.
     *
     * @param publications   The list of publications to be filtered.
     * @param uploadDateMin  The minimum upload date.
     * @param uploadDateMax  The maximum upload date.
     * @return An ArrayList of publications that were uploaded within the specified date range.
     */
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

    /**
     * Filters the given list of publications based on the specified hashtag.
     *
     * @param publications The list of publications to be filtered.
     * @param hashtag      The hashtag to filter by.
     * @return An ArrayList of publications that contain the specified hashtag.
     */
    public static ArrayList<Publication> filterByHashtag(List<Publication> publications, String hashtag) {
        ArrayList<Publication> filteredPublications = new ArrayList<>();
        for (Publication publication : publications) {
            if (publication.getHashtags().contains(hashtag)) {
                filteredPublications.add(publication);
            }
        }
        return filteredPublications;
    }}