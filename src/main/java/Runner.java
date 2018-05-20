import competition.CompetitionType;
import competition.Cup;
import competition.League;
import db.DBCompetition;
import db.DBHelper;
import db.DBMatch;
import db.DBTeam;
import match.Match;
import models.staff.Manager;
import models.staff.MatchResult;
import models.staff.Player;
import models.staff.Position;
import team.Team;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

public class Runner {

    public static void main(String[] args) {


        GregorianCalendar week1 = new GregorianCalendar(2020, 07, 12);
        GregorianCalendar week2 = new GregorianCalendar(2020, 07, 19);
        GregorianCalendar week3 = new GregorianCalendar(2020, 07, 26);


        Player player1 = new Player("Scott Brown", 32, Position.MIDFIELDER);
        Player player2 = new Player("Moussa Dembele", 21, Position.STRIKER);

        DBHelper.save(player1);
        DBHelper.save(player2);

        Manager manager1 = new Manager("Brendan Rodgers", 45, "4-5-1");
        Manager manager2 = new Manager("Derek McInnes", 46, "4-4-2");
        Manager manager3 = new Manager("Stephen Robinson", 43, "5-4-1");

        DBHelper.save(manager1);
        DBHelper.save(manager2);
        DBHelper.save(manager3);


        Team team1 = new Team("Celtic", "Celtic Park", manager1);
        Team team2 = new Team("Aberdeen", "Pittodrie", manager2);
        Team team3 = new Team("Motherwell", "Fir Park", manager3);


        DBHelper.save(team1);
        DBHelper.save(team2);
        DBHelper.save(team3);

        League league = new League("Scottish Premiership", CompetitionType.LEAGUE);

        DBHelper.save(league);

        Cup cup = new Cup("Scottish Cup", CompetitionType.KNOCKOUT, "Hampden Stadium");

        DBHelper.save(cup);

        Match match1 = new Match(team1, team2, week1, league);
        Match match2 = new Match(team1, team3, week2, league);
        Match match3 = new Match(team2, team1, week3, league);

        DBHelper.save(match1);
        DBHelper.save(match2);
        DBHelper.save(match3);

        List<Match> homeGames = DBTeam.getHomeMatches(team1);
        List<Match> awayGames = DBTeam.getAwayMatches(team1);
        List<Match> allGames = DBTeam.getAllMatches(team1);


        DBHelper.signPlayer(team1, player1, 8, 20000);
        DBHelper.signPlayer(team1, player2, 10, 15000);

        List<Player> allPlayers = DBTeam.getPlayers(team1);

        Set<Player> celtic = team1.getPlayers();

        List<Match> allMatches = DBCompetition.getMatches(league);

        DBHelper.signManager(team1, manager1, 25000);

        Manager currentManager = DBHelper.find(Manager.class, manager1.getId());

        DBMatch.updateResults(match1, MatchResult.HOMEWIN);
        DBMatch.updateResults(match2, MatchResult.DRAW);
        DBMatch.updateResults(match1, MatchResult.AWAYWIN);

        List<Team> leagueTable = DBCompetition.sortedTeams(league);


    }
}
