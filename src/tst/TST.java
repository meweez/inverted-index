package tst;

import Bst.NodeBst;
import main.Document;

public class TST {
	
	public TSTNode root;
	 char buffer[];

	public TST() {
		
		root = null;
		buffer = new char[100];
		
	}
	
    public void add(String word,Document d)

    {
    	if(!word.equals(""))
        root = add(root, word, 0,d);
    }


    public TSTNode add(TSTNode r, String word, int i,Document d)

    {
        if (r == null)  {   r = new TSTNode(word.charAt(i));
        }

 

        if (word.charAt(i)< r.data)

            r.left = add(r.left, word, i, d);

        else if (word.charAt(i) > r.data)

            r.right = add(r.right, word, i, d);

        else

        {

            if (i + 1 < word.length())//is not end of word

                r.middle = add(r.middle, word, i + 1, d);

            else{
            	r.endofword = true;
            	if(!r.files.contain(d.name))
            	r.files.addend(d);
            	
            }


        }

        return r;

    }
    
    public void delete(String word)

    {
    	if(!word.equals(""))
        delete(root, word, 0);
    }

    /** function to delete a word **/

    private void delete(TSTNode r, String word, int i)

    {

        if (r == null) return;
 

        if (word.charAt(i) < r.data)

            delete(r.left, word, i);

        else if (word.charAt(i)> r.data)

            delete(r.right, word, i);

        else

        {

            /** to delete a word just make endofword false **/

            if (r.endofword && i == word.length() - 1)

            	if( r.files.size==1)
                r.endofword = false;

 

            else if (i + 1 < word.length())
                delete(r.middle, word, i + 1);

        }        

    }
    
    public int number(TSTNode t){
		if(t==null) return 0;
		else return 1+number(t.left)+number(t.right)+number(t.middle);
	}
	
	public int height(TSTNode t){
		if(t==null) return 0;
		else{ 
			int m = Math.max(height(t.left),height(t.right));
			return 1 + Math.max(m,height(t.middle));
			}	
	}
	
    /** function to search for a word **/

    public TSTNode search(String word)

    {

        return search(root, word, 0);

    }

    /** function to search for a word **/

    private TSTNode search(TSTNode r,String word, int i)

    {

        if (r == null)

            return null;

 

        if (word.charAt(i) < r.data)

            return search(r.left, word, i);

        else if (word.charAt(i) > r.data)

            return search(r.right, word, i);

        else

        {

            if (r.endofword && i == word.length() - 1)

                return r;

            else if (i == word.length() - 1)

                return null;

            else

                return search(r.middle, word, i + 1);

        }        

    }
   
    
    
//    public static void main(String[] args) {
//		
//		
//    	TST t = new TST();
//    	Document d = new Document("", "");
//    	t.add("salam", d);
//    	t.add("hello", d);
//    	t.add("maryam", d);
//    	System.out.println("nodes are " + t.number(t.root));
//    	System.out.println("height " + t.height(t.root));
//    	TSTNode tt =  t.TSTSearch(t.root, "salam", 0);
//    	System.out.println(tt.data);
//    	t.traverseTST(t.root,  0);
//    	
//	}
}
