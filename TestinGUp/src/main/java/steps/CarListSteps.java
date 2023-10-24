package steps;

import io.qameta.allure.Step;
import models.Car;
import org.testng.Assert;
import util.GeneratorBImBam;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarListSteps {
    @Step
    public void checkCarListLength(List<Car> carList){
        Assert.assertEquals(carList.size(),7, "В списке не хватате машин");
    }

    @Step
    public Car getCar(List<Car> carList, String stateNumber){
        for (Car car: carList) {
            if (car.getStateNumber().equals(stateNumber)) return car;
        }
        return null;
    }

    @Step
    public void checkCarIsValid(Car car){
        Pattern pattern = Pattern.compile("[АВЕКМНОРСТУХ]\\d{3}[АВЕКМНОРСТУХ]{2}");
        Matcher matcher = pattern.matcher(car.getStateNumber());
        Assert.assertTrue(matcher.find());
        Assert.assertTrue(GeneratorBImBam.carModels.contains(car.getMark()));
    }
}
