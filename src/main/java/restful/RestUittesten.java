package restful;

import org.springframework.web.client.RestTemplate;

/**
 * Created by filip on 5/25/2016.
 */
public class RestUittesten {
    public static void main(String[] args) {

        RestTemplate restTemplate2 = new RestTemplate();
        String responseschool = restTemplate2.getForObject("https://maps.googleapis.com/maps/api/elevation/json?locations=40.714728,-73.998672", String.class);
        //System.out.println("Elevation: " + responseschool);

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("https://maps.googleapis.com/maps/api/geocode/json?&latlng=50.846476,4.017681", String.class);
        //System.out.println("elevation : " + response);

        String beginTheMovieDbApiAltijdZelfde = "https://api.themoviedb.org/3";

        String themoviedbApiKey = "?api_key=feb28e437be8a3b0b90f44da4bc93644";
        String themoviedbApiKeyMetParameters = "&api_key=feb28e437be8a3b0b90f44da4bc93644";
        String response2 = restTemplate.getForObject("https://api.themoviedb.org/3/movie/550?api_key=feb28e437be8a3b0b90f44da4bc93644", String.class);
        String response2Metparameters = restTemplate.getForObject(beginTheMovieDbApiAltijdZelfde + "/movie/49051" + themoviedbApiKey,
                String.class);

        TheMVDB themvdbclass = restTemplate.getForObject("https://api.themoviedb.org/3/movie/49051?api_key=feb28e437be8a3b0b90f44da4bc93644", TheMVDB.class);

        System.out.println("classmvdb = " + themvdbclass.getRuntime());
        System.out.println(themvdbclass.toString());

        //TheMVDB theMVDBclassimdb = restTemplate.getForObject("https://api.themoviedb.org/3/find/tt0903624?external_source=imdb_id&api_key=feb28e437be8a3b0b90f44da4bc93644",TheMVDB.class);
        //System.out.println(theMVDBclassimdb.toString());
    }

}
