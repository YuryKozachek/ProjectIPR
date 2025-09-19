package tests.ui;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectsTest extends BaseTest {

    @Description("Смена языка на странице проектов mail.ru")
    @Test
    public void getEnProjectsPage() {

        projectsPage.open()
                .clickButtonEn();
        Assert.assertEquals("https://vk.company/en/projects/", projectsPage.getCurrentUrlProjectsPage(), "Не сошлось");
    }
}