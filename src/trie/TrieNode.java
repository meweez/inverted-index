package trie;

import java.util.ArrayList;
import java.util.Vector;

import linkedlist.LinkedList;
import linkedlist.Nodelist;

public class TrieNode {

    public boolean isEnd;
    public LinkedList children;
    public char ch;
	public LinkedList files;
	
	public TrieNode(char ch) {
		// TODO Auto-generated constructor stub
		children = new LinkedList();
		files = new LinkedList();
		isEnd = false;
		this.ch = ch;
	}
	
    public TrieNode subNode(char c)

    {//this func return node with ch = c in children

        if (children != null){
        	Nodelist nl = children.first;
        	while(nl != null){
        		if(nl.node.ch == c)
        			return nl.node;
        		nl = nl.link;
        	}
        }
        	return null;
        	
        

    }

}
