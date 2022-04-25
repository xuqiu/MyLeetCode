import java.util.Iterator;
import java.util.List;

import org.junit.Test;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-04-25 10:09
 */
public class LeetCode284 {
    public class PeekingIterator implements Iterator<Integer> {
        int[] values = new int[1000];
        int pointer = 0;
        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            final int[] i = { 0 };
            iterator.forEachRemaining(integer -> {
                values[i[0]++]=integer;
            });
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return values[pointer];
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            return values[pointer++];
        }

        @Override
        public boolean hasNext() {
            return pointer<=1000&&values[pointer]>0;
        }
    }
    @Test
    public void test(){
        final PeekingIterator peekingIterator = new PeekingIterator(List.of(1, 2, 3).iterator());
        System.out.println(peekingIterator.next());    // return 1, the pointer moves to the next element [1,2,3].
        System.out.println(peekingIterator.peek());    // return 2, the pointer does not move [1,2,3].
        System.out.println(peekingIterator.next());    // return 2, the pointer moves to the next element [1,2,3]
        System.out.println(peekingIterator.next());    // return 3, the pointer moves to the next element [1,2,3]
        System.out.println(peekingIterator.hasNext()); // return False
    }
}
