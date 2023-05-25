package Command.CommandProcessor;

import Exceptions.IllegalKeyException;
import Exceptions.IllegalValueException;
import Exceptions.NoSuchCommandException;

public interface Command {
    String getName();
    String getDescription();
    boolean execute(String args) throws NoSuchCommandException, IllegalKeyException, IllegalValueException;
}
