package welcome;

import adhigaram.AdhigaramLoginView;
import dto.Thirukural;
import org.json.simple.parser.ParseException;
import searchThirukural.SearchThirukuralLoginView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class WelcomeLoginView implements welcomeLoginViewCallBack {
    private Scanner sc = new Scanner(System.in);
    private welcomeControllerCallBack controllerObj;


    public WelcomeLoginView() {
        controllerObj = new WelcomeController(this);
    }

    public static void main(String[] args) throws IOException, ParseException {
        WelcomeLoginView welcomeLoginView = new WelcomeLoginView();
        welcomeLoginView.welcome();
    }

    public void welcome() throws IOException, ParseException {
        System.out.println("1) திருக்குறளைத் எண் வாரியாக தேட 1ஐ அழுத்தவும்");
        System.out.println("2) திருக்குறள் அதிகாரங்கள் வாரியாக பார்க்க 2ஐ அழுத்தவும்");
        System.out.println("3) அன்றைய திருக்குறள் பார்க்க");
        int option = sc.nextInt();
        controllerObj.decideOptions(option);
    }

    public void getThirukuralByNumber() {
        SearchThirukuralLoginView searchThirukuralLoginView = new SearchThirukuralLoginView();
        searchThirukuralLoginView.searchThirukuralByNumber();
    }

    public void getThirukuralCategory() throws IOException, ParseException {
        AdhigaramLoginView adhigaramLoginView = new AdhigaramLoginView();
        adhigaramLoginView.searchByAdhigaram();


    }

    public void generateThirukuralOfTheDay() {
        Random random = new Random();
        // Generates random integers 0 to 1330
        int x = random.nextInt(1330);
        List<Integer> generatedNum = new ArrayList<>();
        if (!generatedNum.contains(x)) {
            generatedNum.add(x);

            Thirukural obj = controllerObj.searchThirukuralByNumber(x);
            System.out.println("இன்றைய திருக்குறள்");
            System.out.println("குறள் எண் " + obj.getNumber());
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println(" " + obj.getLine1());
            System.out.println(" " + obj.getLine2());
            System.out.println("----------------------------------------------");
            System.out.println("தமிழ் விளக்கம்: " + obj.getMv());
            System.out.println("\nEnglish Translation: " + obj.getTranslation());
        }


    }

}
