package domain.facade;

import java.util.List;

import db.video.VideoStorageConnectionInterface;
import domain.Movie;
import domain.factory.DatabaseFactoryVideo;
import domain.factory.DatabaseType;

public class VideoBeheer {

	private VideoStorageConnectionInterface videoBeheerDb;
	private DatabaseFactoryVideo dbFactory;

	public VideoBeheer(DatabaseType dbType) {

		// videoBeheerDb = DatabaseFactoryVideo.create(DatabaseType.FAKE);

		videoBeheerDb = DatabaseFactoryVideo.create(dbType);
setVideoBeheerDb(videoBeheerDb);
	}

	public List<Movie> getAllMovies() {
		return getVideoBeheerDb().getAllMovies();
	}

	public void addMovie(Movie movie) {

		getVideoBeheerDb().addMovie(movie);
	}

	public Movie getMovieById(int id) {
		return getVideoBeheerDb().getMovieById(id);
	}

	public void updateMovie(Movie movie) {
		getVideoBeheerDb().updateMovie(movie);
	}

	public void deleteMovieById(int id) {
		getVideoBeheerDb().deleteMovieById(id);
	}

	public VideoStorageConnectionInterface getVideoBeheerDb() {
		return videoBeheerDb;
	}

	public void setVideoBeheerDb(VideoStorageConnectionInterface videoBeheerDb) {
		this.videoBeheerDb = videoBeheerDb;
	}

	public DatabaseFactoryVideo getDbFactory() {
		return dbFactory;
	}

	public void setDbFactory(DatabaseFactoryVideo dbFactory) {
		this.dbFactory = dbFactory;
	}

}
