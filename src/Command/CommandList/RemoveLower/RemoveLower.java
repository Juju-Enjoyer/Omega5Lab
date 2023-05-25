package Command.CommandList.RemoveLower;

import Command.CollectionManager.CollectionManager;
import Command.CommandProcessor.Command;
import Exceptions.IllegalKeyException;
import Exceptions.IllegalValueException;
import Exceptions.NoSuchCommandException;

public class RemoveLower implements Command {
    private CollectionManager cm;
    public RemoveLower(CollectionManager cm){
        this.cm=cm;
    }
    @Override
    public String getName() {
        return "REMOVELOWER";
    }

    @Override
    public String getDescription() {
        return "удалить из коллекции все элементы, меньшие, чем заданный";
    }

    @Override
    public boolean execute(String args) throws NoSuchCommandException, IllegalKeyException, IllegalValueException {
        if (!args.isEmpty()){
            throw new NoSuchCommandException();
        }
        cm.removeLower();
        return true;
    }
}
