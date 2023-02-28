package welcome;

import dto.Thirukural;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class WelcomeController implements welcomeControllerCallBack, welcomeModelCallBack {
    private welcomeLoginViewCallBack viewObj;
    private welcomeModelCallBack modelObj;

    public WelcomeController(welcomeLoginViewCallBack viewObj) {
        this.viewObj = viewObj;
        modelObj = new WelcomeModel(this);
    }

    public void decideOptions(int option) throws IOException, ParseException {
        switch (option) {
            case 1:
                viewObj.getThirukuralByNumber();
                break;

            case 2:
                viewObj.getThirukuralCategory();
                break;

            case 3:
                viewObj.generateThirukuralOfTheDay();
                break;
        }
    }

    public Thirukural searchThirukuralByNumber(int num) {
        return modelObj.searchThirukuralByNumber(num);
    }
}
