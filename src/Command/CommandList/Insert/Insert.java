package Command.CommandList.Insert;

import Command.CollectionManager.CollectionManager;
import Command.CommandProcessor.Command;
import Exceptions.IllegalKeyException;
import Exceptions.IllegalValueException;
import Exceptions.NoSuchCommandException;

public class Insert implements Command {
    private CollectionManager cm;
    public Insert(CollectionManager cm){
        this.cm=cm;
    }
    @Override
    public String getName() {
        return "INSERT";
    }

    @Override
    public String getDescription() {
        return "добавить новый элемент с заданным ключом";
    }

    @Override
    public boolean execute(String args) throws NoSuchCommandException, NumberFormatException, IllegalKeyException, IllegalValueException {
        if (args.isEmpty()){
            throw new NoSuchCommandException();
        }
        else if (cm.getCollection().containsKey(Long.valueOf(args))){
            throw new IllegalKeyException("уже есть квартира с таким номером\"");
        }
        int key = Integer.parseInt(args);
        cm.insert(key);
        return true;
    }
}
