package tests.api;

import org.testng.asserts.SoftAssert;
import utils.PropertyReader;

public class BaseApiTest {

    protected String user = System.getProperty("user", PropertyReader.getProperty("user"));
    protected String password = System.getProperty("password", PropertyReader.getProperty("password"));
    protected SoftAssert softAssert = new SoftAssert();
}