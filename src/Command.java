import java.io.PrintStream;

public interface Command {
    void execute(DataStore store, PrintStream out);
}
