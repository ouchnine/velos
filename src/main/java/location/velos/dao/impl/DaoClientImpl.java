package location.velos.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import location.velos.Client;
import location.velos.dao.IDaoClient;

/**
 * 
 * @author rachidOuchnine
 *
 */
public class DaoClientImpl  implements IDaoClient{

	private Connection conn;

	private String createQuery = "INSERT INTO client( CIN, NOM, PRENOM ) VALUES (?, ?, ?)";
	private String chercheQuery = "SELECT CIN, NOM, PRENOM FROM CLIENT WHERE CIN=?";

	public DaoClientImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	/**
	 * cette méthode permet de cherche un client par CIN( carte d'identité
	 * nationnal)
	 * 
	 * @param cin
	 * @return
	 * @throws SQLException
	 */

	public Client chercheParCIN(String cin) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(chercheQuery);
		stmt.setString(1, cin);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		Client client = new Client();
		client.setCIN(rs.getString("CIN"));
		client.setNom(rs.getString("NOM"));
		client.setPrenom(rs.getString("PRENOM"));
		return client;
	}

	/**
	 * Methode qui permet un nouveau client dans la base de donnée
	 * 
	 * @param client
	 * @return 
	 * @throws SQLException
	 */
	public int ajouterClient(Client client) throws SQLException {

		PreparedStatement stmt = conn.prepareStatement(createQuery);
		stmt.setString(1, client.getCIN());
		stmt.setString(2, client.getNom());
		stmt.setString(3, client.getPrenom());
		int res = stmt.executeUpdate();
		stmt.close();
		return res;

	}

}
