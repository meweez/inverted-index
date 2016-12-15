package linkedlist;

import main.Document;
import trie.TrieNode;

public class LinkedList {
	 public Nodelist first;
	public  int size = 0;

	public LinkedList() {
			
	}
	
	public void addend(Document d){
		Nodelist t = first;
		Nodelist s =null;
		
		while(t!=null){
			s=t;
			t = t.link;}
		
		Nodelist p = new Nodelist(d);
		p.doc = d;
		p.name = d.name;
		if(s==null) { first = p; size++; return;}
		  s.link = p;
		  size++;
	}
	//for trie node
	public void addend(TrieNode node){
		Nodelist t = first;
		Nodelist s =null;
		
		while(t!=null){
			s=t;
			t = t.link;}
		
		Nodelist p = new Nodelist(node);
		if(s==null) { first = p; size++; return;}
		  s.link = p;
		  size++;
	}
	//for stack
	
	public void addend(String command){
		Nodelist t = first;
		Nodelist s =null;
		
		while(t!=null){
			s=t;
			t = t.link;}
		
		Nodelist p = new Nodelist(command);
		if(s==null) { first = p; size++; return;}
		  s.link = p;
		  size++;
	}
	
	 
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
	 public LinkedList participation(LinkedList l1){
		 if(first==null ) return l1; 
		 if(l1.first==null) return this;
		 LinkedList ans  = new LinkedList();
		 Nodelist nl = l1.first;
		 while(nl!=null){
			 if(this.contain(nl.name)){
				ans.addend(nl.doc);
			 }
			 nl = nl.link;
				 
		 }
		 return ans;
		 
	 }
	 
	 public boolean contain(String s){
		 Nodelist nl = first;
		 while(nl!=null){
			 
			 if((nl.name).equals(s)) return true;
			 nl = nl.link;
			 
		 }
		 return false;
		 
	 }
//	 public int  size(){
//		 return  size(first);
//	 }
//	 
//	 public int  size(Nodelist first){
//		 Nodelist t = first;
//		 if(t==null) return 0;
//		 else return (1+size(t.link));
//		 
//	 }
//	 public static void main(String[] args) {
////		LinkedList l = new LinkedList();
////		Document d = new Document("","hi");
////		Nodelist p = new Nodelist(d);
////		System.out.println("1 "+l.first);
////		l.addend(d);
////		System.out.println("2 "+l.first.name);
////		System.out.println(l.size());
////		Document dd = new Document("","hello");
////		l.addend(dd);
////		System.out.println("3 "+l.first.name);
////		System.out.println(l.size());
////		l.addend(d);
////		System.out.println("4 "+l.first.name);
////		System.out.println(l.size());
//		 System.out.println("yes".equals("yes"));
//		
//	 }

}
