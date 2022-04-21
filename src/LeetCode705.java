
import org.junit.Test;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-04-21 21:52
 */
public class LeetCode705 {

    public class MyHashSet {
        java.util.BitSet bitSet = new java.util.BitSet(1000000);
        public MyHashSet() {
        }

        public void add(int key) {
            bitSet.set(key);
        }

        public void remove(int key) {
            bitSet.clear(key);
        }

        public boolean contains(int key) {
            return bitSet.get(key);
        }
    }
    @Test
    public void test(){
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(1)); // return True
        System.out.println(myHashSet.contains(3)); // return False, (not found)
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(2)); // return True
        myHashSet.remove(2);   // set = [1]
        System.out.println(myHashSet.contains(2)); // return False, (already removed)
    }

}
