package Command.CommandList.RemoveGreater;

import Command.CollectionManager.CollectionManager;
import Command.CommandProcessor.Command;
import Exceptions.IllegalKeyException;
import Exceptions.IllegalValueException;
import Exceptions.NoSuchCommandException;

public class RemoveGreater implements Command {
    private CollectionManager cm;
    public RemoveGreater(CollectionManager cm){
        this.cm=cm;
    }
    @Override
    public String getName() {
        return "REMOVEGREATER";
    }

    @Override
    public String getDescription() {
        return "удалить из коллекции все элементы, превышающие заданный";
    }

    @Override
    public boolean execute(String args) throws NoSuchCommandException, IllegalKeyException, IllegalValueException {
        if (!args.isEmpty()){
            throw new NoSuchCommandException();
        }
        cm.removeGreater();
        return true;
    }
}
