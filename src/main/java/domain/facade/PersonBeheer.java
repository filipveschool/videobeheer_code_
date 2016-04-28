package domain.facade;

import java.util.List;

import db.person.PersonStorageConnectionInterface;
import domain.Movie;
import domain.factory.DatabaseFactoryPerson;
import domain.factory.DatabaseType;
import domain.person.Person;

public class PersonBeheer {

	private PersonStorageConnectionInterface personBeheerDb;
	private DatabaseFactoryPerson dbFactoryPerson;

	public PersonBeheer(DatabaseType dbType) {
		// personBeheerDb = DatabaseFactoryPerson.create(DatabaseType.FAKE);

		personBeheerDb = DatabaseFactoryPerson.create(dbType);
		setPersonBeheerDb(personBeheerDb);
	}

	public List<Person> getAllActorsFromOneMovie(int id) {
		return getPersonBeheerDb().getAllActorsFromOneMovie(id);
	}

	public List<Person> getAllActors() {
		return getPersonBeheerDb().getAllActors();
	}

	public void addActor(Person actor, Movie movie) {
		getPersonBeheerDb().addActor(actor, movie);
	}

	public void addActor(Person actor) {
		getPersonBeheerDb().addActor(actor);
	}

	public Person getActorById(int id) {
		return getPersonBeheerDb().getActorById(id);

	}

	public void updateActor(Person actor) {
		getPersonBeheerDb().updateActor(actor);
	}

	public void deleteActor(int id) {
		getPersonBeheerDb().deleteActor(id);
	}

	public PersonStorageConnectionInterface getPersonBeheerDb() {
		return personBeheerDb;
	}

	public void setPersonBeheerDb(PersonStorageConnectionInterface personBeheerDb) {
		this.personBeheerDb = personBeheerDb;
	}

	public DatabaseFactoryPerson getDbFactoryPerson() {
		return dbFactoryPerson;
	}

	public void setDbFactoryPerson(DatabaseFactoryPerson dbFactoryPerson) {
		this.dbFactoryPerson = dbFactoryPerson;
	}

}
