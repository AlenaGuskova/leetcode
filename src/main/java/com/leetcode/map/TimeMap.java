package com.leetcode.map;

import java.util.HashMap;
import java.util.TreeMap;

class TimeMap {

    private final HashMap<String, TreeMap<Integer, String>> keysToTimeWithValues;

    public TimeMap() {
        keysToTimeWithValues = new HashMap<>();
    }

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
        System.out.println("bar".equals(timeMap.get("foo", 1)));         // return "bar"
        System.out.println("bar".equals(timeMap.get("foo", 3)));         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
        timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
        System.out.println("bar2".equals(timeMap.get("foo", 4)));         // return "bar2"
        System.out.println("bar2".equals(timeMap.get("foo", 5)));         // return "bar2"
        System.out.println("".equals(timeMap.get("foo1", 5)));         // return "null"

        TimeMap timeMap2 = new TimeMap();
        timeMap2.set("love", "high", 10);
        timeMap2.set("love", "low", 20);
        System.out.println("".equals(timeMap2.get("love", 5)));  //
        System.out.println("high".equals(timeMap2.get("love", 10))); // high
        System.out.println("high".equals(timeMap2.get("love", 15))); // high
        System.out.println("low".equals(timeMap2.get("love", 20))); // low
        System.out.println("low".equals(timeMap2.get("love", 25))); // low

        TimeMap timeMap3 = new TimeMap();
        timeMap3.set("a", "bar", 1);
        timeMap3.set("x", "b", 3);
        System.out.println("".equals(timeMap3.get("b", 3)));
        timeMap3.set("foo", "bar2", 4);
        System.out.println("bar2".equals(timeMap3.get("foo", 4)));
        System.out.println("bar2".equals(timeMap3.get("foo", 5)));

        System.out.println(System.currentTimeMillis() - start + " ms");
    }

    public void set(String key, String value, int timestamp) {
        var valuesOrDefault = keysToTimeWithValues.getOrDefault(key, new TreeMap<>());
        valuesOrDefault.put(timestamp, value);
        keysToTimeWithValues.put(key, valuesOrDefault);
    }

    public String get(String key, int timestamp) {
        var valuesOrDefault = keysToTimeWithValues.getOrDefault(key, new TreeMap<>());
        return valuesOrDefault.getOrDefault(timestamp, getDefault(valuesOrDefault, timestamp));
    }

    private String getDefault(TreeMap<Integer, String> map, int timestamp) {
        Integer search = map.floorKey(timestamp);
        return search == null ? "" : map.get(search);
    }
}