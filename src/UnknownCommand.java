import java.io.PrintStream;

public class UnknownCommand implements Command{

    @Override
    public void execute(DataStore store, String[] args, PrintStream out) {
        out.println(">> ERRO: Comando desconhecido.");
    }
}
