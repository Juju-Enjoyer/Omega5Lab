package Command.CommandList.Info;

import Command.CollectionManager.CollectionManager;
import Command.CommandProcessor.Command;
import Exceptions.IllegalKeyException;
import Exceptions.IllegalValueException;
import Exceptions.NoSuchCommandException;

public class Info implements Command {

    private CollectionManager cm;
    public Info(CollectionManager cm){
        this.cm=cm;
    }
    @Override
    public String getName() {
        return "INFO";
    }

    @Override
    public String getDescription() {
        return "вывести в стандартный поток вывода информацию о коллекции";
    }

    @Override
    public boolean execute(String args) throws NoSuchCommandException, IllegalKeyException, IllegalValueException {
        if (!args.isEmpty()){
            throw new NoSuchCommandException();
        }
        cm.info();
        return true;
    }
}
