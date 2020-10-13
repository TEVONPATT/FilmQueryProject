package com.skilldistillery.filmquery.entities;

import java.sql.Array;
import java.util.List;

public class Film {
	private int id;
	private String title;
	private String description;
	private int releaseYear;
	private String rating;
	private List<Actor> actors;
	private List<Film> films;
	private String language;

	public Film() {}
	
	public Film(int id, String title, int releaseYear, String rating, String description) {
		this.id = id;
		this.title = title;
		this.releaseYear = releaseYear;
		this.rating = rating;
		this.description = description;
	}

	public Film(int id, String title, String description, int release_year, String language, String rating) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = release_year;
		this.language = language;
		this.rating = rating;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Title: ");
		builder.append("\n");
		builder.append(title +"\n");
		builder.append("\n");
		builder.append("Description: ");
		builder.append("\n");
		builder.append(description +"\n");
		builder.append("\n");
		builder.append("Release Year: ");
		builder.append("\n");
		builder.append(releaseYear +"\n");
		builder.append("\n");
		builder.append("Rating: ");
		builder.append("\n");
		builder.append(rating +"\n");
		builder.append("\n");
		builder.append("Actors: ");
		builder.append("\n");
		builder.append(actors +"\n");
		builder.append("\n");
		builder.append("Language: ");
		builder.append("\n");
		builder.append(language +"\n");
		builder.append("\n");
		builder.append("");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actors == null) ? 0 : actors.hashCode());
		result = prime * result + ((description == null) ?  0 : description.hashCode());
		result = prime * result + ((films == null) ? 0 : films.hashCode());
		result = prime * result + id;
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + releaseYear;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (actors == null) {
			if (other.actors != null)
				return false;
		} else if (!actors.equals(other.actors))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (films == null) {
			if (other.films != null)
				return false;
		} else if (!films.equals(other.films))
			return false;
		if (id != other.id)
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (releaseYear != other.releaseYear)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	
	

	
	
}
