import java.io.PrintStream;

public class SetCommand implements Command{
    @Override
    public void execute(DataStore store, String[] args, PrintStream out){
        if (args.length < 3) {
            out.println(">> ERRO: Uso incorreto do comando SET. Uso: SET <chave> <valor>");
            return;
        }

        String key = args[1];
        String value = args[2];

        store.put(key, value);
        out.println(">> COMANDO SET ACEITO: " + key + " -> " + value);
    }
}
