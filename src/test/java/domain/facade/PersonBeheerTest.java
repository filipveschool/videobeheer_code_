package domain.facade;

import domain.person.Person;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotEquals;

/**
 * Created by filip on 5/27/2016.
 */
public class PersonBeheerTest extends GeneralSuperTestClass {

    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void test_get_all_actors_list() throws Exception{

        add1PersonTestKlasse();

        List<Person> personList = super.getPdb().getAllActors();

        printResultaatLijst(personList);

        assertEquals(1, personList.size());
    }

    @Test
    public void test_add_actor() throws Exception{
        add1PersonTestKlasse();
        assertEquals(1,getPdb().getAllActors().size());
    }

    @Test
    public void test_get_actor_met_parameters_naam_en_voornaam() throws Exception{
        add1PersonTestKlasse();

        assertEquals("Ian",getPdb().getActorById(getActor1().getId()).getName());
        assertEquals("Mc Kellen",getPdb().getActorById(getActor1().getId()).getFamilyName());
    }

    @Test
    public void test_update_actor() throws Exception{
        add1PersonTestKlasse();
        Person person3 = getActor1();
        person3.setJaarGeboorte(1989);
        getPdb().updateActor(person3);
        List<Person> personList = getPdb().getAllActors();
        printResultaatLijst(personList);

        assertEquals(1989, getPdb().getAllActors().get(0).getJaarGeboorte());
    }

    @Test
    public void test_delete_actor() throws Exception{
        add2PersonsTestKlasse();
        getPdb().deleteActor(getActor1().getId());
        List<Person> personList = getPdb().getAllActors();
        printResultaatLijst(personList);

        assertNotEquals(1,getPdb().getAllActors().get(0).getId());
    }

}
