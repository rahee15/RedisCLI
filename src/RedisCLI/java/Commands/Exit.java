package RedisCLI.java.Commands;

import RedisCLI.java.Entity.ZsetEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.SortedSet;

public class Exit {
    private static boolean validateInput(String[] input) {
        if (input.length != 1) {
            System.out.println("(error) ERR wrong number of arguments for 'exit' command");
            return false;
        }
        return true;
    }

    public static void execute(String[] input, HashMap<String, String> map, HashMap<String, SortedSet<ZsetEntity>> zMap) {
        if (!validateInput(input)) {
            return;
        } else {
            try {

                // Open the file.
                PrintWriter out = new PrintWriter("map.json"); // Step 2
                out.close();
                out = new PrintWriter("zMap.json"); // Step 2
                out.close();
                ObjectMapper mapper = new ObjectMapper();
                try {
                    mapper.writeValue(new File("map.json"), map);
                } catch (Exception e) {
                    System.out.println("Something went wrong! unable to persist data of map ");
                }
                try {
                    mapper.writeValue(new File("zMap.json"), zMap);
                } catch (Exception e) {
                    System.out.println("Something went wrong! unable to persist data of sortedSet ");                }

            } catch (Exception e) {
                System.out.println(e);
            }

            return;
        }
    }
}
