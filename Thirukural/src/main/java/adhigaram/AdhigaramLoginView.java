package adhigaram;

import dto.Thirukural;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AdhigaramLoginView implements adhigaramLoginViewCallBack {
    private Scanner sc = new Scanner(System.in);
    private adhigaramControllerCallBack controllerObj;

    public AdhigaramLoginView() {
        controllerObj = new AdhigaramController(this);
    }


    public void searchByAdhigaram() throws IOException, ParseException {
        System.out.println("அதிகாரம் வாரியான தேடலை தேர்ந்தெடுத்துள்ளீர்கள்");
        System.out.println("அதிகாரம் எண்ணை(1-133) உள்ளிடவும்");
        int num = sc.nextInt();
        int start = (num * 10) - 9;
        System.out.println(start);
        List<Thirukural> list = controllerObj.searchByAdhigaram(start);
        System.out.println(list.size());
        for (int i = 0; i < 10; i++) {
            System.out.println("அதிகாரம் " + list.get(i).getAdikaram_name());
            System.out.println("Adhigaram Translitertion " + list.get(i).getAdikaram_transliteration());
            System.out.println("Athigaram Translation " + list.get(i).getTranslation());
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("குறள் எண் " + list.get(i).getNumber());
            System.out.println(" " + list.get(i).getLine1());
            System.out.println(" " + list.get(i).getLine2());
            System.out.println("----------------------------------------------");
            System.out.println("தமிழ் விளக்கம்: " + list.get(i).getMv());
            System.out.println("\nEnglish Translation: " + list.get(i).getTranslation());
            System.out.println("-----------------------------------------------------------------------------------------------");
        }

    }
}
