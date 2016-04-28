package db.person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Movie;
import domain.person.Person;

public class PersonBeheerDbFake implements PersonStorageConnectionInterface{

	private static int instanceCounterActors = 0;
	private int counterActors = 0;
	Map<Integer, Person> persons;
	 
	public PersonBeheerDbFake(){
		persons = new HashMap<Integer, Person>();  
	}

	public List<Person> getAllActorsFromOneMovie(int id) {
		return null;
	}

	public List<Person> getAllActors() {
		return new ArrayList<Person>(persons.values());
	}

	/**
     * CRUD ==> create 2
     */
	public void addActor(Person actor, Movie movie) {

        List<Person> actorsInMovie = movie.getActors();
        actorsInMovie.add(actor);
        movie.setActors(actorsInMovie);
		
	}

	/**
     * CRUD ==> create
     */
	public void addActor(Person actor) {
		instanceCounterActors++;
        counterActors = instanceCounterActors;

        actor.setId(counterActors);
        persons.put(counterActors, actor);		
	}

	/**
     * CRUD ==> read
     */
	public Person getActorById(int id) {
		return persons.get(id);
		
	}

	/**
     * CRUD ==> update
     */
	public void updateActor(Person actor) {
		persons.put(actor.getId(),actor);
	}


	/**
     * CRUD ==> delete
     */
	public void deleteActor(int id) {
		persons.remove(id);
	}

	

	
}
