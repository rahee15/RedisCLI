package RedisCLI.java.Commands;

import RedisCLI.java.Entity.ZsetEntity;

import java.util.HashMap;
import java.util.SortedSet;

public class Zrange {
    private static boolean validateInput(String[] input) {
        if (input.length != 4 && input.length != 5) {
            System.out.println("(error) ERR wrong number of arguments for 'zrange' command");
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
                int SET_SIZE = sortedSet.size();
                int ind_start = Integer.parseInt(input[2]), ind_end = Integer.parseInt(input[3]);
                if (ind_start < 0)
                    ind_start += SET_SIZE;
                if (ind_end < 0)
                    ind_end += (SET_SIZE);
                if (ind_end > SET_SIZE - 1)
                    ind_end = SET_SIZE - 1;
                if (ind_start < 0)
                    ind_start = 0;
                if (ind_start > ind_end) {
                    System.out.println("(nil)");
                    return;
                }

                Object[] sortedSetArray =  (sortedSet.toArray());
                if (input.length == 5) {
                    int j = 1;
                    for (int i = ind_start; i <= ind_end; i++) {
                        System.out.println(j + ")" + ((ZsetEntity) (sortedSetArray)[i]).getKey());
                        j++;
                        System.out.println(j + ")" + ((ZsetEntity) (sortedSetArray)[i]).getValue());
                        j++;
                    }
                } else {
                    for (int i = ind_start; i <= ind_end; i++) {
                        System.out.println(i + 1 + ")" + ((ZsetEntity) (sortedSetArray)[i]).getKey());

                    }
                }


            } else {
                System.out.println("(nil)");
            }
            return;

        }
    }
}
