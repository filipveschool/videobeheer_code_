package restful;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by filip on 5/25/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TheMVDB {

    private int runtime;
    private int budget;
    private String imdb_id;
    private String release_date;
    private String title;

    public TheMVDB(){

    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    @Override
    public String toString() {
        return "title : " + getTitle() + " - gereleased op : " + getRelease_date() + " - met IMDB_ID : " + getImdb_id()
                + " - duurt : " + getRuntime() + " minuten - had als budget : " + getBudget() + " dollar.";
    }
}
