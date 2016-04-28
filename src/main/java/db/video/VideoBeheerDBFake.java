package db.video;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Movie;

public class VideoBeheerDBFake implements VideoStorageConnectionInterface {

	private static int instanceCounterMovies = 0;
	private int counterMovies = 0;
	Map<Integer, Movie> beheer;

	public VideoBeheerDBFake() {
		beheer = new HashMap<Integer, Movie>();
	}

	public List<Movie> getAllMovies() {
		List<Movie> lijstfilms = new ArrayList<Movie>(beheer.values());
		return lijstfilms;
	}

	 /**
     * CRUD ==> create
     */
	public void addMovie(Movie movie) {
		instanceCounterMovies++;
		counterMovies = instanceCounterMovies;

		// rekening houden met unieke variabelen voor remove update
		// int maxkey = Collections.max(beheer.keySet());

		// beheer.put(maxkey + 1, movie);
		movie.setId(counterMovies);
		beheer.put(counterMovies, movie);
	}

	/**
     * CRUD ==> read
     */
	public Movie getMovie(String naam, int jaar) {
		 Movie returnMovie = null;

	        for (Movie movie : beheer.values()) {
	            if (movie.getJaar() == jaar && movie.getTitle() == naam) {
	                return movie;
	            }
	        }

	        return returnMovie;
	}

	public Movie getMovieById(int id) {
		  Movie returnMovie = null;

	        for (Movie movie : beheer.values()) {
	            if (movie.getId() == id) {
	                return movie;
	            }
	        }

	        return returnMovie;
	}

	public void updateMovie(Movie movie) {
		beheer.put(movie.getId(), movie);
	}

	public void deleteMovieById(int id) {
		beheer.remove(id);

	}

}
