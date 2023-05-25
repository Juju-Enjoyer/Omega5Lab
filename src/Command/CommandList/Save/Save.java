package Command.CommandList.Save;

import Command.CollectionManager.CollectionManager;
import Command.CommandProcessor.Command;
import Exceptions.IllegalKeyException;
import Exceptions.IllegalValueException;
import Exceptions.NoSuchCommandException;

import java.io.File;

public class Save implements Command{
    private CollectionManager cm;
    public Save(CollectionManager cm){
        this.cm=cm;
    }

    @Override
    public String getName() {
        return "SAVE";
    }

    @Override
    public String getDescription() {
        return "без аргумента - сохранить коллекцию в файл, с аргументов - а назначенный файл";
    }

    @Override
    public boolean execute(String args) throws NoSuchCommandException, IllegalKeyException, IllegalValueException {
        if (args.contains("/")){
            cm.save(args);
        }
        else if(!args.contains("/")&(!args.isEmpty()) ){
            File file = new File(args);
            cm.save(file);
        }
        else if ((args.equals(""))||args.equals(null)) {
            cm.save();
        }
        return true;
    }
}
