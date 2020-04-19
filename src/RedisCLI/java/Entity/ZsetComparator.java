package RedisCLI.java.Entity;

import java.util.Comparator;

public class ZsetComparator implements Comparator<ZsetEntity> {
    @Override
    public int compare(ZsetEntity zsetEntity, ZsetEntity t1) {
        String first = zsetEntity.key;
        String second = t1.key;
        return first.compareTo(second);
    }
}
