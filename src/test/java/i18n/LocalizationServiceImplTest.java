package i18n;

import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {

    @Test
    void localeRussiaTest() {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        String expected = localizationService.locale(Country.RUSSIA);
        assertEquals("Добро пожаловать", expected);
    }

    @Test
    void localeAnotherCountryTest() {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        String expected = localizationService.locale(Country.USA);
        assertEquals("Welcome", expected);
    }
}