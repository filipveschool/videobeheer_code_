package db.person;

import java.util.List;

import db.DBException;
import domain.Movie;
import domain.person.Person;

public interface PersonStorageConnectionInterface {

    /**
     * @param id
     * @return
     */
    public List<Person> getAllActorsFromOneMovie(int id);

    public List<Person> getAllActors();

    /**
     * CRUD ==> create
     */

    /**
     * Voegt een acteur toe aan een film waarin hij meegespeeld heeft.
     *
     * @param actor
     * @param movie
     */
    public void addActor(Person actor, Movie movie);

    /**
     * Voegt een actor toe aan de collectie
     *
     * @param actor
     */
    public void addActor(Person actor);

    /**
     * CRUD ==> read
     */
    public Person getActorById(int id);


    public void updateActor(Person actor);

    /**
     * CRUD ==> delete
     */
    public void deleteActor(int id);

}
