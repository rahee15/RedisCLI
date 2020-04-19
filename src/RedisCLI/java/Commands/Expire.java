package RedisCLI.java.Commands;

import RedisCLI.java.Threads.ExpireThread;

import java.util.HashMap;

public class Expire {

    private static boolean validateInput(String[] input) {
        if (input.length != 3) {
            System.out.println("(error) ERR wrong number of arguments for 'get' command");
            return false;
        }
        return true;
    }

    public static void execute(String[] input, HashMap<String, String> map) {
        if (!validateInput(input)) {
            return;
        } else {
            String key = input[1];
            Long miliSeconds = Long.parseLong(input[2]);
            if (map.containsKey(key)) {
                Thread thread = new Thread(new ExpireThread(key, miliSeconds, map));
                thread.start();
                System.out.println("(integer) 1");
            } else {
                System.out.println("(integer) 0");
                return;
            }
            return;
        }
    }
}
