package Command.CommandList.RemoveKey;

import Command.CollectionManager.CollectionManager;
import Command.CommandProcessor.Command;
import Exceptions.IllegalKeyException;
import Exceptions.IllegalValueException;
import Exceptions.NoSuchCommandException;

public class RemoveKey implements Command {

    private CollectionManager cm;
    public RemoveKey(CollectionManager cm){
        this.cm=cm;
    }
    @Override
    public String getName() {
        return "REMOVEKEY";
    }

    @Override
    public String getDescription() {
        return "удалить элемент из коллекции по его ключу";
    }

    @Override
    public boolean execute(String args) throws NoSuchCommandException, IllegalKeyException, IllegalValueException {
        if (args.isEmpty()){
            throw new NoSuchCommandException();
        }
        if (!cm.getCollection().containsKey(Long.valueOf(args))){
            throw new IllegalKeyException("такого еще нет");
        }
        int key = Integer.parseInt(args);
        cm.removeKey(key);
        return true;
    }
}
