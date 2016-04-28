package domain.factory;


import db.video.VideoBeheerDBFake;
import db.video.VideoBeheerRelationalDatabase;
import db.video.VideoStorageConnectionInterface;

public class DatabaseFactoryVideo {

	static VideoStorageConnectionInterface videoBeheerDbFake;
	static VideoStorageConnectionInterface videoBeheerRelationalDB;

	public static VideoStorageConnectionInterface create(DatabaseType type) {
		if (type == DatabaseType.FAKE) {
			return new VideoBeheerDBFake();
		} else if (type == DatabaseType.RELATIONAL) {
			return new VideoBeheerRelationalDatabase();
		}

		return null;
	}

}
