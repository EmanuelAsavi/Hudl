package hudl.pages;
import org.openqa.selenium.support.PageFactory;
import hudl.utilities.Driver;

public abstract class BasePage {
    protected BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

}

