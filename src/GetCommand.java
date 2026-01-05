import java.io.PrintStream;

public class GetCommand implements Command {

    @Override
    public void execute(DataStore store, String[] args, PrintStream out) {
        if (args.length < 2) {
            out.println(">> ERRO: Uso incorreto do comando GET. Uso: GET <chave>");
            return;
        }
        String key = args[1];
        String value = store.get(key);
        if (value != null) {
            out.println(">> COMANDO GET ACEITO: " + key + " -> " + value);
        } else {
            out.println(">> ERRO: Chave '" + key + "' nao encontrada.");
        }
    }
}
