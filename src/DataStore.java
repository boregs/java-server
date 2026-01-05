import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.Lock;

public class DataStore {
    private final Map<String, String> storage = new HashMap<>(); // hashmap para guardar os usuarios conectados

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    // METODO PARA COLOCAR ITENS NO MAPA DE FORMA THREAD-SAFE
    public void put(String key, String value){
        writeLock.lock();
        try {
            storage.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    // METODO PARA PEGAR ITENS DO MAPA DE FORMA THREAD-SAFE
    public String get(String key){
        readLock.lock();
        try {
            return storage.get(key);
        } finally {
            readLock.unlock();
        }
    }

    //METODO PARA VERIFICAR O TAMANHO DO MAPA
    public int size() {
        readLock.lock();
        try {
            return storage.size();
        } finally {
            readLock.unlock();
        }
    }
}
