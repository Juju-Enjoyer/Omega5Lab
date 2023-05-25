package Command.CommandList.CountLessThanNumberOfRooms;

import Command.CollectionManager.CollectionManager;
import Command.CommandProcessor.Command;
import Exceptions.IllegalKeyException;
import Exceptions.IllegalValueException;
import Exceptions.NoSuchCommandException;

public class CountLessThanNumberOfRooms implements Command {
    private CollectionManager cm;
    public CountLessThanNumberOfRooms(CollectionManager cm){
        this.cm=cm;
    }
    @Override
    public String getName() {
        return "COUNTLESSTHANNUMBEROFROOMS";
    }

    @Override
    public String getDescription() {
        return "вывести количество элементов, значение поля numberOfRooms которых меньше заданного";
    }

    @Override
    public boolean execute(String args) throws NoSuchCommandException, IllegalKeyException, IllegalValueException {
        if (args.isEmpty()){
            throw new NoSuchCommandException();
        }
        int key = Integer.parseInt(args);
        cm.countLessThanNumberOfRooms(key);
        return true;
    }
}
