package RedisCLI.java.Commands;

import RedisCLI.java.Entity.ZsetEntity;

import java.lang.reflect.Array;
import java.util.*;

public class Zrange {
    private static boolean validateInput(String[] input)
    {
        if(input.length != 4 && input.length != 5)
        {
            System.out.println("(error) ERR wrong number of arguments for 'zrange' command");
            return false;
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
            if(map.containsKey(zkey))
            {
                SortedSet<ZsetEntity> sortedSet = map.get(zkey);

                int ind_start=Integer.parseInt(input[2]),ind_end=Integer.parseInt(input[3]);
                if(ind_start<0)
                    ind_start+=sortedSet.size();
                if(ind_end<0)
                    ind_end+=(sortedSet.size());
                if(ind_end>sortedSet.size()-1)
                    ind_end = sortedSet.size()-1;
                if(ind_start < 0)
                    ind_start = 0;
                if(ind_start>ind_end)
                {
                    System.out.println("(nil)");
                    return;
                }


                    for(int i=ind_start;i<=ind_end;i++)
                    {
                        System.out.println(((ZsetEntity)(sortedSet.toArray())[i]).getKey());

                    }


            }
            else
            {
                System.out.println("(nil)");
            }
            return;

        }
    }
}
