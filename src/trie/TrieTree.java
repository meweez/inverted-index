package trie;

import java.util.Vector;

import linkedlist.Nodelist;
import main.Document;
public class TrieTree {
	
	public TrieNode root;
	int height = 0;
	
	public TrieTree() {
		root = new TrieNode(' ');
		
	}
	//-----------------------------------------------------------------------
	//O(h)=O(logn) h is height
	public void add(String word,Document d){
        TrieNode current = root; 
        height = Math.max(height, word.toCharArray().length);
        for (char ch : word.toCharArray() )

        {
            TrieNode child = current.subNode(ch);
            

            if (child != null){//we had it before
                current = child;}

            else 

            {//don have it before
            	 TrieNode p = new TrieNode(ch);
                 current.children.add(p);
                 current = p;
            }


        }

        current.isEnd = true;
        if(!current.files.contain(d.name)){
        	current.files.add(d);
        }
	}
	//-----------------------------------------------------------------
	//O(h)=O(logn) h is height
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
  //O(h)=O(logn) h is height
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
    //O(n)
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
	//O(max h)  h is number of chsrs in word
	public int height (TrieNode r){
		
		
		return height;
	}
	//----------------------------------------------------------------------

//------------------------------------------------------------------
//	public static void main(String[] args) {
//		TrieTree t = new TrieTree();
//		Document d = new Document("","");
//		t.add("comp", d);
//		t.add("maryam", d);
//		t.add("hello", d);
//		t.traverseTrie(t.root, "");
//	}

}
