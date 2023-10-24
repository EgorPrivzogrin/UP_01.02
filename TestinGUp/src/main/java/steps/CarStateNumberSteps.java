package steps;

import io.qameta.allure.Step;
import org.testng.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarStateNumberSteps{

    @Step
    public void checkStateNumberDopChars(String stateNumber){
        Assert.assertTrue(stateNumber.contains("А") || stateNumber.contains("В")
                || stateNumber.contains("Е") || stateNumber.contains("К")
                || stateNumber.contains("М") || stateNumber.contains("Н")
                || stateNumber.contains("О") || stateNumber.contains("Р")
                || stateNumber.contains("С") || stateNumber.contains("Т")
                || stateNumber.contains("У") || stateNumber.contains("Х"));
    }

    @Step
    public void checkStateNumberLength(String stateNumber){
        Assert.assertEquals(stateNumber.length(), 6, "Длинна номера неверная");
    }

    @Step
    public void checkStateNumberAtTemplate(String stateNumber){
        Pattern pattern = Pattern.compile("[АВЕКМНОРСТУХ]\\d{3}[АВЕКМНОРСТУХ]{2}");
        Matcher matcher = pattern.matcher(stateNumber);
        Assert.assertTrue(matcher.find());
    }
}
