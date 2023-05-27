package DomainClasses;

import java.util.ArrayList;
import java.util.List;

public class Filters {
    private List<String> attributes;
    private List<Publication> originalPublications;

    public Filters(List<String> attributes, List<Publication> originalPublications) {
        this.attributes = attributes;
        this.originalPublications = originalPublications;
    }

    public List<Publication> filterPublications(String attribute, String value) {
        List<Publication> filterPublications = new ArrayList<>();

        for (Publication publication : originalPublications) {
            if (equalsFilter(publication, attribute, value)) {
                filterPublications.add(publication);
            }
        }

        return filterPublications;
    }

    private boolean equalsFilter(Publication publication, String attribute, String value) {
        switch (attribute) {
            case "Likes":
                return publication.getLikes() >= Integer.parseInt(value);
            case "Duration":
                if (publication instanceof Video)
                    return ((Video) publication).getDuration() >= Integer.parseInt(value);
                else
                if (publication instanceof Audio)
                    return ((Audio) publication).getDuration() >= Integer.parseInt(value);
            case "uploadDate":
                String OriginalDate=publication.getUploadDate().toString();
                return OriginalDate.equals(value);
            case "Hashtags":
                return publication.getHashtags().contains(value);
            default:
                return false;
        }
    }
}