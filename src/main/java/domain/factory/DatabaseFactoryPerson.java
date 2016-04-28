package domain.factory;

import db.person.PersonBeheerDbFake;
import db.person.PersonBeheerRelationalDatabase;
import db.person.PersonStorageConnectionInterface;

public class DatabaseFactoryPerson {

	static PersonStorageConnectionInterface personBeheerDbFake;
	static PersonStorageConnectionInterface personBeheerDbRelational;

	public static PersonStorageConnectionInterface create(DatabaseType type){
        if(type == DatabaseType.FAKE){
            return new PersonBeheerDbFake();
        }
        else if(type == DatabaseType.RELATIONAL){
        	return new PersonBeheerRelationalDatabase();
        }

        return null;
    }
}
