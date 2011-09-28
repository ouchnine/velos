package location.velos.dao;

import java.sql.SQLException;

import location.velos.Client;
/**
 * 
 * @author rachidOuchnine
 *
 */
public interface IDaoClient {

	Client chercheParCIN(String cin) throws SQLException;
	public int ajouterClient(Client client) throws SQLException ;

	
}
