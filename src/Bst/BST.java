package Bst;
import java.util.Vector;

import main.Document;

public class BST {

	public NodeBst root;
	
	public BST() {
		
	}
	
	//O(logn)
	public boolean add(String key,Document d){
		NodeBst t=root,s=null;
		while(t!=null){
			s=t;
			if((t.value).compareTo(key)==0 ) {
				  if(!t.files.contain(d.name)) t.files.add(d);
				return false;
			}
			if( (t.value).compareTo(key)>0 ){//node is larger than key 
				t=t.lc;
			}else if((t.value).compareTo(key)<0 ){//node is smaller than key
				t=t.rc;
			}			
			
		}
		NodeBst p = new NodeBst(key);
		p.lc=p.rc=null;
		p.files.add(d);
		if(s==null) {root = p;  return true; }
		if((s.value).compareTo(key)>0){
			s.lc = p;
		}else{
			s.rc = p;
		}
		return true;
		
	}
	//O(n)
	int k=0;
	public int number(NodeBst t){
		if(t==null) return 0;
		else{ 
		return 1+number(t.lc)+number(t.rc);}
	}
	////O(n)
	public int height(NodeBst t){
		if(t==null) return 0;
		else return 1 + Math.max(height(t.lc),height(t.rc));	
	}
	
	//O(logn)
	public NodeBst binarySearch(String  s){
		NodeBst t = root;
		String key = s;
		while(t!=null){
		
			if((t.value).compareTo(key)==0) {
				return t;
			}
			if( (t.value).compareTo(key)>0 ){//node is larger than key 
				t=t.lc;
			}else if((t.value).compareTo(key)<0 ){//node is smaller than key
				t=t.rc;
			}			
			
		}
		return null;
	}
	//O(logn)
	public void delete(NodeBst parent,NodeBst root,String key){
		if(root==null){
			return ;
		}
		if(root.value.equals(key) ){
			//delete
			 if ((root.lc == null) && (root.rc == null)) {
	                // leaf node
				 	if(root.files.size==1)
	                root = null;
	                return ;
	            }
			 if ((root.lc != null) && (root.rc != null)) {
	                // node with two children
				 if(root.files.size==1)
	                root.value = minOfRight(root.rc);
	                return ;
	            }

	            //  left child 
	            if (root.lc != null && root.files.size==1) {
	            	
	            	if(parent.lc==root)
	            		parent.lc = root.lc;
	            	else
	            		parent.rc = root.lc;
	            
	                root = null;
	                return ;
	            }
	            // right child
	            if (root.rc != null && root.files.size==1) {
	            	if(parent.lc==root)
	            		parent.lc = root.rc;
	            	else
	            		parent.rc = root.rc;
	            	
	            	root=null;
	                return;
	            }
		}else if(root.value.compareTo(key)<0){
			delete(root,root.rc,key);
		}else if(root.value.compareTo(key)>0){
			delete(root,root.lc,key);
		}
		
	}
	
	 String minOfRight(NodeBst node) {
		 while(node.lc!=null){
			 node = node.lc;
		 }
		 
	            String s = node.value;
	            //delete that node
	            node = null;
	            return s;
	        
	    }
//	public static void main(String[] args) {
//		BST t = new BST();
//		Document d = new Document("","");
//		t.add("nt", d);
//		t.add("hi", d);
//		t.add("key", d);
//		System.out.println(t.number(t.root));
//	}
	 

}
