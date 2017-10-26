package ombligo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class AirportService {

    private final AirportRepository airportRepository;

    public String getAll() {
        return airportRepository.get();
//        return Collections.singletonList(Airport.builder()
//                .city("Atlanta")
//                .code("ATL")
//                .latitude("4")
//                .longitude("3")
//                .name("Hartsfield")
//                .build());
    }

    public String getTweets(String airportCode) {
        return airportRepository.getTweets(airportCode);
    }
}
