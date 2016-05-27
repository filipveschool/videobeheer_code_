package domain.facade;

import domain.Movie;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotEquals;

/**
 * Created by filip on 5/27/2016.
 */
public class VideoBeheerTest extends GeneralSuperTestClass {


    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void test_get_all_movies_list() throws Exception {
        addMovieTestKlasse();

        List<Movie> movieList = super.getVdb().getAllMovies();

        printResultaatLijst(movieList);

        assertEquals(1,movieList.size());
    }

    @Test
    public void test_add_movie() throws Exception{
        addMovieTestKlasse();
        assertEquals(1,getVdb().getAllMovies().size());
    }

    @Test
    public void test_get_movie_met_parameters_title_en_jaar() throws Exception {
        addMovieTestKlasse();
        assertEquals(getTitle1(),getVdb().getMovieById(getMovie1().getId()).getTitle());
        assertEquals(getYear1(),getVdb().getMovieById(getMovie1().getId()).getJaar());
    }

    @Test
    public void test_update_movie() throws Exception {
        addMovieTestKlasse();
        Movie movie2 = getMovie1();
        movie2.setJaar(1993);
        getVdb().updateMovie(movie2);
        List<Movie> movieList = getVdb().getAllMovies();
        printResultaatLijst(movieList);

        assertEquals(1993, getVdb().getAllMovies().get(0).getJaar());

    }


    @Test
    public void test_delete_movie() throws Exception{
        add2MoviesTestKlasse();
        getVdb().deleteMovieById(getMovie1().getId());
        List<Movie> movieList = getVdb().getAllMovies();
        printResultaatLijst(movieList);

        assertNotEquals(1,getVdb().getAllMovies().get(0).getId());
    }






    }
