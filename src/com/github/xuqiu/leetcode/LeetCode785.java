package com.github.xuqiu.leetcode;

import java.util.BitSet;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-04-29 10:11
 */
public class LeetCode785 {
    public boolean isBipartite(int[][] graph) {
        List<Integer> unHandledSet = new LinkedList<>();
        List<Integer> toHandledSet;
        BitSet leftSet = new BitSet();
        BitSet rightSet = new BitSet();
        leftSet.set(0);
        for (int i : graph[0]) {
            rightSet.set(i);
        }
        for (int i = 1; i < graph.length; i++) {
            if(!leftSet.get(i) && !rightSet.get(i)){
                unHandledSet.add(i);
                continue;
            }
            if (leftSet.get(i)) {
                for (int j : graph[i]) {
                    if (leftSet.get(j)) {
                        return false;
                    }
                    rightSet.set(j);
                }
            }else if (rightSet.get(i)){
                for (int j : graph[i]) {
                    if (rightSet.get(j)) {
                        return false;
                    }
                    leftSet.set(j);
                }
            }
        }
        //
        int unHandledSize = 0;
        for (int loop = 0; loop < graph.length && !unHandledSet.isEmpty(); loop++) {
            if(unHandledSize == unHandledSet.size()){
                final Integer oneInUnHanded = unHandledSet.iterator().next();
                leftSet.set(oneInUnHanded);
                for (int i : graph[oneInUnHanded]) {
                    rightSet.set(i);
                }
                unHandledSet.remove(oneInUnHanded);
            }
            unHandledSize = unHandledSet.size();

            toHandledSet = new LinkedList<>(unHandledSet);
            unHandledSet = new LinkedList<>();
            for (Integer i : toHandledSet) {
                if(!leftSet.get(i) && !rightSet.get(i)){
                    unHandledSet.add(i);
                    continue;
                }
                if (leftSet.get(i)) {
                    for (int j : graph[i]) {
                        if (leftSet.get(j)) {
                            return false;
                        }
                        rightSet.set(j);
                    }
                }else if (rightSet.get(i)){
                    for (int j : graph[i]) {
                        if (rightSet.get(j)) {
                            return false;
                        }
                        leftSet.set(j);
                    }
                }
            }
        }
        return unHandledSet.isEmpty();
    }

}
