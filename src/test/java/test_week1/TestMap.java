package test_week1;

import week1.data_structure.tree.MTreeMap;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {

        Map map = new MTreeMap();

        map.put(1, "Oleg");

        boolean result = map.size() == 1;

        System.out.printf("%s operation = map.put", result);

    }
}
