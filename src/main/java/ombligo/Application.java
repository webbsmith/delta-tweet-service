package ombligo;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/delta-tweet")
@CrossOrigin
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired @Setter
    private AirportService airportService;

    @RequestMapping("/airports")
    public String airportList() {
        return airportService.getAll();
    }


    @RequestMapping("/{airportCode}/tweets")
    public String tweetList(@PathVariable(value = "airportCode") String airportCode) {
        return airportService.getTweets(airportCode);
    }
}
