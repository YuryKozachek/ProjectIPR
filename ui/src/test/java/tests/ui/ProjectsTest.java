package tests.ui;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProjectsTest extends BaseUITest {

    @Description("Смена языка на странице проектов mail.ru")
    @Test
    public void getEnProjectsPage() {

        projectsPage.open()
                .clickButtonEn();
        assertEquals("https://vk.company/en/projects/", projectsPage.getCurrentUrlProjectsPage(), "Не сошлось");
    }
}