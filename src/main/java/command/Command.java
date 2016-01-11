package command;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by timki on 11.01.2016.
 */
public interface Command {

    String execute(HttpServletRequest request);
}
