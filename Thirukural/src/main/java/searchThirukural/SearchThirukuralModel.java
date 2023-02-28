package searchThirukural;

import dto.Thirukural;
import repository.ThirukuralRepository;

public class SearchThirukuralModel implements searchThirukuralModelCallBack {
    private searchThirukuralcontrollerCallBack controllerObj;

    public SearchThirukuralModel(SearchThirukuralController controllerObj) {
        this.controllerObj = controllerObj;
    }

    public Thirukural searchThirukuralByNumber(int number) {
        return ThirukuralRepository.getInstance().searchThirukuralByNumber(number);
    }


}
