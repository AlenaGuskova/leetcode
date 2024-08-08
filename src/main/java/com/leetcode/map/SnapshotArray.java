package com.leetcode.map;

import java.util.HashMap;
import java.util.Map;

class SnapshotArray {

    private final Map<Integer, Map<Integer, Integer>> map;
    private int currentSnapshot;

    public SnapshotArray(int length) {
        map = new HashMap<>((int) (length / 0.75));
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        SnapshotArray snapshotArray = new SnapshotArray(3);
        snapshotArray.set(0, 5);
        System.out.println(0 == snapshotArray.snap());  // snap_id = 0
        snapshotArray.set(0, 6);
        System.out.println(5 == snapshotArray.get(0, 0));
        System.out.println(6 == snapshotArray.get(0, 1));

        SnapshotArray snapshotArray2 = new SnapshotArray(1);
        snapshotArray2.set(0, 4);
        snapshotArray2.set(0, 16);
        snapshotArray2.set(0, 13);
        System.out.println(0 == snapshotArray2.snap());  // snap_id = 0
        System.out.println(13 == snapshotArray2.get(0, 0)); // 13
        System.out.println(1 == snapshotArray2.snap());  // snap_id = 1

        SnapshotArray snapshotArray3 = new SnapshotArray(4);
        System.out.println(0 == snapshotArray3.snap());  // snap_id = 0
        System.out.println(1 == snapshotArray3.snap());  // snap_id = 1
        System.out.println(0 == snapshotArray3.get(3, 1));
        snapshotArray3.set(2, 4);
        System.out.println(2 == snapshotArray3.snap());  // snap_id = 2
        snapshotArray3.set(1, 4);

        SnapshotArray snapshotArray4 = new SnapshotArray(1);
        snapshotArray4.set(0, 15);
        System.out.println(0 == snapshotArray4.snap());  // snap_id = 0
        System.out.println(1 == snapshotArray4.snap());  // snap_id = 1
        System.out.println(2 == snapshotArray4.snap());  // snap_id = 2
        System.out.println(15 == snapshotArray4.get(0, 2)); // 15
        System.out.println(3 == snapshotArray4.snap());  // snap_id = 3
        System.out.println(4 == snapshotArray4.snap());  // snap_id = 4
        System.out.println(15 == snapshotArray4.get(0, 0)); // 15

        SnapshotArray snapshotArray5 = new SnapshotArray(3);
        snapshotArray5.set(0, 1);
        snapshotArray5.set(2, 17);
        snapshotArray5.set(0, 19);
        System.out.println(0 == snapshotArray5.snap());
        System.out.println(1 == snapshotArray5.snap());
        System.out.println(19 == snapshotArray5.get(0, 0));
        System.out.println(2 == snapshotArray5.snap());
        System.out.println(0 == snapshotArray5.get(1, 2));
        System.out.println(17 == snapshotArray5.get(2, 0));

        System.out.println(System.currentTimeMillis() - start + " ms");
    }

    public void set(int index, int val) {
        map.computeIfAbsent(currentSnapshot, integer -> new HashMap<>())
                .put(index, val);
    }

    public int snap() {
        return currentSnapshot++;
    }

    public int get(int index, int snap_id) {
        int result = 0;
        for (int i = snap_id; i >= 0; i--) {
            var getSnapMap = map.getOrDefault(i, new HashMap<>());
            if (getSnapMap.get(index) != null) {
                result = getSnapMap.get(index);
                break;
            }
        }
        return result;
    }
}
