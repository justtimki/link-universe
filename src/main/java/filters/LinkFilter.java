package filters;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by timki on 09.01.2016.
 */
public class LinkFilter {

    private HashSet<String> websiteLinks;
    private HashSet<String> validWebsiteLinks;
    private String mainLink;

    public LinkFilter(String mainLink, HashSet<String> websiteLinks) {
        this.websiteLinks = websiteLinks;
        this.mainLink = mainLink;
    }

    public HashSet<String> getValidWebsiteLinks() {
        validWebsiteLinks = new HashSet<String>();
        for (String link : websiteLinks) {
            if (isLink(link) && isNewLink(link) && isInternalLink(link)) {
                validWebsiteLinks.add(link);
            }
        }
        return validWebsiteLinks;
    }

    /*private boolean isEmptyLink(String link) {
        Pattern p = Pattern.compile("\\s+ | \\r+");
        Matcher m = p.matcher(link);
        return m.matches();
    }*/

    private boolean isLink(String link) {
        Pattern p = Pattern.compile("\\s*(https?://).+");
        Matcher m = p.matcher(link);
        return m.matches();
    }

    private boolean isNewLink(String link) {
        for (String validLink : validWebsiteLinks) {
            if (link.equals(validLink)) return false;
        }
        return true;
    }

    private boolean isInternalLink(String link) {
        String[] nameCheckLink = link.split("/");
        String[] nameMainLink = mainLink.split("/");
        return !nameMainLink[2].equals(nameCheckLink[2]);
    }


    //TODO create another filter methods
}
