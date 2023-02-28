package searchThirukural;

import dto.Thirukural;

public class SearchThirukuralController implements searchThirukuralcontrollerCallBack {
    private searchThirukuralLoginViewCallBack viewObj;
    private searchThirukuralModelCallBack modelObj;


    public SearchThirukuralController(searchThirukuralLoginViewCallBack viewObj) {
        this.viewObj = viewObj;
        modelObj = new SearchThirukuralModel(this);
    }

    public Thirukural searchThirukuralByNumber(int num) {
        return modelObj.searchThirukuralByNumber(num);
    }
}
