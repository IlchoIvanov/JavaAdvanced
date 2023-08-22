package SetsAndMaps;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Map.Entry.comparingByValue;

public class Srubsko {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "(?<singer>[A-Za-z]+( [A-Za-z]+)*) @(?<place>[A-Za-z]+( [A-Za-z]+)*) (?<ticketPrice>[0-9]+) (?<ticketCount>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);
        String input = scanner.nextLine();
        Map<String, LinkedHashMap<String, Integer>> places = new LinkedHashMap<>();
        while (!input.equals("End")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String singer = matcher.group("singer");
                String place = matcher.group("place");
                int currentPrice = Integer.parseInt(matcher.group("ticketPrice")) * Integer.parseInt(matcher.group("ticketCount"));
                if (!places.containsKey(place)) {
                    places.put(place, new LinkedHashMap<>());
                }
                LinkedHashMap<String, Integer> singers = places.get(place);
                if (!singers.containsKey(singer)) {
                    singers.put(singer, currentPrice);
                } else {
                    singers.put(singer, singers.get(singer) + currentPrice);
                }
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : places.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().entrySet().stream().sorted(Collections.reverseOrder(comparingByValue())).forEach(e -> System.out.println("#  " + e.getKey() + " -> " + e.getValue()));
        }

    }
}
