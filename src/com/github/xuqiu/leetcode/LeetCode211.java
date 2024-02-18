package com.github.xuqiu.leetcode;

import org.junit.Test;

public class LeetCode211 {

    @Test
    public void test() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
    }

    private class TrieNode {
        private TrieNode[] children = new TrieNode[26];
        private boolean isWord;

        public TrieNode() {
        }

        public TrieNode(boolean isWord) {
            this.isWord = isWord;
        }

        public TrieNode[] getChildren() {
            return children;
        }

        public boolean isWord() {
            return isWord;
        }

        public void setIsWord(boolean isWord) {
            this.isWord = isWord;
        }

        public void setChildren(TrieNode[] children) {
            this.children = children;
        }

        public void addChild(TrieNode child) {
            for (int i = 0; i < children.length; i++) {
                if (children[i] == null) {
                    children[i] = child;
                    return;
                }
            }
        }

    }

    private class WordDictionary {
        private final TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            root = new TrieNode();
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isWord = true;
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            return search(word, 0, root);
        }

        private boolean search(String word, int index, TrieNode node) {
            if (index == word.length()) {
                return node.isWord;
            }
            char c = word.charAt(index);
            if (c == '.') {
                for (TrieNode child : node.getChildren()) {
                    if (child != null && search(word, index + 1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                TrieNode child = node.getChildren()[c - 'a'];
                if (child == null) {
                    return false;
                }
                return search(word, index + 1, child);
            }
        }

    }

}
