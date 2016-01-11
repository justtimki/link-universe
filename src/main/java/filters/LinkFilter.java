package filters;

/**
 * Created by timki on 09.01.2016.
 */
public class LinkFilter {

    String websiteLink;

    public LinkFilter(String websiteLink) {
        this.websiteLink = websiteLink;
    }

    public boolean isEmptyLink(String link) {
        for(int i = 0; i < link.length(); i++) {
            if(link.charAt(i) != ' ' && link.charAt(i) != '\r') {
                return false;
            }
        }
        return true;
    }
}
