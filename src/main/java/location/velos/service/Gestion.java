package location.velos.service;

import java.sql.Connection;
import java.sql.SQLException;

import location.velos.Client;
import location.velos.dao.impl.DaoClientImpl;
import location.velos.util.ApplicationContext;
/**
 * 
 * @author rachidOuchnine
 *
 */
public class Gestion implements Iservice {

	private DaoClientImpl daoClientImpl;

	public DaoClientImpl getDaoClientImpl() {
		return daoClientImpl;
	}

	public void setDaoClient(DaoClientImpl daoClientImpl) {
		this.daoClientImpl = daoClientImpl;
	}

	public Gestion() {

	}

	/**
	 * cette méthode permet la recherche d'un client a traver son CIN
	 */
	@Override
	public Client chercheByCIN(String cin) throws SQLException {
		Connection conn = ApplicationContext.getConnexion();

		return getDaoClientImpl().chercheParCIN(cin);
	}

	/**
	 * Cette méthode permet l'ajout d'un client dans la base de donnnée
	 * 
	 * @param clientAEnregister
	 * @return
	 * @throws SQLException
	 */
	public int ajouterClient(Client clientAEnregister) throws SQLException {
		Connection conn = ApplicationContext.getConnexion();

		return getDaoClientImpl().ajouterClient(clientAEnregister);
	}

}
