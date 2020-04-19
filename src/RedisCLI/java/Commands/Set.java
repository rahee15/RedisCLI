package RedisCLI.java.Commands;

import RedisCLI.java.Threads.ExpireThread;

import java.util.HashMap;

public class Set {
    private static boolean validateInput(String[] input) {
        if (input.length != 3 && ( input.length != 5  ))  {
            System.out.println("(error) ERR wrong number of arguments for 'set' command");
            return false;
        }
        return true;
    }

    public static void execute(String[] input, HashMap<String, String> map) {
        if (!validateInput(input)) {
            return;
        } else {
            String key = input[1];
            String value = input[2];
            if (map.containsKey(key)) {
                map.replace(key, value);
            } else {
                map.put(key, value);
            }
            if(input.length == 5)
            {
                if(input[3].equals("EX"))
                {
                    Thread thread = new Thread(new ExpireThread(key, Long.parseLong(input[4]), map));
                    thread.start();
                }

            }
            System.out.println("OK");
            return;
        }
    }
}
