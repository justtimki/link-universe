package command;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by timki on 21.01.2016.
 */
public class EmptyCommand implements Command {

    private static final String MAIN_PAGE_PATH = "/index.jsp";

    public String execute(HttpServletRequest request) {
        return MAIN_PAGE_PATH;
    }
}
