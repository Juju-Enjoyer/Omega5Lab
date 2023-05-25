package Command.CommandList.History;

import Command.CollectionManager.CollectionManager;
import Command.CommandProcessor.Command;

public class History implements Command {
    private CollectionManager cm;
    public History(CollectionManager cm){
        this.cm=cm;
    }
    @Override
    public String getName() {
        return "HISTORY";
    }

    @Override
    public String getDescription() {
        return "вывести последние команды";
    }

    @Override
    public boolean execute(String args) {
        cm.history();
        return true;
    }
}
