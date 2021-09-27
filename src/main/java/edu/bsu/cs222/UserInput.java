package edu.bsu.cs222;

import java.util.Scanner;

public class UserInput {

    public String getUserInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of a wikipedia article to search for:");
        String providedArticleName = scanner.nextLine();

        if(providedArticleName.equals("")){
            System.err.println("Please enter an article title");
            System.exit(1);
        }

        return providedArticleName;
    }
}
