package location.velos.service;

import java.sql.SQLException;

import location.velos.Client;
/**
 * 
 * @author RachidOuchnine
 *
 */
public interface Iservice {

	Client chercheByCIN(String cin) throws SQLException;
	public int ajouterClient(Client clientAEnregister) throws SQLException ;
}
