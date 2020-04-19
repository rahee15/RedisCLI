package RedisCLI.java.Entity;

import java.util.Comparator;

public class ZsetComparator implements Comparator<ZsetEntity> {
    @Override
    public int compare(ZsetEntity zsetEntity1, ZsetEntity zsetEntity2) {
        String first = zsetEntity1.getKey();
        String second = zsetEntity2.getKey();
        return first.compareTo(second);
    }
}
