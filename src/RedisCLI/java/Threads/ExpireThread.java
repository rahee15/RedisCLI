package RedisCLI.java.Threads;

import java.util.HashMap;

public class ExpireThread implements Runnable {

    private String key;
    private Long milliseconds;
    private HashMap<String,String> map;

    public ExpireThread(String key, Long milliseconds, HashMap<String, String> map) {
        this.key = key;
        this.milliseconds = milliseconds;
        this.map = map;
    }

    public void run()
    {
        try
        {
            Thread.sleep(milliseconds);
            map.remove(key);

        }
        catch (Exception e)
        {
            // Throwing an exception
            System.out.println ("Exception is caught");
        }
    }
}
