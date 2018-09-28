package io.zensoft.neliseenko.football.statistic.parser.handlers;

import io.zensoft.neliseenko.football.statistic.parser.to.StatisticTO;
import io.zensoft.neliseenko.football.statistic.parser.to.TableTO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import static io.zensoft.neliseenko.football.statistic.parser.api.CallToApi.call;
import static io.zensoft.neliseenko.football.statistic.parser.utils.Utils.readPropertiesValue;

public class InputHandler {

    private static final String HELP = "help";
    private static final String EXIT = "exit";

    private static StatisticTO to;
    private static Map<Integer, String> map;

    static {
        to = call("http://api.football-data.org/v2/competitions/"
                + readPropertiesValue("id") + "/standings");
        int index = 1;
        map = new HashMap<>();
        for (TableTO table : to.getStandings().get(0).getTable()) {
            map.put(index++, table.getTeam().getName());
        }
    }

    private void handler(String word) {
        if (!word.isEmpty()) {
            if (HELP.equalsIgnoreCase(word.trim())) {
                outputHelp();
            } else if (EXIT.equalsIgnoreCase(word.trim())) {
                System.err.println("Thank you for attention\nBy Nikita Eliseenko");
                //System.exit(0);
                // Без exit(0) main просто завершится, само собой
                // но оставлять просто пустым блок else мне показалось как-то bad practice,
                // на маленьком проекте, как этот, еще куда не шло,
                // но на больших я думаю не лучшая идея оставлять блок пустым.
                // Может и ошибаюсь, хотелось бы узнать подробнее почему не стоит использовать.
            } else if (!HELP.equalsIgnoreCase(word.trim())) {
                handleInputTeam(word);
            } else {
                System.err.println("Please, enter the correct data.");
                input();
            }
        } else {
            System.err.println("You didn't enter anything.");
            input();
        }
    }

    private void handleInputTeam(String word) {
        if (Pattern.compile("\\d+").matcher(word).matches()) {
            if (Integer.parseInt(word) <= map.size()) {
                System.out.println(searchResultByName(map.get(Integer.parseInt(word))));
            } else {
                System.err.println("Invalid number (" + word + ") entered.");
            }
            input();
        } else {
            System.out.println(searchResultByName(word));
            input();
        }
    }

    private void outputHelp() {
        int index = 1;
        for (TableTO table : to.getStandings().get(0).getTable()) {
            System.out.println(index++ + " " + table.getTeam().getName());
        }
        input();
    }

    private String searchResultByName(String name) {
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

    private void input() {
        try {
            System.out.println("_____________________________________________________\n" +
                    "Enter the team name (number) or " + HELP +
                    "\nFor exit: " + EXIT);
            BufferedReader standardInput = new BufferedReader(new InputStreamReader(System.in));
            handler(standardInput.readLine());
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }

    public void perform() {
        input();
    }
}
