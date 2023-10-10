package CatLady;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String input = scanner.nextLine();
        List<Cat> cats = new ArrayList<>();
        while (!input.equals("End")){
            String[] parts = input.split("\\s+");
            String breed = parts[0];
            String name = parts[1];
            String token = parts[2];
            switch (breed){
                case "StreetExtraordinaire":
                    StreetExtraordinaire streetCat = new StreetExtraordinaire(name, Double.parseDouble(token));
                    cats.add(streetCat);
                    break;
                case "Cymric":
                    Cymric cymric = new Cymric(name, Double.parseDouble(token));
                    cats.add(cymric);
                    break;
                case "Siamese":
                    Siamese siamese = new Siamese(name, Double.parseDouble(token));
                    cats.add(siamese);
                    break;
            }
            input = scanner.nextLine();
        }
        String catName = scanner.nextLine();
        for (Cat cat1 : cats) {
            if(cat1.getName().equals(catName)){
                System.out.println(cat1);
                break;
            }
        }
    }
}
