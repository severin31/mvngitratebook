package fr.sev.mvnratebook;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import java.util.ArrayList;
import fr.sev.mvnratebook.domain.Author;
import fr.sev.mvnratebook.service.AuthorService;

public class AppTest {

	@Test
	public void testAdditionnerEntier() {
		AuthorService authorService = new AuthorService();
		ArrayList<Author> authors = authorService.getListAuthors();
		assertNotNull(authors);
	}
	
}
