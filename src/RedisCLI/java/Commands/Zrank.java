package RedisCLI.java.Commands;

import RedisCLI.java.Entity.ZsetEntity;
import RedisCLI.java.Util.Util;

import java.util.HashMap;
import java.util.SortedSet;

public class Zrank {

    private static boolean validateInput(String[] input) {
        if (input.length != 3) {
            System.out.println("(error) ERR wrong number of arguments for 'zrank' command");
            return false;
        }
        return true;
    }

    public static void execute(String[] input, HashMap<String, SortedSet<ZsetEntity>> map) {
        if (!validateInput(input)) {
            return;
        } else {
            String zkey = input[1];
            if (map.containsKey(zkey)) {
                SortedSet<ZsetEntity> sortedSet = map.get(zkey);
                String key = input[2];
                Integer index = Util.binarySearch(sortedSet.toArray(), 0, sortedSet.size() - 1, key);
                if (index != -1)
                    System.out.println("(integer) " + index);
                else
                    System.out.println("(nil)");
            } else {
                System.out.println("(nil)");
            }
            return;

        }
    }
}
