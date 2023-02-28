package adhigaram;

import dto.Thirukural;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

public class AdhigaramController implements adhigaramControllerCallBack,adhigaramModelCallBack{
    private adhigaramLoginViewCallBack viewObj;
    private adhigaramModelCallBack modelObj;

    public AdhigaramController(adhigaramLoginViewCallBack viewObj) {
        this.viewObj = viewObj;
        modelObj = new AdhigaramModel(this);
    }
    public List<Thirukural> searchByAdhigaram(int start) throws IOException, ParseException {
        return modelObj.searchByAdhigaram(start);
    }
}
