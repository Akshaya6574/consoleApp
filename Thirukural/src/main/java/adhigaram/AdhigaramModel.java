package adhigaram;

import dto.Thirukural;
import org.json.simple.parser.ParseException;
import repository.ThirukuralRepository;

import java.io.IOException;
import java.util.List;

public class AdhigaramModel implements adhigaramModelCallBack {
    private adhigaramControllerCallBack controllerObj;


    public AdhigaramModel(adhigaramControllerCallBack controllerObj) {
        this.controllerObj = controllerObj;
    }

    public List<Thirukural> searchByAdhigaram(int start) throws IOException, ParseException {
        return ThirukuralRepository.getInstance().searchByAthigaram(start);
    }
}
