package Command.CommandList.ExecuteScript;

import Command.CollectionManager.CollectionManager;
import Command.CommandProcessor.Command;
import Command.Parse.FlatJsonConverter;
import Exceptions.IllegalKeyException;
import Exceptions.IllegalValueException;
import Exceptions.NoSuchCommandException;
import com.google.gson.JsonSyntaxException;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ExecuteScript implements Command {
    private CollectionManager cm;
    private ArrayList<String> scripts = new ArrayList<>();
    public ExecuteScript(CollectionManager cm){
        this.cm=cm;
    }

    @Override
    public String getName() {
        return "EXECUTE_SCRIPT";
    }

    @Override
    public String getDescription() {
        return "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме";
    }

    @Override
    public boolean execute(String args) throws JsonSyntaxException, NoSuchCommandException{
        Scanner scFile = new Scanner(System.in);
        FlatJsonConverter gson = new FlatJsonConverter(cm.getCollection());
        boolean result = true;
        String arg = "";
        if (args.isEmpty()){
            throw new NoSuchCommandException();
        }
        else {
            try{
                File file = new File(args);
                if (file.exists()) {
                    while ((!file.canRead())&(!file.canWrite())) {
                        System.out.println("что то не так или не читабельно либо не записываемо");
                        file = new File(scFile.next());
                    }

                    InputStream isr = new FileInputStream(file);
                    InputStreamReader inputStreamReader = new InputStreamReader(isr);
                    BufferedReader reader = new BufferedReader(inputStreamReader);
                    String line = "not null";
                    if (scripts.contains(file.getName())){
                        System.out.println("Этот скрипт вызовет рекурсию");
                        return true;
                    }
                    else {
                        scripts.add(file.getName());
                    }
                    while ((line!=null)||(!result)){

                        line = reader.readLine();
                        String coomand = line.split(" ")[0];
                        if (line.split(" ").length > 1) {
                            arg = line.split(" ")[1];
                        }
                        else if (line.split(" ").length == 1){
                            arg ="";
                        }

                        try {
                            if ((cm.getCommands().get(coomand.toUpperCase()) == null) | (coomand.equals(""))) {
                                throw  new NoSuchCommandException();
                            }
                        }catch (NoSuchCommandException e){
                            continue;}

                        System.out.println(line);
                        if (cm.getCommands().get(coomand.toUpperCase()).getName() == "INSERT"){
                            try {
                                if (arg.isEmpty()){
                                    throw new NumberFormatException();
                                }
                                else if (cm.getCollection().containsKey(Long.valueOf(arg))){
                                    throw new IllegalKeyException("уже есть квартира с таким номером");
                                }
                                cm.insert(Long.parseLong(arg),reader);
                                result = true;
                            }
                            catch (IllegalKeyException e){
                                System.out.println(e.getMessage());}
                            catch (NumberFormatException e){
                                System.out.println("String там где не надо");
                            }


                        }
                        else if (cm.getCommands().get(coomand.toUpperCase()).getName() == "UPDATEBYID"){
                            try {
                                long key = Long.parseLong(arg);
                                cm.update(key,reader);
                            }catch (NumberFormatException e){
                                System.out.println("String там где не надо");
                            }

                            result = true;
                        }
                        else if (cm.getCommands().get(coomand.toUpperCase()).getName() == "REMOVEGREATER"){
                            try {
                                if (!arg.isEmpty()){
                                    throw new NoSuchCommandException();
                                }
                                cm.removeGreater(reader);
                            }catch (NoSuchCommandException e){
                                System.out.println("String там где не надо");
                            }

                            result = true;
                        }
                        else if (cm.getCommands().get(coomand.toUpperCase()).getName() == "REMOVELOWER"){
                            try {
                                if (!arg.isEmpty()){
                                    throw new NoSuchCommandException();
                                }
                                cm.removeLower(reader);
                            }catch (NoSuchCommandException e){
                                System.out.println("String там где не надо");
                            }

                            result = true;
                        }
                        else {
                            result = cm.getCommands().get(coomand.toUpperCase()).execute(arg);}}
                    scripts.clear();
                    reader.close();

                    if (line==null){
                        return true;
                    }
                }

            } catch (IOException e) {
                result = true;
            } catch (NullPointerException ignored){
            } catch (IllegalValueException | IllegalKeyException e) {
                System.out.println(e.getMessage());
            }
        }
        return result;
    }

}

/* execute_script script1*/