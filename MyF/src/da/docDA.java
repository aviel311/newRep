package da;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.doc;
import util.DButil;

public class docDA implements Docdai {

	
	private Connection connection;
	
	public docDA (){
		connection = DButil.getconnection();
	}
	
	@Override
	public void addDoc(doc doc) {
		try{
			String query = "INSERT INTO public.doc (doc_city, doc_name, doc_id) VALUES (?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, doc.getdocCity());
			preparedStatement.setString(2, doc.getdocName());
			preparedStatement.setInt(3, doc.getdocId());
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		catch (SQLException e){
			System.out.println(e.getMessage());
		}

	}

	@Override
	public List<doc> getAllDoc() {
		List <doc> doc = new ArrayList <doc>();
		
		try{
			String query = "SELECT * FROM public.doc";
			Statement Statement = connection.createStatement();
			
			ResultSet rs = Statement.executeQuery(query);
			
			while (rs.next())
			{
				doc d = new doc();
				d.setdocId(rs.getInt("doc_id"));
				d.setDocName(rs.getString("doc_name"));
				d.setDocCity(rs.getInt("doc_city"));
				
				doc.add(d);
			}
			
			rs.close();
			Statement.close();
		}
		catch (SQLException e){
			System.out.println(e.getMessage());
		}

		return doc;	
	}

	@Override
	public doc getDocById(int docId) {
		doc d = new doc();
		try{
			String query = "SELECT * FROM public.doc WHERE doc_id ='"+docId+"'";
			Statement Statement = connection.createStatement();

			ResultSet rs = Statement.executeQuery(query);
			
				d.setdocId(rs.getInt("doc_id"));
				d.setDocName(rs.getString("doc_name"));
				d.setDocCity(rs.getInt("doc_city"));
				
			rs.close();
			Statement.close();
		}
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
		return d ;
	}

	@Override
	public void updateDoc(doc doc) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int docID) {
		// TODO Auto-generated method stub

	}

}
