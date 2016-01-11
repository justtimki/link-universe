package command;

import JsoupParser.Parser;
import filters.LinkFilter;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashSet;

/**
 * Created by timki on 11.01.2016.
 */
public class ProcessLinkCommand implements Command {

    private static final String PARAM_LINK = "link";
    private static final String PARAM_VALID_LINKS = "validLinks";

    public String execute(HttpServletRequest request) {
        String page = null;
        HashSet<String> allLinks = null;
        HashSet<String> validLinks = null;
        LinkFilter filter = null;
        String link = request.getParameter(PARAM_LINK);
        Parser parser = new Parser(link);
        try {
            allLinks = parser.findLinks();
            filter = new LinkFilter(allLinks);
            validLinks = filter.getValidWebsiteLinks();
            request.setAttribute(PARAM_VALID_LINKS, validLinks);

        } catch (IOException e) {
            e.printStackTrace();
        }

        //TODO redirect to page

        return page;
    }
}
