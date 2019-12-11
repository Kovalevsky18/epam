package test;

import model.User;
import org.testng.annotations.Test;
import page.MainPage;
import service.UserCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static util.StringUtils.ERROR_MESSAGE_WITH_DATA;

public class SignInWithoutLogin {
    @Test
    public void incorrectSignInWithoutPassword()
    {
        User testUser = UserCreator.withCredentialsFromProperty();
        String loggedInUserName = new MainPage(driver)
                .openPage()
                .signIn(testUser)
                .getErrorPassword();
        assertThat(loggedInUserName, is(equalTo(ERROR_MESSAGE)));
    }
}
