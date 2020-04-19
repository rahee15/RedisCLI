package RedisCLI.java.Threads;

import java.util.HashMap;

public class ExpireThread implements Runnable {

    private final String key;
    private final Long milliseconds;
    private final HashMap<String, String> map;

    public ExpireThread(String key, Long milliseconds, HashMap<String, String> map) {
        this.key = key;
        this.milliseconds = milliseconds;
        this.map = map;
    }

    public void run() {
        try {
            Thread.sleep(milliseconds);
            if(map.containsKey(key))
                map.remove(key);

        } catch (RuntimeException e) {
            System.out.println("RuntimeException from thread");
        } catch (InterruptedException e) {
            System.out.println("InterruptedException from thread");
        }
    }
}
