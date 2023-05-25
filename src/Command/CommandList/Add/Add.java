package Command.CommandList.Add;

import Command.CollectionManager.CollectionManager;
import Command.CommandProcessor.Command;
import Exceptions.IllegalValueException;

public class Add implements Command {
    private CollectionManager cm;
    public Add(CollectionManager cm){
        this.cm=cm;
    }


    @Override
    public String getName() {
        return "ADD";
    }

    @Override
    public String getDescription() {
        return "Добавь";
    }

    @Override
    public boolean execute(String args) throws IllegalValueException {
        cm.add();

        return true;
    }
}
