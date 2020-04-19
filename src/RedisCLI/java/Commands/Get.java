package RedisCLI.java.Commands;

import java.util.HashMap;

public class Get {

    private static boolean validateInput(String[] input) {
        if (input.length != 2) {
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
            if (map.containsKey(key)) {
                System.out.println('"' + map.get(key) + '"');
            } else {
                System.out.println("(nil)");
                return;
            }
            return;
        }
    }
}