package Command.CommandList.UpdateById;

import Command.CollectionManager.CollectionManager;
import Command.CommandProcessor.Command;
import Exceptions.IllegalKeyException;
import Exceptions.IllegalValueException;
import Exceptions.NoSuchCommandException;

public class UpdateById implements Command {
    private CollectionManager cm;
    public UpdateById(CollectionManager cm){
        this.cm=cm;
    }

    @Override
    public String getName() {
        return "UPDATEBYID";
    }

    @Override
    public String getDescription() {
        return "обновить значение элемента коллекции, id которого равен заданному";
    }

    @Override
    public boolean execute(String args) throws NoSuchCommandException, IllegalKeyException, IllegalValueException {
        try {
            if (args.isEmpty()) {
                throw new NoSuchCommandException();
            }

            long key = Long.parseLong(args);
            return cm.update(key);}
        catch (NumberFormatException e){
            System.out.println("String там где не надо");
        }
        return true;
    }
}
