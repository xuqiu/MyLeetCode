package com.github.xuqiu.leetcode.p_31_60;

import org.junit.Test;

import java.util.*;

/**
 * 2ms beats 81.22%, 44.44MB beats 93.63%
 */
public class LeetCode47 {
    int size;
    public List<List<Integer>> permuteUnique(int[] nums) {
        size = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (size<=1){
            return List.of(new IntArrayList(nums));
        }
        BitSet bitSet = new BitSet(21);
        for (int i = 0; i < size; i++) {
            if (bitSet.get(nums[i]+10)) continue;
            bitSet.set(nums[i]+10, true);
            IntArrayList numList = new IntArrayList(nums);
            if (i>0) {
                numList.swap(0, i);
            }

            result.addAll(permuteUnique(numList, 1));
        }
        return result;
    }
    private List<List<Integer>> permuteUnique(IntArrayList numList, int from) {
        IntArrayList copiedList = new IntArrayList(numList.value);
        if (from == size-1) {
            return Collections.singletonList(copiedList);
        }
        if (from == size-2) {
            if (copiedList.get(size - 1).equals(copiedList.get(size - 2))) {
                return List.of(
                        copiedList
                );
            }
            IntArrayList integers = new IntArrayList(copiedList.value);
            integers.swap(size - 1, size - 2);
            return List.of(
                    copiedList,integers
            );
        }
        List<List<Integer>> result = new ArrayList<>();
        BitSet bitSet = new BitSet(21);
        for (int i = from; i < size; i++) {
            if (bitSet.get(copiedList.get(i)+10)) continue;
            bitSet.set(copiedList.get(i)+10, true);
            if (i>from) {
                copiedList.swap(from, i);
            }
            List<List<Integer>> permute = permuteUnique(copiedList, from+1);
            result.addAll(permute);
        }
        return result;
    }

    class IntArrayList implements List<Integer>{
        protected int[] value;

        public IntArrayList(int[] value) {
            this.value = Arrays.copyOf(value,size);
        }

        public String toString() {
            return Arrays.toString(value);
        }

        @Override
        public int size() {
            return size;
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
            int oldValue = value[index];
            value[index] = element;
            return oldValue;
        }

        /**
         * @return value[i] == value[j]
         */
        public void swap(int i, int j) {
            int temp = value[i];
            value[i] = value[j];
            value[j] = temp;
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
        System.out.println(permuteUnique(new int[]{1}));
        System.out.println();
        System.out.println(permuteUnique(new int[]{1,1}));
        System.out.println();
        System.out.println(permuteUnique(new int[]{1,1,2}));
        System.out.println();
        System.out.println(permuteUnique(new int[]{1,1,2,2}));
        System.out.println();
        System.out.println(permuteUnique(new int[]{1,2,3}));
        System.out.println();
        System.out.println(permuteUnique(new int[]{1,1,1,4}));
        System.out.println();
        System.out.println(permuteUnique(new int[]{1,1,2,2,5}));
    }
}
