package repository;

import dto.Thirukural;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ThirukuralRepository {
    private static ThirukuralRepository repository;
    List<Thirukural> adhigaramList =new ArrayList<>();


    public ThirukuralRepository() {

    }
    public static ThirukuralRepository getInstance()
    {
        if(repository==null)
        {
            repository=new ThirukuralRepository();
        }
        return repository;

    }

    public Thirukural searchThirukuralByNumber(int number) {
        try {
            JSONParser jsonparser = new JSONParser();

            FileReader reader = new FileReader("src/main/java/jsonFile/thirukkuralAdhigaram.json");
            Object obj = jsonparser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray) jsonObject.get("kural");
            JSONObject kuraljsonObject = (JSONObject) jsonArray.get(number);
            Long Number = (Long) kuraljsonObject.get("Number");
            String Line1 = (String) kuraljsonObject.get("Line1");
            String Line2 = (String) kuraljsonObject.get("Line2");
            String Translation = (String) kuraljsonObject.get("Translation");
            String mv = (String) kuraljsonObject.get("mv");
            String sp = (String) kuraljsonObject.get("sp");
            String mk = (String) kuraljsonObject.get("mk");
            String couplet = (String) kuraljsonObject.get("couplet");
            String explanation = (String) kuraljsonObject.get("explanation");
            String transliteration1 = (String) kuraljsonObject.get("transliteration1");
            String transliteration2 = (String) kuraljsonObject.get("transliteration2");
            String paul_name=(String)kuraljsonObject.get("paul_name");
            String paul_transliteration=(String)kuraljsonObject.get("paul_transliteration");
            String adikaram_name=(String)kuraljsonObject.get("adikaram_name");
            String adikaram_transliteration=(String)kuraljsonObject.get("adikaram_transliteration");
            String adikaram_translation=(String)kuraljsonObject.get("adikaram_translation");

            return new Thirukural(Number, Line1, Line2, Translation, mv, sp, mk, couplet, explanation, transliteration1, transliteration2,paul_name,paul_transliteration,adikaram_name,adikaram_transliteration,adikaram_translation);
        }
        catch(Exception e)
        {
            System.out.println(e);
            return null;
        }

    }

    public List<Thirukural> searchByAthigaram(int start) throws IOException, ParseException {

            JSONParser jsonparser = new JSONParser();
            FileReader reader = new FileReader("src/main/java/jsonFile/thirukkuralAdhigaram.json");
            Object obj = jsonparser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray) jsonObject.get("kural");
            for (int i =start; i <(start+10); i++) {
                JSONObject kuraljsonObject = (JSONObject) jsonArray.get(i);
                Long Number = (Long) kuraljsonObject.get("Number");
                String Line1 = (String) kuraljsonObject.get("Line1");
                String Line2 = (String) kuraljsonObject.get("Line2");
                String Translation = (String) kuraljsonObject.get("Translation");
                String mv = (String) kuraljsonObject.get("mv");
                String sp = (String) kuraljsonObject.get("sp");
                String mk = (String) kuraljsonObject.get("mk");
                String couplet = (String) kuraljsonObject.get("couplet");
                String explanation = (String) kuraljsonObject.get("explanation");
                String transliteration1 = (String) kuraljsonObject.get("transliteration1");
                String transliteration2 = (String) kuraljsonObject.get("transliteration2");
                String paul_name = (String) kuraljsonObject.get("paul_name");
                String paul_transliteration = (String) kuraljsonObject.get("paul_transliteration");
                String adikaram_name = (String) kuraljsonObject.get("adikaram_name");
                String adikaram_transliteration = (String) kuraljsonObject.get("adikaram_transliteration");
                String adikaram_translation = (String) kuraljsonObject.get("adikaram_translation");
                adhigaramList.add(new Thirukural(Number, Line1, Line2, Translation, mv, sp, mk, couplet, explanation, transliteration1, transliteration2, paul_name, paul_transliteration, adikaram_name, adikaram_transliteration, adikaram_translation));

            }
            System.out.println(adhigaramList.size());
            return adhigaramList;


    }
}
