package Command.CommandList.RemoveAnyByNumberOfRooms;

import Command.CollectionManager.CollectionManager;
import Command.CommandProcessor.Command;
import Exceptions.IllegalKeyException;
import Exceptions.IllegalValueException;
import Exceptions.NoSuchCommandException;

public class RemoveAnyByNumberOfRooms implements Command {
    private CollectionManager cm;
    public RemoveAnyByNumberOfRooms(CollectionManager cm){
        this.cm=cm;
    }
    @Override
    public String getName() {
        return "REMOVEANYBYNUMBEROFROOMS";
    }

    @Override
    public String getDescription() {
        return "удалить из коллекции один элемент, значение поля numberOfRooms которого эквивалентно заданному";
    }

    @Override
    public boolean execute(String args) throws NoSuchCommandException, IllegalKeyException, IllegalValueException {
        if (args.isEmpty()){
            throw new NoSuchCommandException();
        }
        int key = Integer.parseInt(args);
        cm.removeAnyByNumberOfRooms(key);
        return true;
    }
}

