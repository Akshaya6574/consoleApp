package welcome;

import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface welcomeLoginViewCallBack {
    void getThirukuralByNumber();

    void getThirukuralCategory() throws IOException, ParseException;

    void generateThirukuralOfTheDay();
}
