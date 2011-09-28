package location.velos.dao.impl;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import location.velos.Client;
import location.velos.util.ApplicationContext;

import org.junit.Before;
import org.junit.Test;
/**
 * 
 * @author rachidOuchnine
 *
 */
public class DaoClientImplTest {

	private DaoClientImpl daoClientImpl;
	private Client client;

	@Before
	public void DaoClientImplInit() throws SQLException {
		Connection conn = ApplicationContext.getConnexion();
		daoClientImpl = new DaoClientImpl(conn);

	}

	/**
	 * -Quand j'initialise le daoclient je vérifie qu'il n'est pas null
	 */
	@Test
	public void initialiseLeDaoClientEtVerifieQuIlNestPasNull()
			throws Exception {
		assertNotNull(daoClientImpl);

	}

	/**
	 * -quand je cherche un client avec cin : "JA125672" -alors me retourne les
	 * infomations suivantes : ( "JA125672" , Ouchnine , rachid )
	 * 
	 * @throws SQLException
	 */
	@Test
	public void chercheClientParLeCinJA125672QuifaitretournerUnclientApellerRachidOuchnine()
			throws SQLException {
		client = daoClientImpl.chercheParCIN("JA125672");
		assertEquals("Ouchnine", client.getNom());
		assertEquals("Rachid", client.getPrenom());
	}

	/**
	 * étant donnée une classe qui permet la gestion des client Quand j'insere
	 * un nouveau client avec les données suivants : CIN :"JA111111" , Nom
	 * ="Nouib" prenom =" Hamza" alors je verifie est ce que les donnée sont
	 * bien enregistrées
	 * 
	 * @throws SQLException
	 */
	@Test
	public void ajouterClientNomméHazmaNouib() throws SQLException {
		Client clientpourtest = new Client();
		clientpourtest.setCIN("JA111111");
		clientpourtest.setNom("Nouib");
		clientpourtest.setPrenom("Hamza");
		int response = daoClientImpl.ajouterClient(clientpourtest);
		assertEquals(1, response);
	}
}
