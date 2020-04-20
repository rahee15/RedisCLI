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
                Object[] sortedSetArray =  (sortedSet.toArray());
                for(int i=0;i<sortedSetArray.length;i++)
                {
                    if(((ZsetEntity)(sortedSetArray[i])).getKey().equals(key))
                    {
                        System.out.println("(integer) " + i);
                        return;
                    }
                }
                System.out.println("(nil)");
            } else {
                System.out.println("(nil)");
            }
            return;

        }
    }
}
