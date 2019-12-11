package test;

import model.User;
import org.testng.annotations.Test;
import page.MainPage;
import service.UserCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static util.StringUtils.*;

public class ChangeCurrencyTest {
    @Test
    public void correctSignIn()
    {
        String changeCurrencyData = new MainPage(driver)
                .openPage()
                .changeCurrency()
                .getCurrency();
                assertThat(changeCurrencyData(equalTo(CHANGED_CURRENCY)));
    }
}

