Here is a Java console application that implements a data structure supporting insert, delete, search, and getRandom operations in constant time. This is achieved by using a combination of ArrayList and HashMap.

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        CustomDataStructure ds = new CustomDataStructure();
        ds.insert(10);
        ds.insert(20);
        ds.insert(30);
        ds.insert(40);
        System.out.println(ds.search(30));
        ds.delete(20);
        System.out.println(ds.getRandom());
    }
}

class CustomDataStructure {
    ArrayList<Integer> arr;
    HashMap<Integer, Integer> hash;

    public CustomDataStructure() {
        arr = new ArrayList<Integer>();
        hash = new HashMap<Integer, Integer>();
    }

    void insert(int x) {
        if (hash.get(x) != null)
            return;
        int s = arr.size();
        arr.add(x);
        hash.put(x, s);
    }

    void delete(int x) {
        Integer index = hash.get(x);
        if (index == null)
            return;
        hash.remove(x);
        int size = arr.size();
        Integer last = arr.get(size - 1);
        Collections.swap(arr, index,  size - 1);
        arr.remove(size - 1);
        hash.put(last, index);
    }

    boolean search(int x) {
        return hash.containsKey(x);
    }

    int getRandom() {
        Random rand = new Random();
        int index = rand.nextInt(arr.size());
        return arr.get(index);
    }
}
```

In this code, the `CustomDataStructure` class uses an `ArrayList` and a `HashMap` to support the required operations. The `ArrayList` is used to support `getRandom` in O(1) time, and the `HashMap` is used to support `insert`, `delete`, and `search` in O(1) time. The `insert` method adds an element to the end of the `ArrayList` and updates the `HashMap` with the element's value and its index in the `ArrayList`. The `delete` method removes an element from the `HashMap` and replaces its position in the `ArrayList` with the last element in the `ArrayList`. The `search` method checks if an element is in the `HashMap`. The `getRandom` method generates a random index and returns the element at that index in the `ArrayList`.