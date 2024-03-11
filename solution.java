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