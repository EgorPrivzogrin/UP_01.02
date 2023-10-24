import models.Car;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.GeneratorBImBam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CarListTests extends BaseTest{

    public static List<Car> carList = new ArrayList<>();
    @BeforeClass
    public static void generateCarList(){
        for (int i = 0; i < 7 ; i++) {
            Car car = new Car();
            car.setMark(GeneratorBImBam.generateMarkCar());
            car.setStateNumber(GeneratorBImBam.generateStateNumber());
            car.setDateOfCreate(LocalDate.now().toString());
            if(i == 2){
                car.setMark("Kia");
                car.setStateNumber("Р666УС");
                car.setDateOfCreate(LocalDate.now().toString());
            }
            carList.add(car);
        }
    }

    @Test
    public static void checkCarListOnPropAndExistingCar(){
        CAR_LIST_STEPS.checkCarListLength(carList);
        Car car = CAR_LIST_STEPS.getCar(carList, "Р666УС");
        CAR_LIST_STEPS.checkCarIsValid(car);
    }
}
