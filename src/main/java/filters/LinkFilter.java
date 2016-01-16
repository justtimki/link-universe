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


    public LinkFilter(HashSet<String> websiteLinks) {
        this.websiteLinks = websiteLinks;
    }

    public HashSet<String> getValidWebsiteLinks() {
        //String mainLink = "http://kino-dom.org";
        validWebsiteLinks = new HashSet<String>();
        for (String link : websiteLinks) {
            if (isLink(link) && isNewLink(link)) {
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

    private boolean isInternalLink(String checkLink, String mainLink) {
        String[] nameCheckLink = checkLink.split("/");
        String[] nameMainLink = mainLink.split("/");
        //System.out.println(nameCheckLink[0]);
        return !nameMainLink[2].toString().equals(nameCheckLink[2].toString());
    }


    //TODO create another filter methods
}
