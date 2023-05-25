package Command.CommandList.Exit;

import Command.CollectionManager.CollectionManager;
import Command.CommandProcessor.Command;

public class Exit implements Command {
    private CollectionManager cm;
    public Exit (CollectionManager cm){
        this.cm=cm;
    }
    @Override
    public String getName(){
        return "EXIT";
    }
    @Override
    public String getDescription(){
        return "завершить программу (без сохранения в файл)";
    }

    @Override
    public boolean execute(String args) {
        boolean  res = cm.exit();

        return res;
    }


}
