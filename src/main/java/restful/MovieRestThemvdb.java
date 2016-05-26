package restful;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by filip on 5/25/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieRestThemvdb {



    private String Title;
    private String Runtime;

    public MovieRestThemvdb() {

    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }


    public String getRuntime() {
        return Runtime;
    }

    public void setRuntime(String runtime) {
        Runtime = runtime;
    }


    @Override
    public String toString() {
        return "Title{" + "Title='" + Title + '\'' + ", Runtime=" + Runtime + '}';
    }

}
