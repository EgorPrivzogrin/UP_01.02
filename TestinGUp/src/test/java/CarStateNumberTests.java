import models.Car;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.GeneratorBImBam;

import java.time.LocalDate;

public class CarStateNumberTests extends BaseTest{

    public static Car car = new Car();
    @BeforeClass
    public static void generateCar(){
            car.setMark(GeneratorBImBam.generateMarkCar());
            car.setStateNumber(GeneratorBImBam.generateStateNumber());
            car.setDateOfCreate(LocalDate.now().toString());
    }

    @Test
    public static void checkCarStateNumberIsValid(){
        CAR_STATE_NUMBER_STEPS.checkStateNumberLength(car.getStateNumber());
        CAR_STATE_NUMBER_STEPS.checkStateNumberDopChars(car.getStateNumber());
        CAR_STATE_NUMBER_STEPS.checkStateNumberAtTemplate(car.getStateNumber());
    }
}
