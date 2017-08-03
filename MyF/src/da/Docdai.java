package da;

import java.util.List;

import model.doc;
import sun.net.www.content.text.plain;

public interface Docdai {
	
	public void addDoc (doc doc) ;
	
	public List <doc> getAllDoc();
	public doc getDocById (int docId);

	public void updateDoc (doc doc);
	
	public void delete (int docID);
		
	
}
