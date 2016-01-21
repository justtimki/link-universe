package helper;

import command.Command;
import command.EmptyCommand;
import enumeration.CommandEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by timki on 21.01.2016.
 */
public class RequestHelper {
    private static final String PARAM_COMMAND = "command";
    private static final Logger logger = LogManager.getLogger();

    private static RequestHelper instance;

    public static RequestHelper getInstance() {
        if (instance == null)
            instance = new RequestHelper();
        return instance;
    }

    private RequestHelper() {
    }

    public Command defineCommand(HttpServletRequest request) {
        Command command = new EmptyCommand();
        String action = request.getParameter(PARAM_COMMAND);
        if (action == null || action.isEmpty())
            return command;
        try {
            CommandEnum commandEnum = CommandEnum.valueOf(action.toUpperCase());
            command = commandEnum.getCommand();
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage());
        }
        return command;
    }

}
