package test;

import model.User;
import page.MainPage;
import service.UserCreator;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static util.StringUtils.ERROR_MESSAGE_WITH_DATA;

public class CorretSignIn extends CommonConditions {
    @Test
    public void correctSignIn()
    {
        User testUser = UserCreator.withCredentialsFromProperty();
        String loggedInUserName = new MainPage(driver)
                .openPage()
                .signIn(testUser)
                .getLoggedInUserName();
        assertThat(loggedInUserName, is(equalTo(ERROR_MESSAGE_WITH_DATA)));
    }

}
