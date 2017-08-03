package model;
//pojo - plan old java object
public class doc {
private int docCity;
private String docName;
private int docId;

public int getdocCity (){
	return docCity;
}
public void setDocCity(int doccity) {
	this.docCity = doccity;
}
public String getdocName (){
	return docName;
}
public void setDocName(String docName) {
	this.docName = docName;
}
public int getdocId (){
	return docId;
}
public void setdocId(int docId) {
	this.docId = docId;
}

public String toString() {
	return " doc [docname= " + docName + ",doc city= " + docCity + ",doc id= " + docId + "]";
	
}


}
