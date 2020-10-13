package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	static final String user = "student";
	static final String pass = "student";
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";

	@Override
	public Film findFilmById(int filmId) {
		Film film = new Film();
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT * FROM film JOIN language ON film.language_id = language.id WHERE film.id = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				film = new Film();
				int id = rs.getInt("id");
				film.setTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setReleaseYear(rs.getInt("release_year"));
				film.setRating(rs.getString("rating"));
				film.setLanguage(rs.getString("name"));
//				film.setLanguageId(rs.getInt("language_id"));
				film.setActors(findActorsByFilmId(filmId));
			}
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}
	@Override
	public List<Film> findFilmByKW(String filmKW) {
		List<Film> findFilmByKW = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT * FROM film JOIN language ON film.language_id = language.id WHERE title LIKE ? OR description LIKE ?";

			PreparedStatement stmt2 = conn.prepareStatement(sql);
			stmt2.setString(1, "%" + filmKW + "%");
			stmt2.setString(2, "%" + filmKW + "%");
			ResultSet rs2 = stmt2.executeQuery();

			while (rs2.next()) {
				int id = rs2.getInt("id");
				String title = rs2.getString("title");
				String description = rs2.getString("description");
				int release_year = rs2.getInt("release_year");
				String language = rs2.getString("name");
				String rating = rs2.getString("rating");
				Film films = new Film(id, title, description, release_year, language, rating);
				findFilmByKW.add(films);
//				film.setActors(findActorsByFilmId(filmId))
//				findFilmByKW.setActors(findActorById(filmKW));
			}
			conn.close();
			stmt2.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return findFilmByKW;

//			public void setActors(List<Actor> actors) {
//				this.actors = actors;
//			}
	}

	@Override
	public Actor findActorById(int actorId) {
		Actor actor = new Actor();
		String sql = "SELECT * FROM actor WHERE id = ?";
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet actorResult = stmt.executeQuery();
//			while (actorResult.next()) {
//				actor.setActorID(1);
//				actor.setActorFName(actorResult.getString(2));
//				actor.setActorLName(actorResult.getString(3));
//			}
			if(actorResult.next()) {
				int id = actorResult.getInt("id");
				 actor.setActorID(id);
				 actor.setActorFName(actorResult.getString("first_name"));
				 actor.setActorLName(actorResult.getString("last_name"));
				
			}
			conn.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();
		try {
			Connection connAir = DriverManager.getConnection(URL, user, pass);
			String sql2 = "SELECT * FROM actor JOIN film_actor ON actor.id = film_actor.actor_id JOIN film on film.id = film_actor.film_id WHERE film_actor.film_id = ?";
			PreparedStatement pst = connAir.prepareStatement(sql2);
			pst.setInt(1, filmId);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				Actor actor = new Actor(id, firstName, lastName);
				actors.add(actor);
			}
			connAir.close();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actors;

	}
}