package geo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GeoServiceImplTest {
    final static String LOCALHOST = "127.0.0.1";
    final static String MOSCOW_IP = "172.0.32.11";
    final static String NEW_YORK_IP = "96.44.183.149";

    @MethodSource("methodSource")
    @ParameterizedTest
    void parameterizedByIpTest(String ip, Location expected) {
        GeoServiceImpl geoServiceImpl = new GeoServiceImpl();
        Location result = geoServiceImpl.byIp(ip);
        assertEquals(result.getCountry(), expected.getCountry());
        assertEquals(result.getCity(), expected.getCity());
        assertEquals(result.getStreet(), expected.getStreet());
        assertEquals(result.getBuiling(), expected.getBuiling());
    }

    public static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(LOCALHOST, new Location(null, null, null, 0)),
                Arguments.of(MOSCOW_IP, new Location("Moscow", Country.RUSSIA, "Lenina", 15)),
                Arguments.of(NEW_YORK_IP, new Location("New York", Country.USA, " 10th Avenue", 32)));
    }
}