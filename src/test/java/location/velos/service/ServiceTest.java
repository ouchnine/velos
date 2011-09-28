package location.velos.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import location.velos.Client;
import location.velos.dao.impl.DaoClientImpl;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Rachidouchnine
 * 
 */
public class ServiceTest {

	private Gestion gestion;

	@Before
	public void serviceInit() throws SQLException {
		gestion = new Gestion();

	}

	/**
	 * -Etant donnée une classe service pour la gestion de location des vélos
	 * -Quand je passe le CIN = "JA125672" -alors il me renvoie le client qui
	 * correspond
	 * 
	 * @throws SQLException
	 */
	@Test
	public void chercheClientParLeCinJA125672QuifaitretournerUnclientApellerRachidOuchnine()
			throws SQLException {
		DaoClientImpl doublure = mock(DaoClientImpl.class);

		Client client = new Client();
		client.setCIN("JA125672");
		client.setNom("Ouchnine");
		client.setPrenom("Rachid");

		when(doublure.chercheParCIN("JA125672")).thenReturn(client);
		gestion.setDaoClient(doublure);

		Client clientFromService = gestion.chercheByCIN("JA125672");

		verify(doublure).chercheParCIN("JA125672");

		assertEquals(client.getCIN(), clientFromService.getCIN());
		assertEquals(client.getNom(), clientFromService.getNom());
		assertEquals(client.getPrenom(), clientFromService.getPrenom());

	}

	/**
	 * étant donné uen classe service qui permet la gestion de la location des
	 * velos Quand j'inserre nnouveau client : CIN="JA222222" Nom="Boulahya	"
	 * Prenom ="Yahya" dans la base alors il me renvoie une confermation
	 * d'insertion
	 * 
	 * @throws SQLException
	 * 
	 */
	@Test
	public void ajoutClientBoulahyaYahyaquiFaitRetourneUneRéponsedeConfermation()
			throws SQLException {
		DaoClientImpl mock = mock(DaoClientImpl.class);

		Client clientAEnregister = new Client();
		clientAEnregister.setCIN("JA222222");
		clientAEnregister.setNom("Boulahya");
		clientAEnregister.setPrenom("Yahya");

		when(mock.ajouterClient(clientAEnregister)).thenReturn(1);

		gestion.setDaoClient(mock);

		int reponse = gestion.ajouterClient(clientAEnregister);
		verify(mock).ajouterClient(clientAEnregister);
		assertEquals(1, reponse);

	}
}
