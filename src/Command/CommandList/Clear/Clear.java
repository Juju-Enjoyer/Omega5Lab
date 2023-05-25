package Command.CommandList.Clear;

import Command.CollectionManager.CollectionManager;
import Command.CommandProcessor.Command;
import Exceptions.IllegalKeyException;
import Exceptions.IllegalValueException;
import Exceptions.NoSuchCommandException;

public class Clear implements Command {
    private CollectionManager cm;
    public Clear(CollectionManager cm){
        this.cm=cm;
    }
    @Override
    public String getName() {
        return "CLEAR";
    }

    @Override
    public String getDescription() {
        return "очистить коллекцию";
    }

    @Override
    public boolean execute(String args) throws NoSuchCommandException, IllegalKeyException, IllegalValueException {
        if (!args.isEmpty()){
            throw new NoSuchCommandException();
        }
        if (cm.getCollection().size()==0){
            System.out.println("коллекция и так пуста");;
        }
        cm.clear();
        return true;
    }
}
