package welcome;

import dto.Thirukural;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface welcomeControllerCallBack {
    void decideOptions(int option) throws IOException, ParseException;

    Thirukural searchThirukuralByNumber(int x);
}
