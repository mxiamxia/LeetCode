package com.min.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _208ImpleTrie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class TrieNode {
		// Initialize your data structure here.
		char c;
		Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
		boolean isLeaf;

		public TrieNode() {
		}

		public TrieNode(char c) {
			this.c = c;
		}
	}

	public class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		// Inserts a word into the trie.
		public void insert(String word) {
			if (word == null) {
				return;
			}
			Map children = root.children;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (!children.containsKey(c)) {
					
					children.put(c, new TrieNode(c));
				}
				if (i == word.length() - 1) {
					((TrieNode)children.get(c)).isLeaf = true;
				} else {
					children = ((TrieNode)children.get(c)).children;
				}
			}
		}

		// Returns if the word is in the trie.
		public boolean search(String word) {
			if (word == null) {
				return true;
			}
			Map children = root.children;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (!children.containsKey(c)) {
					return false;
				}
				if (i == word.length() - 1 && ((TrieNode)children.get(c)).isLeaf) {
					return true;
				}
				children = ((TrieNode)children.get(c)).children;
			}
			return false;
		}

		// Returns if there is any word in the trie
		// that starts with the given prefix.
		public boolean startsWith(String prefix) {
			if (prefix == null) {
				return true;
			}
			Map children = root.children;
			for (int i = 0; i < prefix.length(); i++) {
				char c = prefix.charAt(i);
				if (!children.containsKey(c)) {
					return false;
				}
				children = ((TrieNode)children.get(c)).children;
			}
			return true;
		}
	}

}
