package com.min.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _211AddSearchTrie {
	public static void main(String[] args) {
		_211AddSearchTrie instance = new _211AddSearchTrie();
		instance.addWord("ab");
		instance.search("a.");
	}
	
    class TrieNode {
		char c;
		Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
		boolean isLeaf = false;
		public TrieNode() {
		}
		public TrieNode(char c) {
			this.c = c;
		}
	}

    TrieNode root = new TrieNode();
    // Adds a word into the data structure.
    public void addWord(String word) {
        if (word == null) {
            return;
        }
        int len = word.length();
        Map<Character, TrieNode> children = root.children;
        for (int i=0; i<len; i++) {
            char c = word.charAt(i);
            if (!children.containsKey(c)) {
                children.put(c, new TrieNode(c));
            }
            if (i == len-1) {
                ((TrieNode)children.get(c)).isLeaf = true;
            }
            children = ((TrieNode)children.get(c)).children;
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return dfsSearch(root.children, word, 0);
    }
    
    
    public boolean dfsSearch(Map<Character, TrieNode> children, String word, int start) {
        if(start == word.length()){
            if(children.size()==0) 
                return true; 
            else
                return false;
        }
 
        char c = word.charAt(start);    
 
        if(children.containsKey(c)){
            if(start == word.length()-1 && children.get(c).isLeaf){
                return true;
            }
 
            return dfsSearch(children.get(c).children, word, start+1);
        }else if(c == '.'){
            boolean result = false;
            for(Map.Entry<Character, TrieNode> child: children.entrySet()){
                if(start == word.length()-1 && child.getValue().isLeaf){
                    return true;
                } 
 
                //if any path is true, set result to be true; 
                if(dfsSearch(child.getValue().children, word, start+1)){
                    result = true;
                }
            }
 
            return result;
        }else{
            return false;
        }
    }
    
}
