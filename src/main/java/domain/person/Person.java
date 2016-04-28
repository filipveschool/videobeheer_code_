package domain.person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import domain.DomainException;
import domain.Movie;

import static org.joda.time.LocalDate.now;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotNull
	@Size(min = 1, max = 40)
	private String name;

	@NotNull
	@Size(min = 1, max = 40)
	private String familyName;

	@Enumerated(EnumType.STRING)
	private GenderPerson gender;

	private int dagGeboorte;

	@OneToMany
	private List<Movie> moviesPlayedIn;

	/*
	 * @DateTimeFormat (pattern="dd/MM/yyyy") private LocalDate dob;
	 * 
	 * public LocalDate getDob(){ return dob; }
	 * 
	 * public void setDob(LocalDate dob){ this.dob = dob; }
	 */
/*
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	*/

	public int getDagGeboorte() {
		return dagGeboorte;
	}

	public void setDagGeboorte(int dagGeboorte) {
		this.dagGeboorte = dagGeboorte;
	}

	public int getMaandGeboorte() {
		return maandGeboorte;
	}

	public void setMaandGeboorte(int maandGeboorte) {
		this.maandGeboorte = maandGeboorte;
	}

	public int getJaarGeboorte() {
		return jaarGeboorte;
	}

	public void setJaarGeboorte(int jaarGeboorte) {
		this.jaarGeboorte = jaarGeboorte;
	}

	private int maandGeboorte;
	private int jaarGeboorte;

	public Person() {
		this.moviesPlayedIn = new ArrayList<Movie>();
	}

	/*
	 * public Person(String name, String familyName, Age dateOfBirth,
	 * GenderPerson gender) { setName(name); setFamilyName(familyName);
	 * setDateOfBirth(dateOfBirth); setGender(gender); }
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String zetGeboorteDatumOmNaarTekst(int dagGeboorte, int maandGeboorte, int jaarGeboorte) {
		String dagString = String.valueOf(dagGeboorte);
		String maandString = String.valueOf(maandGeboorte);
		String jaarString = String.valueOf(jaarGeboorte);

		return dagString + "/" + maandString + "/" + jaarString;
	}

	public String zetGeboorteDatumOmNaarTekst() {
		String dagString = String.valueOf(getDagGeboorte());
		String maandString = String.valueOf(getMaandGeboorte());
		String jaarString = String.valueOf(getJaarGeboorte());

		return dagString + "/" + maandString + "/" + jaarString;
	}

	/*
	 * public Age getDateOfBirth() { return dateOfBirth; }
	 * 
	 * public void setDateOfBirth(int dagGeboorte, int maandGeboorte, int
	 * jaarGeboorte) { Age age = new Age(dagGeboorte, maandGeboorte,
	 * jaarGeboorte); this.dateOfBirth = age; }
	 */

	public String getName() {
		return name;
	}

	public void setName(String name) {

		if (name == null) {
			throw new DomainException("Name cannot be empty");
		}
		this.name = name;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {

		if (familyName == null) {
			throw new DomainException("familyname cannot be empty");
		}
		this.familyName = familyName;
	}

	public GenderPerson getGender() {
		return gender;
	}

	public void setGender(GenderPerson gender) {

		if (gender == null) {
			throw new DomainException("gender cannot be empty");
		}
		this.gender = gender;
	}

	public int berekenAantalJaarOud() {
		// return getDateOfBirth().berekenLeeftijd();
		return 0;
	}

	public int berekenLeeftijd() {
		int leeftijd = 0;
		org.joda.time.LocalDate dateNow = now();

		// als de huidige maand vb. 5 > geboortemaand vb. 4, dan ben je al een
		// jaar ouder geworden
		if (dateNow.getMonthOfYear() > getMaandGeboorte()) {
			leeftijd = dateNow.getYear() - getJaarGeboorte();
		}
		// als de huidige maand vb. 5 < geboortemaand vb. 6, dan ben je nog niet
		// verjaard.
		else if (dateNow.getMonthOfYear() < getMaandGeboorte()) {
			leeftijd = dateNow.getYear() - getJaarGeboorte() - 1;
		} else if (dateNow.getMonthOfYear() == getMaandGeboorte()) {
			// als het dezelfde maand is.
			// vb. vandaag is het 4 april
			if (dateNow.getDayOfMonth() == getDagGeboorte()) {
				leeftijd = dateNow.getYear() - getJaarGeboorte();
				// 4 < 6
			} else if (dateNow.getDayOfMonth() < getDagGeboorte()) {
				leeftijd = dateNow.getYear() - getJaarGeboorte() - 1;
			} else if (dateNow.getDayOfMonth() > getDagGeboorte()) {
				leeftijd = dateNow.getYear() - getJaarGeboorte();
			}
		}
		return leeftijd;
	}

	public int getJaarGeboorteUitStringGeconverteerd(String geboorteDatumConverteren) {

		String[] output = geboorteDatumConverteren.split("/");
		// int dagInt = Integer.parseInt(geboorteDatumConverteren.split("/"));

		return Integer.parseInt(output[0]);
	}

	public int getMaandGeboorteUitStringGeconverteerd(String geboorteDatumConverteren) {
		String[] output = geboorteDatumConverteren.split("/");
		// int dagInt = Integer.parseInt(geboorteDatumConverteren.split("/"));

		return Integer.parseInt(output[1]);
	}

	public int getDagGeboorteUitStringGeconverteerd(String geboorteDatumConverteren) {
		String[] output = geboorteDatumConverteren.split("/");
		// int dagInt = Integer.parseInt(geboorteDatumConverteren.split("/"));

		return Integer.parseInt(output[2]);
	}

	public List<Movie> getMoviesPlayedIn() {
		return moviesPlayedIn;
	}

	public void setMoviesPlayedIn(List<Movie> moviesPlayedIn) {
		this.moviesPlayedIn = moviesPlayedIn;
	}

	public void addMoviePlayedIn(Movie movie) {
		List<Movie> movies = getMoviesPlayedIn();
		movies.add(movie);
		setMoviesPlayedIn(movies);
	}

}
