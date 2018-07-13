package fr.sev.mvnratebook.service;

import java.util.ArrayList;

import fr.sev.mvnratebook.dao.AuthorDAO;
import fr.sev.mvnratebook.domain.Author;

public class AuthorService {

	AuthorDAO authorDao = new AuthorDAO();
	
	public void addNewAuthor(Author author) {
		authorDao.createAuthor(author);
		System.out.println("Creation of new author: done");
	}

	public Author getAuthorById(int id) {
		return authorDao.getAuthorById(id);
	}

	public void deleteAuthor(Author author) {
		authorDao.deleteAuthor(author);
		System.out.println("Delete of new author: done");
	}

	public ArrayList<Author> getListAuthors() {
		return authorDao.getListOfAllAuthors();
	}

}
