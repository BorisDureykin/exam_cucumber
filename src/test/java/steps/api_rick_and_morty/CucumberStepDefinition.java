package steps.api_rick_and_morty;

import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.restassured.specification.RequestSpecification;
import steps.api_request_respone.RequestSpecificationAllTests;

import static hooks.Hooks.saveMessage;
import static steps.api_rick_and_morty.GetEpisode.getEpisode;
import static util.Config.getConfigValue;

public class CucumberStepDefinition extends RequestSpecificationAllTests {

    private static RequestSpecification request;
    private static GetCharacter getCharacter1;
    private static GetCharacter getCharacter2;
    private static String lastEpisodeNumber;
    private static String characterId2;


    @Когда("Получаем на сайте {string} характеристики персонажа с ID: {string}")
    public static void getDataCharacter1(String keyUrl, String characterId){
        request = requestSpecificationAllTests(getConfigValue(keyUrl));
        getCharacter1 = GetCharacter.getCharacter(characterId, request);
    }

    @Тогда("Получаем номер последнего эпизода")
    public static void getLastEpisodeNumber(){

        lastEpisodeNumber = getCharacter1.getLastEpisodeNumber();

        String message = "Номер последнего эпизода где появлялся персонаж: "+lastEpisodeNumber;

        saveMessage("Номер последнего эпизода" ,message);
    }

    @Тогда("Получаем номер номер последнего персонажа в эпизоде")
    public static void getLastCharacterId() {

        characterId2 = getEpisode(lastEpisodeNumber, request);

        String message = "В эпизоде ID: "+ lastEpisodeNumber + " последний персонаж c ID: "+ characterId2;

        saveMessage("Номер последнего персонажа в эпизоде "+lastEpisodeNumber ,message);
    }

    @Затем("Получаем характеристики 2 персонажа")
    public static void getDataCharacter2(){

        getCharacter2 = GetCharacter.getCharacter(characterId2, request);
    }

    @И("Сравниваем Характеристики персонажей")
    public static void comparingCharacters() {

        String species = getCharacter1.getSpecies();

        String location = getCharacter1.getLocation();

        String species2 = getCharacter2.getSpecies();

        String location2 = getCharacter2.getLocation();

        String message = species.equals(species2) ? "Принадлежат к одной расе: " + species : "Расы разные: " + species + " и " + species2;

        saveMessage("Принадлежность к расам" ,message);

        message = location.equals(location2) ? "Находятся в одной локации: " + location : "Локации разные: " + location + " и " + location2;

        saveMessage("Локации персонажей" ,message);
    }
}
