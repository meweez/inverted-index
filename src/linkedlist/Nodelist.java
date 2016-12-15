package linkedlist;

import java.util.Vector;

import main.Document;
import main.Word;
import trie.TrieNode;

public class Nodelist {

	 public String name;
	 public Document doc;
	 public Nodelist link;
	 
	public Nodelist(Document doc) {
		this.doc = doc;
		this.name = doc.name;
		link = null;
	}
	public TrieNode node;
	public Nodelist(TrieNode node){
		this.node = node;
	}
	public String command;
	public Nodelist(String c){
		command = c;
	}

}
