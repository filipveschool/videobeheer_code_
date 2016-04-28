package db.video;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import db.DBException;
import domain.Movie;

public class VideoBeheerRelationalDatabase implements VideoStorageConnectionInterface {

	private EntityManagerFactory factory;
	private EntityManager manager;
	private String name = "videobeheer";

	public VideoBeheerRelationalDatabase() {

	}

	public void openConnection() {

		factory = Persistence.createEntityManagerFactory(name);
		/*
		 * manager ==> Does all the work
		 */
		manager = factory.createEntityManager();

	}

	public void closeConnection() throws DBException {
		try {
			manager.close();
			factory.close();
		} catch (Exception e) {
			throw new DBException(e.getMessage(), e);
		}
	}

	public List<Movie> getAllMovies() {
		try {
			openConnection();

			Query query = manager.createQuery("Select mov from Movie mov");

			List<Movie> movies = query.getResultList();
			// closeConnection();
			return movies;
		} catch (Exception e) {
			// throw new DatabaseException(e.getMessage(),e);
			throw new DBException(e.getMessage(), e);
		}
	}

	 /**
     * CRUD ==> create
     */
	public void addMovie(Movie movie) {
		openConnection();

        manager.getTransaction().begin();
        manager.persist(movie);
        manager.flush();
        manager.getTransaction().commit();
        closeConnection();
	}

	public Movie getMovieById(int id) {
		try {
            openConnection();

            //String sql = "Select mov from Movie mov where mov.id=id";
            /*Query query = manager.createQuery(sql);*/
            Movie movie = manager.find(Movie.class, id);


            return movie;
        } catch (Exception e) {
//throw new DatabaseException(e.getMessage(),e);
            throw new DBException(e.getMessage(), e);

        }
	}
	
	 /*
    JPA exposes two methods... persist() and merge()

    Persist: Persist is responsible for inserting new rows to DB and then associating the Entity with state in JPA session.

    Merge: Merge takes existing Entity and updates the DB row. It also updates the state of the entity in JPA session.

    ------------------------

    EntityManager.persist() is used to create a new entity bean.

Creating a new entity bean involves inserting a new row in the database.

You use EntityManager.merge() to update an entity bean that already exists.

Calling EntityManager.merge() updates the database to reflect changes made to a detached entity bean.

If your entity bean is not detached, there's no need to invoke merge().

If your user bean is not detached, you can simply modify its properties by calling methods like setLoginAttempts().

The EntityManager and container will update the database automatically (when the transaction is committed).
     */


    /**
     * CRUD ==> update
     */
	public void updateMovie(Movie movie, Movie oldMovie) {
		// TODO Auto-generated method stub
		//beheer.put(oldMovie.getId(), movie);

	}
	
	public void updateMovie(Movie movie){
		openConnection();
        manager.getTransaction().begin();
        manager.merge(movie);
        //manager.flush();
        manager.getTransaction().commit();
        closeConnection();
        
	}

	/**
    * CRUD ==> delete
    */
	public void deleteMovieById(int id) {

        openConnection();

        manager.getTransaction().begin();
        Movie movie = manager.find(Movie.class, id);
        manager.remove(movie);
        manager.getTransaction().commit();
        closeConnection();
    }

}
