package test;

import model.User;
import page.MainPage;
import service.UserCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static util.StringUtils.ERROR_MESSAGE;
import static util.StringUtils.ERROR_SEARCH_MESSAGE;

public class SearchCityWithoutCondition {
    @Test
    public void searchCityWithoutCondtition()
    {
        String errorMsg = new MainPage(driver)
                .openPage()
                .searchHotelsWithoutData()
                .getErrorMsgInSearchLabel();
        assertThat(errorMsg, is(equalTo(ERROR_SEARCH_MESSAGE)));
    }
}
