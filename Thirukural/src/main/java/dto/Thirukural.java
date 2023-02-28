package dto;

public class Thirukural {
    public Thirukural(Long number, String line1, String line2, String translation, String mv, String sp, String mk, String couplet, String explanation, String transliteration1, String transliteration2, String paulName, String paulTransliteration, String adikaramName, String adikaramTransliteration, String adikaramTranslation) {
        Number = number;
        this.Line1 = line1;
        this.Line2 = line2;
        this.Translation = translation;
        this.mv = mv;
        this.sp = sp;
        this.mk = mk;
        this.couplet = couplet;
        this.explanation = explanation;
        this.transliteration1 = transliteration1;
        this.transliteration2 = transliteration2;
        this.paul_name = paul_name;
        this.paul_transliteration = paul_transliteration;
        this.iyal_name = iyal_name;
        this.iyal_transliteration = iyal_transliteration;
        this.adikaram_name = adikaram_name;
        this.adikaram_transliteration = adikaram_transliteration;
        this.adikaram_translation = adikaram_translation;
    }

    public Long getNumber() {
        return Number;
    }

    public void setNumber(Long number) {
        Number = number;
    }

    public String getLine1() {
        return Line1;
    }

    public void setLine1(String line1) {
        Line1 = line1;
    }

    public String getLine2() {
        return Line2;
    }

    public void setLine2(String line2) {
        Line2 = line2;
    }

    public String getTranslation() {
        return Translation;
    }

    public void setTranslation(String translation) {
        Translation = translation;
    }

    public String getMv() {
        return mv;
    }

    public void setMv(String mv) {
        this.mv = mv;
    }

    public String getSp() {
        return sp;
    }

    public void setSp(String sp) {
        this.sp = sp;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    public String getCouplet() {
        return couplet;
    }

    public void setCouplet(String couplet) {
        this.couplet = couplet;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getTransliteration1() {
        return transliteration1;
    }

    public void setTransliteration1(String transliteration1) {
        this.transliteration1 = transliteration1;
    }

    public String getTransliteration2() {
        return transliteration2;
    }

    public void setTransliteration2(String transliteration2) {
        this.transliteration2 = transliteration2;
    }

    private Long Number;
    private String Line1;
    private String Line2;
    private String Translation;
    private String mv;
    private String sp;
    private String mk;
    private String couplet;
    private String explanation;
    private String transliteration1;
    private String transliteration2;

    public String getPaul_name() {
        return paul_name;
    }

    public String getPaul_transliteration() {
        return paul_transliteration;
    }

    public String getIyal_name() {
        return iyal_name;
    }

    public String getIyal_transliteration() {
        return iyal_transliteration;
    }

    public String getAdikaram_name() {
        return adikaram_name;
    }

    public String getAdikaram_transliteration() {
        return adikaram_transliteration;
    }

    public String getAdikaram_translation() {
        return adikaram_translation;
    }

    public void setPaul_name(String paul_name) {
        this.paul_name = paul_name;
    }

    private String paul_name;

    public void setPaul_transliteration(String paul_transliteration) {
        this.paul_transliteration = paul_transliteration;
    }

    private String paul_transliteration;
    private String iyal_name;
    private String iyal_transliteration;
    private String adikaram_name;
    private String adikaram_transliteration;

    private String adikaram_translation;


}
