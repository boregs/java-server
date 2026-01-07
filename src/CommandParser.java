import java.util.HashMap;
import java.util.Map;

public class CommandParser {
    private static final Map<String, Command> command = new HashMap<>();

    // inicializa o mapa de comandos
    static {
        command.put("SET", new SetCommand());
        command.put("GET", new GetCommand());
    }

    // retorna o comando correspondente ao nome, ou UnknownCommand se nao existir
    public static Command parser(String commandNamed){
        return command.getOrDefault(commandNamed.toUpperCase(), new UnknownCommand());
    }
}
