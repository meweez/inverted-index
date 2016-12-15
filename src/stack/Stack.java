package stack;

import linkedlist.LinkedList;
import linkedlist.Nodelist;

public class Stack {

	LinkedList stack ;
	public int top = -1;
	
	public Stack() {
		stack = new LinkedList();
		
		
	}
	public void add(String command){
		stack.addend(command);
		top++;
	}
	 
	public String subnode(int index){
		Nodelist nl = this.stack.first;
		int i=0;
		while(nl !=null && i<index){
			nl = nl.link;
			i++;
		}
		if(nl != null)
		return nl.command;
		return null;
	}

}
