import steps.CarListSteps;
import steps.CarStateNumberSteps;
import steps.ReqresApiSteps;

public interface Steps {
    CarStateNumberSteps CAR_STATE_NUMBER_STEPS = new CarStateNumberSteps();
    CarListSteps CAR_LIST_STEPS = new CarListSteps();

    ReqresApiSteps REQRES_API_STEPS = new ReqresApiSteps();

}
