package test;

import model.User;
import page.MainPage;
import service.UserCreator;
import static util.StringUtils.ERROR_MESSAGE;

public class IncorrectSignIn extends CommonConditions {
    @Test
    public void incorrectSignIn()
    {
        User testUser = UserCreator.withEmptyData();
        String loggedInUserName = new MainPage(driver)
                .openPage()
                .signIn(testUser)
                .getErrorLogin();
        assertThat(loggedInUserName, is(equalTo(ERROR_MESSAGE)));
    }



}
