package db;

import match.Match;
import models.staff.MatchResult;
import org.hibernate.Session;

public class DBMatch {

    private static Session session;

    public static void updateResults(Match match, MatchResult matchResult) {
        match.setMatchResult(matchResult);
        DBHelper.save(match);
        DBHelper.save(match.getHomeTeam());
        DBHelper.save(match.getAwayTeam());
    }


}
