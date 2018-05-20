package db;

import competition.Competition;
import match.Match;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import team.Team;

import java.util.List;

public class DBCompetition {

    private static Session session;

    public static List<Match> getMatches(Competition competition) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Match> allMatches = null;

        try {
            Criteria cr = session.createCriteria(Match.class);
            cr.add(Restrictions.eq("competition", competition));
            allMatches = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return allMatches;
    }

    public static List<Team> sortedTeams(Competition competition) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Team> sortedTeams = null;

        try {
            Criteria cr = session.createCriteria(Team.class);
            cr.addOrder( Order.desc("points") );
            sortedTeams = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return sortedTeams;
    }

}
