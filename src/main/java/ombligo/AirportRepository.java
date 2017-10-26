package ombligo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Set;

@AllArgsConstructor
@Service
public class AirportRepository {
    private final RedisService redisService;


    public String get() {
        return redisService.get("airports");
    }

    public String getTweets(String airportCode) {
        Set<String> set = redisService.getMembers("airport::" + airportCode + "::tweets");
        if (set.isEmpty()) return "[]";

        StringBuilder sb = new StringBuilder("[");
        Iterator<String> iterator = set.iterator();
        String current = null;
        for (; iterator.hasNext(); ) {
            current = iterator.next();
            if (!iterator.hasNext()) break; // last one

            sb.append(current).append(",");
        }
        sb.append(current).append("]"); // add last one (no comma)
        return sb.toString();
    }
}
