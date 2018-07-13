package fr.sev.mvnratebook.presentation;

import java.util.ArrayList;
import java.util.Scanner;

import fr.sev.mvnratebook.domain.Author;
import fr.sev.mvnratebook.service.AuthorService;

public class MainClass {

	public static void main(String[] args) {		
		
		AuthorService authorService = new AuthorService();
		int id;
		String name;
		String firstname;
		String firstLanguage;
		int birthYear;
		char letter;
		Author author;
		ArrayList<Author> authors;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println();
			System.out.println("choose a number:");
			System.out.println("-------------");
			System.out.println("1- create an author ");
			System.out.println("2- display an author");
			System.out.println("3- delete an author");
			System.out.println("4- display the list of all author");
			System.out.println("q- quit");
			letter = sc.nextLine().charAt(0);

			switch (letter) {

			case '1': // create an author
				System.out.println("Please, enter the name of the author.");
				name = sc.nextLine();
				System.out.println("Now, enter the firstname of the author.");
				firstname = sc.nextLine();
				System.out.println("And enter his main language.");
				firstLanguage = sc.nextLine();
				System.out.println("And his birth year.");
				while (!sc.hasNextInt()) {
					System.out.println("It's not a year. Try again.");
					sc.nextLine();
				}
				birthYear = sc.nextInt();
				sc.nextLine();
				author = new Author(name, firstname, firstLanguage, birthYear);
				authorService.addNewAuthor(author);
				break;

			case '2': // display author
				System.out.println("Please, enter the identifier of the author to display.");
				id = sc.nextInt();
				sc.nextLine();
				author = authorService.getAuthorById(id);
				System.out.println(author);
				break;

			case '3': // delete author
				System.out.println("Please, enter the identifier of the author to delete.");
				id = sc.nextInt();
				sc.nextLine();
				author = authorService.getAuthorById(id);
				System.out.println("The author " + id + " is being deleted.");
				authorService.deleteAuthor(author);
				break;

			case '4': //  display all authors
				System.out.println("Here is the list of all authors");
				authors = authorService.getListAuthors();
				for (Author a : authors) {
					System.out.println(a);
				}
				break;

			case 'q': // quit the game
				System.out.println("Goodbye!");
				break;

			default: // answer doesn't match a possible choice
				System.out.println("I don't understand your choice");
			}

		} while (letter != 'q');

		sc.close();


	}

}
