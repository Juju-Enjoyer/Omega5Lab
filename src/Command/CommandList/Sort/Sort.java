package Command.CommandList.Sort;

import Command.CollectionManager.CollectionManager;
import Command.CommandProcessor.Command;
import Exceptions.IllegalKeyException;
import Exceptions.IllegalValueException;
import Exceptions.NoSuchCommandException;

public class Sort implements Command {
    private CollectionManager cm;
    public Sort(CollectionManager cm){
        this.cm=cm;
    }
    @Override
    public String getName() {
        return "SORT";
    }

    @Override
    public String getDescription() {
        return "сокращение для print_field_ascending_house вывести значения поля house всех элементов в порядке возрастания";
    }

    @Override
    public boolean execute(String args) throws NoSuchCommandException, IllegalKeyException, IllegalValueException {
        if (!args.isEmpty()){
            throw new NoSuchCommandException();
        }
        cm.sort();
        return true;
    }
}
