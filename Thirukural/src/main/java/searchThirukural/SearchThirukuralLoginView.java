package searchThirukural;


import dto.Thirukural;

import java.util.Scanner;

public class SearchThirukuralLoginView implements searchThirukuralLoginViewCallBack {
    Scanner sc = new Scanner(System.in);
    private searchThirukuralcontrollerCallBack controllerObj;

    public SearchThirukuralLoginView() {
        controllerObj = new SearchThirukuralController(this);
    }

    public void searchThirukuralByNumber() {
        System.out.println("ENTER THE THIRUKURAL ENN");
        int num = sc.nextInt();
        Thirukural obj = controllerObj.searchThirukuralByNumber(num - 1);
        System.out.println("குறள் எண் " + obj.getNumber());
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println(" " + obj.getLine1());
        System.out.println(" " + obj.getLine2());
        System.out.println("----------------------------------------------");
        System.out.println("தமிழ் விளக்கம்: " + obj.getMv());
        System.out.println("\nEnglish Translation: " + obj.getTranslation());

    }
}
