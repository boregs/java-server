import java.io.PrintStream;

public interface Command {
    void execute(DataStore store, String[] args, PrintStream out);
}
