package RedisCLI.java.Commands;

import java.util.HashMap;

public class Set {
    private static boolean validateInput(String[] input)
    {
        if(input.length != 3)
        {
            System.out.println("(error) ERR wrong number of arguments for 'set' command");
            return false;
        }
        return true;
    }

    public static void execute(String[] input, HashMap<String,String> map)
    {
        if(!validateInput(input))
        {
            return;
        }
        else
        {
            String key = input[1];
            String value = input[2];
            if(map.containsKey(key))
            {
                map.replace(key,value);
            }
            else
            {
                map.put(key,value);
            }
            System.out.println("OK");
            return;
        }
    }
}
