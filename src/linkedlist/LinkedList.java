package linkedlist;

import main.Document;
import trie.TrieNode;

public class LinkedList {
	 public Nodelist first;
	public  int size = 0;

	public LinkedList() {
			
	}
	
	
	//O(1)
	public void add(Document d){
		Nodelist p = new Nodelist(d);
		p.link = first;
		first = p;
		size++;
		
	}
	// add for trie node
	//O(1)
	public void add(TrieNode node){
		Nodelist p = new Nodelist(node);
		p.link = first;
		first = p;
		size++;
	}
	
	//for stack
	//O(1)
	public void add(String command){
		Nodelist p = new Nodelist(command);
		p.link = first;
		first = p;
		size++;
	}
	
	 //O(n)
	 public void del(Document d){
		Nodelist t = first;
		Nodelist s = null;
		while(t.doc!=d) {
			s = t;
			t = t.link;
			}
		s.link = t.link;
		size--;
		
	    
	}
	 //for trie  node
	//O(n)
	 public void del(TrieNode node){
			Nodelist t = first;
			Nodelist s = null;
			while(t.node != node) {
				s = t;
				t = t.link;
				}
			s.link = t.link;
			size--;
			
		    
		}
	 //eshterak migirad
	 //O(min(n+m))//lenght of 2 linked list
	 public LinkedList participation(LinkedList l1){
		 if(first==null ) return l1; 
		 if(l1.first==null) return this;
		 LinkedList ans  = new LinkedList();
		 Nodelist nl = l1.first;
		 while(nl!=null){
			 if(this.contain(nl.name)){
				ans.add(nl.doc);
			 }
			 nl = nl.link;
				 
		 }
		 return ans;
		 
	 }
	//O(n)
	 public boolean contain(String s){
		 Nodelist nl = first;
		 while(nl!=null){
			 
			 if((nl.name).equals(s)) return true;
			 nl = nl.link;
			 
		 }
		 return false;
		 
	 }

}
