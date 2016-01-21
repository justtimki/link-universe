package enumeration;

import command.Command;
import command.EmptyCommand;
import command.ProcessLinkCommand;

/**
 * Created by timki on 21.01.2016.
 */
public enum CommandEnum {

    EMPTY {
        {
            this.command = new EmptyCommand();
        }
    },
    PROCESS_LINK {
        {
            this.command = new ProcessLinkCommand();
        }
    };

    Command command;

    public Command getCommand() {
        return command;
    }
}
