import competition.CompetitionType;
import competition.Cup;
import competition.League;
import db.DBHelper;
import models.staff.Manager;
import models.staff.Player;
import models.staff.Position;
import team.Team;

import java.util.GregorianCalendar;
import java.util.Set;

public class Runner {

    public static void main(String[] args) {


        GregorianCalendar start = new GregorianCalendar(2018, 04, 18);
        GregorianCalendar end = new GregorianCalendar(2020, 07, 18);

        Player player1 = new Player("Scott Brown", 15000, 32, start, end,  Position.MIDFIELDER, 8);
        Player player2 = new Player("Moussa Dembele", 12500, 21, start, end,  Position.STRIKER, 10);

        DBHelper.save(player1);
        DBHelper.save(player2);

        Manager manager1 = new Manager("Brendan Rodgers", 20000, 45, start, end, "4-5-1");
        Manager manager2 = new Manager("Derek McInnes", 8000, 46, start, end, "4-4-2");
        Manager manager3 = new Manager("Stephen Robinson", 5000, 43, start, end, "5-4-1");

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



    }
}
