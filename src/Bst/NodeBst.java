package Bst;
import java.util.Vector;

import linkedlist.LinkedList;
import main.Document;

public class NodeBst {
	public LinkedList files;
	public NodeBst lc;
	public NodeBst rc;
	public String value;
	

	public NodeBst(String value) {

		this.value = value;
		files = new LinkedList();
		lc = rc = null;
	}

}
