package adhigaram;

import dto.Thirukural;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

public interface adhigaramControllerCallBack {
    List<Thirukural> searchByAdhigaram(int start) throws IOException, ParseException;
}
