package RedisCLI.java.Commands;

import RedisCLI.java.Entity.ZsetComparator;
import RedisCLI.java.Entity.ZsetEntity;
import RedisCLI.java.Util.Util;

import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class Zadd {

    private static boolean validateInput(String[] input) {
        if (input.length < 4) {
            System.out.println("(error) ERR wrong number of arguments for 'zadd' command");
            return false;
        } else {
            //Checking is value is numric or not
            Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
            for (int i = 2; i < input.length; i = i + 2) {
                if (!pattern.matcher(input[i]).matches()) {
                    System.out.println("(error) ERR value is not a valid float");
                    return false;
                }
            }
        }
        return true;
    }

    public static void execute(String[] input, HashMap<String, String> simple_map,HashMap<String, SortedSet<ZsetEntity>> map) {
        if (!validateInput(input)) {
            return;
        } else {
            String zkey = input[1];
            if(simple_map.containsKey(zkey))
            {
                System.out.println("(error) WRONGTYPE Operation against a key holding the wrong kind of value");
                return;
            }
            if (!map.containsKey(zkey)) {
                SortedSet<ZsetEntity> sm =
                        new TreeSet<>(new ZsetComparator());
                map.put(zkey, sm);
            }
            SortedSet<ZsetEntity> sortedSet = map.get(zkey);
            int count_exec = 0;
            for (int i = 2; i < input.length - 1; i = i + 2) {
                Integer value = Integer.parseInt(input[i]);
                String key = input[i + 1];

                    ZsetEntity entity = new ZsetEntity(key, value);
                    sortedSet.add(entity);
                    count_exec++;


            }
            System.out.println("(integer) " + (count_exec));

            return;
        }
    }
}
