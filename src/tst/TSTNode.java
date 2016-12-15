package tst;

import java.util.Vector;

import linkedlist.LinkedList;
import main.Document;

public class TSTNode {
	
	public char data;
    public boolean endofword;
    public TSTNode left, middle, right;
	public LinkedList files;

 


    public TSTNode(char data)

    {

        this.data = data;
        this.endofword = false;
        this.left = null;
        this.middle = null;
        this.right = null;
		files = new LinkedList();

    }        
}
