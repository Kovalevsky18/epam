package test;

import model.User;
import page.MainPage;
import service.UserCreator;
import static util.StringUtils.ERROR_MESSAGE;

public class incorrectSignIn extends CommonConditions {
    @Test
    public void oneCanLoginGithub()
    {
        User testUser = UserCreator.withEmptyData();
        String loggedInUserName = new MainPage(driver)
                .openPage()
                .signIn(testUser)
                .getErrorLogin();
        assertThat(loggedInUserName, is(equalTo(ERROR_MESSAGE)));
    }


}
