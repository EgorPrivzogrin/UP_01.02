import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest implements Steps{
    @BeforeSuite
    public static void bfSuite(){
        System.out.println("CarTests");
    }

    @AfterSuite
    public static void afSuite(){
        System.out.println("CarTests Complete");
    }
}
