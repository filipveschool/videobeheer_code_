package db.person;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Queue;

import javax.persistence.*;

import db.DBException;
import domain.Movie;
import domain.person.Person;

public class PersonBeheerRelationalDatabase implements PersonStorageConnectionInterface {
	
	private EntityManagerFactory factory;
	private EntityManager manager;
    private String name = "videobeheer";
    
    public PersonBeheerRelationalDatabase(){
    	
    }
    

    public void openConnection() {

        factory = Persistence.createEntityManagerFactory(name);
        /*
       manager ==> Does all the work
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
    
	public List<Person> getAllActorsFromOneMovie(int id) {

		try{
			openConnection();
			Query query = manager.createNativeQuery("SELECT pers.ID," +
					"NAME,FAMILYNAME,DAGGEBOORTE,MAANDGEBOORTE,JAARGEBOORTE,GENDER FROM PERSON as pers inner JOIN " +
					"MOVIE_PERSON as mp on pers.ID = mp.ACTORS_ID INNER JOIN MOVIE as mov " +
					"on mov.ID=mp.MOVIE_ID WHERE mov.ID=?1");
			query.setParameter(1,id);

			List<Person> persons = query.getResultList();
			return persons;
		}catch(Exception e){
			throw new DBException(e.getMessage(),e);
		}
		//return movie.getActors();
	}

	public List<Person> getAllActors() {
		 try {
	            openConnection();

	            Query query = manager.createQuery("select pers from Person pers");
	            List<Person> actors = query.getResultList();
	            return actors;
	        } catch (Exception e) {
	            throw new DBException(e.getMessage(), e);
	        }
	}

	public void addActor(Person actor, Movie movie) {
		// TODO Auto-generated method stub
		/*
		 *  List<Person> actorsInMovie = movie.getActors();
        actorsInMovie.add(actor);
        movie.setActors(actorsInMovie);
		 */

	}
	
	
	/**
     * CRUD ==> create
     */
	public void addActor(Person actor) {
		openConnection();

        manager.getTransaction().begin();
        
        manager.persist(actor);
        manager.flush();
        manager.getTransaction().commit();
        closeConnection();

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
     * CRUD ==> read
     */
	public Person getActorById(int id) {
		try{
			openConnection();
			
			Person person = manager.find(Person.class, id);
			return person;
		}catch(Exception e){
			throw new DBException(e.getMessage(),e);
		}
		
	}

	/**
     * CRUD ==> update
     */
	public void updateActor(Person actor) {
		manager.getTransaction().begin();
		manager.merge(actor);
		manager.getTransaction().commit();
		closeConnection();

	}

	/**
     * CRUD ==> delete
     */
	public void deleteActor(int id) {
		beginTransactie();
		
		Person person = manager.find(Person.class, id);
		manager.remove(person);
		manager.getTransaction().commit();
		
		sluitTransactie();
	}
	
	/* hulp functies */
	
	public void beginTransactie(){
		openConnection();
		manager.getTransaction().begin();
	}
	
	public void sluitTransactie(){
		closeConnection();
	}

}
