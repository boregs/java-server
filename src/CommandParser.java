import java.util.HashMap;
import java.util.Map;

public class CommandParser {
    private static final Map<String, Command> command = new HashMap<>();

    static {
        command.put("SET", new SetCommand());
        command.put("GET", new GetCommand());
    }

    public static Command parser(String commandNamed){
        return command.getOrDefault(commandNamed.toUpperCase(), new UnknownCommand());
    }
}
