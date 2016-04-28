package db.video;

import java.util.List;

import domain.Movie;
import domain.person.Person;

public interface VideoStorageConnectionInterface {
	
	/**
     * @return een lijst van alle films in de collectie
     */
    public List<Movie> getAllMovies();
    
    
    
    /**
     * Voegt een film toe aan de collectie
     * CRUD ==> create
     *
     * @param movie
     */
    public void addMovie(Movie movie);
    
    /**
    * CRUD ==> read
    */
   public Movie getMovieById(int id);
   
   /**
    * CRUD ==> update
    */   
   public void updateMovie(Movie movie);

   /**
    * CRUD ==> delete
    */   
   public void deleteMovieById(int id);
   
    

}
