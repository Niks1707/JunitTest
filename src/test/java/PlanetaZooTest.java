import data.Catalog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PlanetaZooTest extends TestBase {

    @DisplayName("Поверка поискового запроса по кормам")
    @ValueSource(strings = {
            "Royal Canin", "GRANDORF", "Аллева Холистик"
    })
    @ParameterizedTest(name = "Поисковой запрос {0} должен отдавать не пустой список товаров")
    @Tag("SMOKE")
    void findFoodForPetsTest(String searchFood) {
       $(".j-block__search").$(".search-field").setValue(searchFood).pressEnter();
       $$(".j-goods__item.product-wrapper").shouldBe(sizeGreaterThan(0));
    }

    @DisplayName("Проверка соответствия поискового запроса названию корма")
    @CsvFileSource(resources = "/test_data/compareFoodForPetsTest.csv")
    @ParameterizedTest(name = "Поисковой запрос {0} должен соответствовать названию корма {1}")
    @Tag("SMOKE")
    void compareFoodForPetsTest(String searchFood, String expectedFood) {
        $(".j-block__search").$(".search-field").setValue(searchFood).pressEnter();
        $(".j-goods__item.product-wrapper").$(".j-goods__name").shouldHave(text(expectedFood));
    }

    @DisplayName("Проверка соответствия товаров на главной странице")
    @EnumSource(Catalog.class)
    @ParameterizedTest
    @Tag("SMOKE")
    void selenideSiteShouldDisplayCorrectText(Catalog catalog) {
        $(".j-block__catalog").shouldHave(text(catalog.name));
   }
}
