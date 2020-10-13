package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {
	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
//    app.test();
		app.launch();
	}

//	private void test() {
//		Film film = db.findFilmById(1);
//	System.out.println(film);
//	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		boolean keepGoing = true;
		while (keepGoing) {
			userMenu1();
			int user = input.nextInt();
			switch (user) {
			case 1:
				idMenu();
				int filmId = input.nextInt();
				if (db.findFilmById(filmId) == null) {
					System.out.println("Film not found.");
				} else {
					System.out.println(db.findFilmById(filmId));
				}
				break;
			case 2:
				kwMenu();
				String kw = input.next();
				if (db.findFilmByKW(kw) == null) {
					System.out.println("Film not found.");
				} else {
					System.out.println(db.findFilmByKW(kw));
				}
				break;
			case 3:
				System.out.println("Goodbye!");
				keepGoing = false;
				break;
			default:
				System.out.println("Not a valid option");
				break;

			}
		}
	}

	private void userMenu1() {
		System.out.println("} __________________________________________________  {");
		System.out.println("}|           ____________________________           | {");
		System.out.println("}|   ()  () |         WELCOME TO         |   ()  () | {");
		System.out.println("}|  +++++++++     BEST OPTION MOVIES     +++++++++  | {");
		System.out.println("}++++++++++++++++++++++++++++++++++++++++++++++++++++{");
		System.out.println("  ||                                              ||  ");
		System.out.println("  ||  How would you like to search for the film?  ||  ");
		System.out.println("  ||   1) Look up a film by its id                ||  ");
		System.out.println("  ||   2) Look up a film by a search keyword      ||  ");
		System.out.println("  ||   3) Exit                                    ||  ");
		System.out.println("  ||                                              ||  ");
		System.out.println("}++++++++++++++++++++++++++++++++++++++++++++++++++++{");
	}

	private void idMenu() {
		System.out.println("} __________________________________________________  {");
		System.out.println("}|          ____________________________            | {");
		System.out.println("}|  {}  {} |   ANY IDea what you seek?  |   {}  {}  | {");
		System.out.println("}|  ++++++++                            ++++++++++  | {");
		System.out.println("}++++++++++++++++++++++++++++++++++++++++++++++++++++{");
		System.out.println("  ||           ______________________             ||  ");
		System.out.println("  ||          |                      |            ||  ");
		System.out.println("  ||          | Enter in the film id |            ||  ");
		System.out.println("  ||          |                      |            ||  ");
		System.out.println("  ||          |                      |            ||  ");
		System.out.println(" ---------------------------------------------------- ");
	}

	private void kwMenu() {
		System.out.println("} __________________________________________________  {");
		System.out.println("}|          ____________________________            | {");
		System.out.println("}|  <>  <> |   ANY WORDS COME TO MIND?  |   <>  <>  | {");
		System.out.println("}|  ++++++++                            ++++++++++  | {");
		System.out.println("}++++++++++++++++++++++++++++++++++++++++++++++++++++{");
		System.out.println("  ||                                              ||  ");
		System.out.println("  ||                                              ||  ");
		System.out.println("  ||               Enter in keyword               ||  ");
		System.out.println("  ||                     __ -------               ||  ");
		System.out.println("  ||                    (  )/                     ||  ");
		System.out.println("  ||                   /|  |                      ||  ");
		System.out.println("  ||                     ||                       ||  ");
		System.out.println(" ---------------------------------------------------- ");
	}
}
