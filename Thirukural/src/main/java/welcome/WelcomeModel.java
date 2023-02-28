package welcome;

import dto.Thirukural;
import repository.ThirukuralRepository;

public class WelcomeModel implements welcomeModelCallBack {
    private welcomeControllerCallBack controllerObj;

    public WelcomeModel(welcomeControllerCallBack controllerObj) {
        this.controllerObj = controllerObj;
    }

    public Thirukural searchThirukuralByNumber(int number) {
        return ThirukuralRepository.getInstance().searchThirukuralByNumber(number);
    }
}
