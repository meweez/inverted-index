package main;
import java.util.Vector;

public class Document {
	
	 public String name;
	String address;
	Vector<Word> words;
	public Document(String filepath,String name){
		this.address=filepath;
		this.name = name;
		words = new Vector<Word>();
		
	}

}
