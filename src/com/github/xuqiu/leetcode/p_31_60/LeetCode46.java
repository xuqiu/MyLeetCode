package com.github.xuqiu.leetcode.p_31_60;

import org.junit.Test;

import java.util.*;

/**
 * 还是忍不住纠结了一下, 实现了一个IntArrayList, 优化到了2ms, 内存也是beats了90+
 */
public class LeetCode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length<=1){
            return List.of(new IntArrayList(nums));
        }
        for (int i = 0; i < nums.length; i++) {
            IntArrayList numList = new IntArrayList(nums);
            if (i>0) {
                Collections.swap(numList, 0, i);
            }
            result.addAll(permute(numList, 1));
        }
        return result;
    }
    private List<List<Integer>> permute(IntArrayList numList, int from) {
        IntArrayList copiedList = new IntArrayList(numList.value);
        if (from == numList.size()-1) {
            return Collections.singletonList(copiedList);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = from; i < copiedList.size(); i++) {
            if (i>from) {
                Collections.swap(copiedList, from, i);
            }
            List<List<Integer>> permute = permute(copiedList, from+1);
            result.addAll(permute);
        }
        return result;
    }

    class IntArrayList implements List<Integer>{
        protected int[] value;
        int size;

        public IntArrayList(int[] value) {
            this.value = Arrays.copyOf(value,value.length);
            this.size = value.length;
        }

        public String toString() {
            return Arrays.toString(value);
        }

        @Override
        public int size() {
            return value.length;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Integer> iterator() {
            return new Iterator<>() {
                int cursor;
                @Override
                public boolean hasNext() {
                    return cursor < size;
                }

                @Override
                public Integer next() {
                    return value[cursor++];
                }
            };
        }

        @Override
        public Object[] toArray() {
            return Arrays.stream(value).boxed().toArray();
        }

        @Override
        public <T> T[] toArray(T[] a) {
            throw new UnsupportedOperationException("not supported");
        }

        @Override
        public boolean add(Integer integer) {
            throw new UnsupportedOperationException("not supported");
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Integer> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Integer> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {
            throw new UnsupportedOperationException("not supported");
        }

        @Override
        public Integer get(int index) {
            return value[index];
        }

        @Override
        public Integer set(int index, Integer element) {
            Objects.checkIndex(index, size);
            Integer oldValue = value[index];
            value[index] = element;
            return oldValue;
        }

        @Override
        public void add(int index, Integer element) {
            throw new UnsupportedOperationException("not supported");
        }

        @Override
        public Integer remove(int index) {
            throw new UnsupportedOperationException("not supported");
        }

        @Override
        public int indexOf(Object o) {
            throw new UnsupportedOperationException("not supported");
        }

        @Override
        public int lastIndexOf(Object o) {
            throw new UnsupportedOperationException("not supported");
        }

        @Override
        public ListIterator<Integer> listIterator() {
            throw new UnsupportedOperationException("not supported");
        }

        @Override
        public ListIterator<Integer> listIterator(int index) {
            throw new UnsupportedOperationException("not supported");
        }

        @Override
        public List<Integer> subList(int fromIndex, int toIndex) {
            throw new UnsupportedOperationException("not supported");
        }
    }
    @Test
    public void test() {
        System.out.println(permute(new int[]{1}));
        System.out.println();
        System.out.println(permute(new int[]{1,2}));
        System.out.println();
        System.out.println(permute(new int[]{1,2,3}));
        System.out.println();
        System.out.println(permute(new int[]{1,2,3,4}));
        System.out.println();
        System.out.println(permute(new int[]{1,2,3,4,5}));
    }
}
