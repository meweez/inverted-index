package trie;

import java.util.Vector;

import linkedlist.Nodelist;
import main.Document;
public class TrieTree {
	
	public TrieNode root;
	
	public TrieTree() {
		root = new TrieNode(' ');
		
	}
	//-----------------------------------------------------------------------
	public void add(String word,Document d){
        TrieNode current = root; 

        for (char ch : word.toCharArray() )

        {
            TrieNode child = current.subNode(ch);
            

            if (child != null){//we had it before
                current = child;}

            else 

            {//don have it before
            	 TrieNode p = new TrieNode(ch);
                 current.children.addend(p);
                 current = p;
            }


        }

        current.isEnd = true;
        if(!current.files.contain(d.name)){
        	current.files.addend(d);
        }
	}
	//-----------------------------------------------------------------
	
    public void delete(String word)

    {

    	 TrieNode current = root;  

         for (char ch : word.toCharArray() )

         {

             if (current.subNode(ch) == null)

                 return ;

             else

                 current = current.subNode(ch);

         }      

         if (current.isEnd == true){
        	 if(current.files.size == 1)
        		 current.isEnd = false;
         }

         return ;

    }
    
	//-----------------------------------------------------------------
    public TrieNode search(String word)

    {
        TrieNode current = root;  

        for (char ch : word.toCharArray() )

        {

            if (current.subNode(ch) == null)

                return null;

            else

                current = current.subNode(ch);

        }      

        if (current.isEnd == true) return current;

        return null;

    }
    //-----------------------------------------------------------------------
	public int number(TrieNode r){
		
		Nodelist nl = r.children.first;
		int n = 0;
		while(nl != null){
			n += number(nl.node);
			nl = nl.link;
		}
		return n+1;
	}
	//--------------------------------------------------------------
	public int height (TrieNode r){
		
		Nodelist nl = r.children.first;
		int n = 0;
		while(nl != null){
			n =Math.max(n,number(nl.node));
			nl = nl.link;
		}
		return n;
	}
	//----------------------------------------------------------------------

	
//	
//    public static void main(String[] args) {
//    	System.out.println("hello");
//		TrieTree t = new TrieTree();
//		Document d = new Document("", "");
//		t.add("hello", d);
//		t.add("hi", d);
//		t.delete("hello");
//		System.out.println(t.number(t.root));
//		t.traverseTrie(t.root, "");
//		
//	}

}
