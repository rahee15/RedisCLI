package RedisCLI.java;

import RedisCLI.java.Commands.*;
import RedisCLI.java.Entity.ZsetEntity;
import RedisCLI.java.ParseInput.ParseInput;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import java.util.SortedSet;


public class RedisCLI {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, SortedSet<ZsetEntity>> zSet = new HashMap<>();
        try {
            map = mapper.readValue(new File(
                    "map.json"), new TypeReference<HashMap<String, String>>() {
            });
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            zSet = mapper.readValue(new File(
                    "zMap.json"), new TypeReference<HashMap<String, SortedSet<ZsetEntity>>>() {
            });
        } catch (Exception e) {
            System.out.println(e);
        }

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("host:port->");
            String input = sc.nextLine();
            String[] inputArray = ParseInput.parseInputData(input);
            switch (inputArray[0]) {
                case "GET":
                    Get.execute(inputArray, map);
                    break;
                case "SET":
                    Set.execute(inputArray, map);
                    break;
                case "EXPIRE":
                    Expire.execute(inputArray, map);
                    break;
                case "ZADD":
                    Zadd.execute(inputArray,map,zSet);
                    break;
                case "ZRANK":
                    Zrank.execute(inputArray, zSet);
                    break;
                case "ZRANGE":
                    Zrange.execute(inputArray, zSet);
                    break;
                case "EXIT":
                    Exit.execute(inputArray, map, zSet);
                    System.exit(0);
                    break;
                default:
                    System.out.println("(error) ERR unknown command " + inputArray[0]);
            }


        }
    }
}
