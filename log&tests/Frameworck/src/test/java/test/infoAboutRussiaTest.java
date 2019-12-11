package test;

import page.MainPage;

import static util.StringUtils.ERROR_SEARCH_MESSAGE;
import static util.StringUtils.INFO_ABOUT_RUSSIA_TEXT;

public class infoAboutRussiaTest {
    @Test
    public void searchCityWithoutCondtition()
    {
        String infoRussia = new MainPage(driver)
                .openPage()
                .infoAboutRussia()
                .getTextRelaxInRussia()
        assertThat(infoRussia, is(equalTo(INFO_ABOUT_RUSSIA_TEXT)));
    }
}
