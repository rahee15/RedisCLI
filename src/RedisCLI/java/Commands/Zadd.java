package RedisCLI.java.Commands;

import RedisCLI.java.Entity.ZsetComparator;
import RedisCLI.java.Entity.ZsetEntity;

import java.util.*;
import java.util.regex.Pattern;

public class Zadd {
    static int binarySearch(Object[] arr, int l, int r, String x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the middle
            // itself
            if (((ZsetEntity)(arr[mid])).getKey().equals(x))
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if ( ((ZsetEntity)arr[mid]).getKey().compareTo(x) > 0)
                return binarySearch(arr, l, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid + 1, r, x);
        }

        // We reach here when element is not
        // present in array
        return -1;
    }

    private static boolean validateInput(String[] input)
    {
        if(input.length < 4)
        {
            System.out.println("(error) ERR wrong number of arguments for 'zadd' command");
            return false;
        }
        else
        {
            //Checking is value is numric or not
            Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
            for(int i=2;i<input.length;i=i+2)
            {
                if(!pattern.matcher(input[i]).matches())
                {
                    System.out.println("(error) ERR value is not a valid float");
                    return false;
                }
            }
        }
        return true;
    }

    public static void execute(String[] input, HashMap<String, SortedSet<ZsetEntity>> map)
    {
        if(!validateInput(input))
        {
            return;
        }
        else
        {
            String zkey = input[1];
            if(!map.containsKey(zkey))
            {
                SortedSet<ZsetEntity> sm =
                        new TreeSet<>(new ZsetComparator());
                map.put(zkey,sm);
            }
                SortedSet<ZsetEntity> sortedSet = map.get(zkey);
                int count_exec=0;
                for (int i = 2; i < input.length - 1; i = i + 2)
                {
                    Integer value = Integer.parseInt(input[i]);
                    String key = input[i+1];
                    Integer index = binarySearch(sortedSet.toArray(),0,sortedSet.size()-1,key);
                    if (index == -1)
                    {
                        ZsetEntity entity = new ZsetEntity(key,value);
                        sortedSet.add(entity);
                        count_exec++;
                    }

                }
             System.out.println("(integer) "+(count_exec));

            return;
        }
    }
}
