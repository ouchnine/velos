package location.velos;

/**
 * @author RachidOuchnine	
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ClientTest {

	private Client client;

	@Before
	public void initClient() {
		client = new Client();
	}

	/**
	 * Lorsque j'initialise le client et je verifie que il n'est pas null
	 */

	@Test
	public void initialiseLeClientEtVerifieQuIlNestPasNull() throws Exception {
		assertNotNull(client);
	}

	/**
	 * -Quand je modifier ( setCIN) le CIN( Code d'identité Nationnal) a
	 * "JA125672" -Quand j'apelle la méthode getCIN j'obtiens le meme CIN
	 */
	@Test
	public void intialiseLeCINavecJA125672QuiRetourneMemeCIN() throws Exception {
		client.setCIN("JA125672");
		assertEquals("JA125672", client.getCIN());
	}

	/**
	 * -Quand je modifier le nom (setNom) a "Ouchnine" -quand j'appelle le
	 * méthode getNom j'obtiens le meme CIN
	 */

	@Test
	public void initaliseLeNomavecOuchninequiRetourneMemeNom() throws Exception {
		client.setNom("Ouchnine");
		assertEquals("Ouchnine", client.getNom());

	}
	
	/**
	 * -Quand je modifie le Prenom (setPrenom) a "Rachid " 
	 * -Quand j'appelle getPrenom()j'obteins "Rachid"
	 */

	@Test
	public void initaliseLePrenomavecRachidquiRetourneMemePrenom() throws Exception {
		client.setPrenom("Rachid");
		assertEquals("Rachid", client.getPrenom());

	}
}
