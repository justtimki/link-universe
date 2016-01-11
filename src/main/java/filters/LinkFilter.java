package filters;

import java.util.HashSet;

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
        validWebsiteLinks = new HashSet<String>();
        for (String link : websiteLinks) {
            if (!isEmptyLink(link)) {
                validWebsiteLinks.add(link);
            }
        }
        return validWebsiteLinks;
    }

    private boolean isEmptyLink(String link) {
        for(int i = 0; i < link.length(); i++) {
            if(link.charAt(i) != ' ' && link.charAt(i) != '\r') {
                return false;
            }
        }
        return true;
    }

    //TODO create another filter methods
}
