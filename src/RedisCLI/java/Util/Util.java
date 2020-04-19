package RedisCLI.java.Util;

import RedisCLI.java.Entity.ZsetEntity;

public class Util{
    public static int binarySearch(Object[] arr, int l, int r, String x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the middle
            // itself
            if (((ZsetEntity) (arr[mid])).getKey().equals(x))
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (((ZsetEntity) arr[mid]).getKey().compareTo(x) > 0)
                return binarySearch(arr, l, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid + 1, r, x);
        }

        // We reach here when element is not
        // present in array
        return -1;
    }

}

