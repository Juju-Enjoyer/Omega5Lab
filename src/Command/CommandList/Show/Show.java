package Command.CommandList.Show;

import Command.CollectionManager.CollectionManager;
import Command.CommandProcessor.Command;

public class Show implements Command {
    private CollectionManager cm;
    public Show (CollectionManager cm){
        this.cm=cm;
    }

    @Override
    public String getName() {
        return "SHOW";
    }

    @Override
    public String getDescription() {
        return "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }

    @Override
    public boolean execute(String args) {
        cm.show();
        System.out.println("Конец Show");
        return true;
    }
}
