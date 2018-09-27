package io.zensoft.neliseenko.football.statistic.parser.handlers;

import io.zensoft.neliseenko.football.statistic.parser.api.CallToApi;
import io.zensoft.neliseenko.football.statistic.parser.to.StatisticTO;
import io.zensoft.neliseenko.football.statistic.parser.to.TableTO;
import io.zensoft.neliseenko.football.statistic.parser.utils.Utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class InputHandler {
    private static final String HELP = "help";
    private static final String EXIT = "exit";
    private static StatisticTO to;
    private static Map<Integer, String> map;

    static {
        to = new CallToApi().call("http://api.football-data.org/v2/competitions/"
                + new Utils().readPropertiesValue("id") + "/standings");

        int index = 1;
        map = new HashMap<>();
        for (TableTO table : to.getStandings().get(0).getTable()) {
            map.put(index++, table.getTeam().getName());
        }
    }

    private static void handler(String word) {
        if (!word.isEmpty()) {
            if (HELP.equalsIgnoreCase(word.trim())) {
                outputHelp();
            } else if (EXIT.equalsIgnoreCase(word.trim())) {
                System.exit(0);
            } else if (!HELP.equalsIgnoreCase(word.trim())) {
                handleInputTeam(word);
            } else {
                System.out.println("Please, enter the correct data.");
                input();
            }
        } else {
            System.out.println("You didn't enter anything.");
            input();
        }
    }

    private static void handleInputTeam(String word) {
        if (Pattern.compile("\\d+").matcher(word).matches()) {
            if (Integer.parseInt(word) <= map.size()) {
                System.out.println(searchResultByName(map.get(Integer.parseInt(word))));
            } else {
                System.err.println("Invalid number entered.");
            }
            input();
        } else {
            System.out.println(searchResultByName(word));
            input();
        }
    }

    private static void outputHelp() {
        int index = 1;
        for (TableTO table : to.getStandings().get(0).getTable()) {
            System.err.println(index++ + " " + table.getTeam().getName());
        }
        input();
    }

    private static String searchResultByName(String name) {
        String r = "";
        for (TableTO table : to.getStandings().get(0).getTable()) {
            if (table.getTeam().getName().equalsIgnoreCase(name)) {
                r = "\n" + name + "\nTotal\tWon\tDraw\tLost\tPoints\n" + table.getPlayedGames() + "\t"
                        + table.getWon() + "\t" + table.getDraw() + "\t" + table.getLost() + "\t"
                        + table.getPoints();
                break;
            }
        }
        return r;
    }

    public static void input() {
        try {
            System.out.println("Enter the command name or " + HELP);
            System.out.println("For exit: " + EXIT);
            BufferedReader standardInput = new BufferedReader(new InputStreamReader(System.in));
            handler(standardInput.readLine());
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }
}
