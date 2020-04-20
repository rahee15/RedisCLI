package RedisCLI.java.Entity;

import java.util.Comparator;

public class ZsetComparator implements Comparator<ZsetEntity> {
    @Override
    public int compare(ZsetEntity zsetEntity1, ZsetEntity zsetEntity2) {

        return zsetEntity1.getValue() - (zsetEntity2.getValue());
    }
}
