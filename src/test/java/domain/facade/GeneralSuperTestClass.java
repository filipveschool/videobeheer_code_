package domain.facade;

import domain.Movie;
import domain.factory.DatabaseType;
import domain.person.GenderPerson;
import domain.person.Person;
import helperclasses.MovieEvaluation;
import helperclasses.MovieGenre;
import helperclasses.MovieRating;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;

import java.util.List;

/**
 * Created by filip on 5/27/2016.
 */
public class GeneralSuperTestClass extends TestCase {


    private String title1, title2;
    private String director1, director2;
    private int year1, year2;
    private MovieGenre genre1, genre2;
    private MovieRating rating1, rating2;
    private MovieEvaluation evaluation1, evaluation2;
    private boolean seen1, seen2;
    private VideoBeheer vdb;
    private PersonBeheer pdb;
    private Movie movie1, movie2;
    private Person actor1, actor2;

    @Before
    public void setUp() throws Exception {

        title1 = "The hobbit 1";
        director1 = "Peter Jackson";
        year1 = 2012;
        genre1 = MovieGenre.ACTION;
        rating1 = MovieRating.GENERALAUDIENCE;
        evaluation1 = MovieEvaluation.THREESTARS;
        seen1 = true;

        movie1 = new Movie(title1, director1, year1, genre1, rating1, evaluation1, seen1);
        movie1.setId(1);

        title2 = "The hobbit 2";
        director2 = "Peter Jackson";
        year2 = 2013;
        genre2 = MovieGenre.COMEDY;
        rating2 = MovieRating.NCSEVENTEEN;
        evaluation2 = MovieEvaluation.FIVESTARS;
        seen2 = false;

        movie2 = new Movie(title2, director2, year2, genre2, rating2, evaluation2, seen2);
        movie2.setId(2);

        actor1 = new Person();
        actor1.setName("Ian");
        actor1.setFamilyName("Mc Kellen");
        actor1.setDagGeboorte(20);
        actor1.setMaandGeboorte(4);
        actor1.setJaarGeboorte(1994);
        actor1.setGender(GenderPerson.MALE);
        actor1.setId(1);

        actor2 = new Person();
        actor2.setName("Martin");
        actor2.setFamilyName("Freeman");
        actor2.setDagGeboorte(20);
        actor2.setMaandGeboorte(5);
        actor2.setJaarGeboorte(1995);
        actor2.setGender(GenderPerson.MALE);
        actor2.setId(2);

        vdb = new VideoBeheer(DatabaseType.FAKE);

        pdb = new PersonBeheer(DatabaseType.FAKE);

    }

    public GeneralSuperTestClass() {

    }


    public void addMovieTestKlasse() {
        vdb.addMovie(movie1);
    }

    public void add2MoviesTestKlasse() {
        vdb.addMovie(movie1);
        vdb.addMovie(movie2);
    }

    public void add1PersonTestKlasse(){
        pdb.addActor(actor1);
    }

    public void add2PersonsTestKlasse(){
        pdb.addActor(actor1);
        pdb.addActor(actor2);
    }

    // <?> zorgt ervoor dat je eender welk type van lijst kan meegeven
    // http://stackoverflow.com/questions/11392380/generics-what-does-actually-mean
    public void printResultaatLijst(List<?> lijst) {
        for (int i = 0; i < lijst.size(); i++) {
            System.out.println(lijst.get(i));
        }
    }


    @After
    public void tearDown() throws Exception {

    }

    public VideoBeheer getVdb() {
        return vdb;
    }

    public void setVdb(VideoBeheer vdb) {
        this.vdb = vdb;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public String getDirector1() {
        return director1;
    }

    public void setDirector1(String director1) {
        this.director1 = director1;
    }

    public String getDirector2() {
        return director2;
    }

    public void setDirector2(String director2) {
        this.director2 = director2;
    }

    public int getYear1() {
        return year1;
    }

    public void setYear1(int year1) {
        this.year1 = year1;
    }

    public int getYear2() {
        return year2;
    }

    public void setYear2(int year2) {
        this.year2 = year2;
    }

    public MovieGenre getGenre1() {
        return genre1;
    }

    public void setGenre1(MovieGenre genre1) {
        this.genre1 = genre1;
    }

    public MovieGenre getGenre2() {
        return genre2;
    }

    public void setGenre2(MovieGenre genre2) {
        this.genre2 = genre2;
    }

    public MovieRating getRating1() {
        return rating1;
    }

    public void setRating1(MovieRating rating1) {
        this.rating1 = rating1;
    }

    public MovieRating getRating2() {
        return rating2;
    }

    public void setRating2(MovieRating rating2) {
        this.rating2 = rating2;
    }

    public MovieEvaluation getEvaluation1() {
        return evaluation1;
    }

    public void setEvaluation1(MovieEvaluation evaluation1) {
        this.evaluation1 = evaluation1;
    }

    public MovieEvaluation getEvaluation2() {
        return evaluation2;
    }

    public void setEvaluation2(MovieEvaluation evaluation2) {
        this.evaluation2 = evaluation2;
    }

    public boolean isSeen1() {
        return seen1;
    }

    public void setSeen1(boolean seen1) {
        this.seen1 = seen1;
    }

    public boolean isSeen2() {
        return seen2;
    }

    public void setSeen2(boolean seen2) {
        this.seen2 = seen2;
    }

    public PersonBeheer getPdb() {
        return pdb;
    }

    public void setPdb(PersonBeheer pdb) {
        this.pdb = pdb;
    }

    public Movie getMovie1() {
        return movie1;
    }

    public void setMovie1(Movie movie1) {
        this.movie1 = movie1;
    }

    public Movie getMovie2() {
        return movie2;
    }

    public void setMovie2(Movie movie2) {
        this.movie2 = movie2;
    }

    public Person getActor1() {
        return actor1;
    }

    public void setActor1(Person actor1) {
        this.actor1 = actor1;
    }

    public Person getActor2() {
        return actor2;
    }

    public void setActor2(Person actor2) {
        this.actor2 = actor2;
    }

}
