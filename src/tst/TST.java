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
	//O(h)=O(logn) h is height
    public void add(String word,Document d)

    {
    	if(!word.equals(""))
        root = add(root, word, 0,d);
    }


    public TSTNode add(TSTNode r, String word, int i,Document d)

    {
        if (r == null)  {   r = new TSTNode(word.charAt(i));  }

 

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
            	r.files.add(d);
            	
            }


        }

        return r;

    }
  //O(h)=O(logn) h is height
    public void delete(String word)

    {
    	if(!word.equals(""))
        delete(root, word, 0);
    }

    

    private void delete(TSTNode r, String word, int i)

    {

        if (r == null) return;
 

        if (word.charAt(i) < r.data)

            delete(r.left, word, i);

        else if (word.charAt(i)> r.data)

            delete(r.right, word, i);

        else

        {

            // to delete a word just make endofword false 

            if (r.endofword && i == word.length() - 1)

            	if( r.files.size==1)
                r.endofword = false;

 

            else if (i + 1 < word.length())
                delete(r.middle, word, i + 1);

        }        

    }
    //O(n)
    public int number(TSTNode t){
		if(t==null) return 0;
		else return 1+number(t.left)+number(t.right)+number(t.middle);
	}
    //O(n)
	public int height(TSTNode t){
		if(t==null) return 0;
		else{ 
			int m = Math.max(height(t.left),height(t.right));
			return 1 + Math.max(m,height(t.middle));
			}	
	}
	
   
	//O(h)=O(logn) h is height
    public TSTNode search(String word)

    {

        return search(root, word, 0);

    }

   

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
   // my first func
    
//    public void add(TSTNode root,int place,TSTNode node,String key,int i){
//        //place 1 for lc
//        //place 2 for child
//        //place 3 foe rc
//        
//        if(node==null){
//        	TSTNode n = new TSTNode(key.charAt(i));
//          if(place==1){
//            root.left = n;
//          }else if(place==2){
//            root.middle = n;
//          }else if(place==3){
//            root.right = n;
//          }
//          if(i==key.length()-1) {
//            n.endofword = true;
//            return;
//          }
//          
//        }
//        
//        if(key.charAt(0)==node.data){      
//            add(node,2,node.middle,key,i+1);
//        }else if(key.charAt(0)<root.data){      
//            add(node,1,node.left,key,i);
//        }else if(key.charAt(0)>root.data){      
//            add(node,3,node.right,key,i);
//        }
//        
//      }
    
    
//    public static void main(String[] args) {
//		TST t = new TST();
//		Document d= new Document("", "");
//		t.add("maryam", d);
//		t.add("sara", d);
//		t.add("mery", d);
//	}
   
    
 
}
