import io.qameta.allure.Story;
import models.requestModel.JbRequest;
import models.requestModel.LogRequest;
import models.requestModel.RegRequest;
import models.responseModel.DataResponse;
import models.responseModel.SupResponse;
import models.responseModel.UserResponse;
import org.testng.annotations.Test;

public class ApiTests extends BaseTest{
    @Test(testName = "Список пользователей")
    public static void getUsersList() {
        REQRES_API_STEPS.getUsersList();
    }

    @Test(testName = "Пользователь по айди")
    public void getUserById() {
        REQRES_API_STEPS.getUserById(2);
    }

    @Test(testName = "Несуществующий пользователь")
    @Story("GET requests")
    public static void getNotExistUser() {
        REQRES_API_STEPS.getnoExUser(23);
    }

    @Test(testName = "Получение списка ресурсов")
    public static void getListResource() {
        REQRES_API_STEPS.getListResource();
    }

    @Test(testName = "Получение ресурса")
    public static void getSingleResource() {
        REQRES_API_STEPS.getSingleResource();
    }

    @Test(testName = "Получение несуществующего ресурса")
    public static void getNotExistResource() {
        REQRES_API_STEPS.getNotExistResource();
    }

    @Test(testName = "Создание пользователя")
    public void createUser() {
        JbRequest user = new JbRequest("morpheus", "leader");
        REQRES_API_STEPS.createUser(user);
    }

    @Test(testName = "Обновление пользователя")
    public static void putUpdateUser() {
        JbRequest user = new JbRequest("morpheus", "zion resident");
        REQRES_API_STEPS.updateUser(user);
    }

    @Test(testName = "Удаление пользователя")
    public static void deleteUser() {
        REQRES_API_STEPS.deleteUser();
    }

    @Test(testName = "Гуд регистрация пользователя")
    public static void registerSuccessful() {
        RegRequest regRequest = new RegRequest("eve.holt@reqres.in", "pistol");
        REQRES_API_STEPS.registerSuccessUser(regRequest);
    }

    @Test(testName = "Бэд регистрация пользователя")
    public static void registerUnSuccessful() {
        RegRequest regRequest = new RegRequest("eve.holt@reqres.in");
        REQRES_API_STEPS.registerUnSuccessUser(regRequest);
    }

    @Test(testName = "Гуд авторизация пользователя")
    public static void loginSuccessful() {
        LogRequest logRequest = new LogRequest("eve.holt@reqres.in", "cityslicka");
        REQRES_API_STEPS.loginSuccessUser(logRequest);
    }

    @Test(testName = "Бэд авторизация пользователя")
    public static void loginUnSuccessful() {
        LogRequest logRequest = new LogRequest("eve.holt@reqres.in");
        REQRES_API_STEPS.loginUnsuccessUser(logRequest);
    }

    @Test(testName = "Отложенный запрос")
    public static void getDelayedResp() {
        REQRES_API_STEPS.getDelayUserList();
    }
}
