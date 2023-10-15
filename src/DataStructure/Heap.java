package DataStructure;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Heap {
    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        maxHeap.add(2);
        maxHeap.add(4);
        maxHeap.add(1);
        maxHeap.add(8);

        Iterator iterator = maxHeap.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        };
    }
}
