package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProjectsTest extends BaseTest {

    @DisplayName("Смена языка на странице проектов mail.ru")
    @Test
    public void getEnProjectsPage() {

        projectsPage.open()
                .clickButtonEn();
        Assertions.assertEquals("https://vk.company/en/projects/", projectsPage.getCurrentUrlProjectsPage());
    }
}