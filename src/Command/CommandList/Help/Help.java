package Command.CommandList.Help;

import Command.CollectionManager.CollectionManager;
import Command.CommandProcessor.Command;

public class Help implements Command {
    private CollectionManager cm;
    public Help(CollectionManager cm){
        this.cm=cm;
    }
    @Override
    public String getName(){
        return "HELP";
    }
    @Override
    public String getDescription(){
        return "вывести справку по доступным командам";
    }

    @Override
    public boolean execute(String args) {
        cm.help();
        return true;
    }
}
