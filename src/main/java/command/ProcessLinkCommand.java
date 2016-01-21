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

    private static final String PARAM_LINK = "linkField";
    private static final String PARAM_VALID_LINKS = "validLinks";
    private static final String PARAM_MAIN_LINK = "mainLink";

    private static final String LINK_PAGE_PATH = "/jsp/linkPage/linkPage.jsp";
    private static final String MAIN_PAGE_PATH = "/index.jsp";

    public String execute(HttpServletRequest request) {
        String page = null;
        HashSet<String> allLinks = null;
        HashSet<String> validLinks = null;
        LinkFilter filter = null;
        String link = request.getParameter(PARAM_LINK);
        Parser parser = new Parser(link);
        try {
            allLinks = parser.findLinks();
            filter = new LinkFilter(link, allLinks);
            validLinks = filter.getValidWebsiteLinks();
            request.getSession().setAttribute(PARAM_VALID_LINKS, validLinks);
            request.getSession().setAttribute(PARAM_MAIN_LINK, link);
            page = LINK_PAGE_PATH;

        } catch (IOException e) {
            e.printStackTrace();
            page = MAIN_PAGE_PATH;
        }

        return page;
    }
}
