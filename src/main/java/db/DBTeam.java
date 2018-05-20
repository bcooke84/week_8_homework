package db;

import match.Match;
import models.staff.Player;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import team.Team;

import java.util.ArrayList;
import java.util.List;

public class DBTeam {

    private static Session session;


    public static List<Match> getHomeMatches(Team team) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Match> homeMatches = null;

        try {
            Criteria cr = session.createCriteria(Match.class);
            cr.add(Restrictions.eq("homeTeam", team));
            homeMatches = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return homeMatches;
    }

    public static List<Match> getAwayMatches(Team team) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Match> awayMatches = null;

        try {
            Criteria cr = session.createCriteria(Match.class);
            cr.add(Restrictions.eq("awayTeam", team));
            awayMatches = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return awayMatches;
    }

    public static List<Match> getAllMatches(Team team) {
        List<Match> allMatches = new ArrayList<Match>();
        List<Match> homeMatches = DBTeam.getHomeMatches(team);
        List<Match> awayMatches = DBTeam.getAwayMatches(team);

        allMatches.addAll(homeMatches);
        allMatches.addAll(awayMatches);
        return allMatches;
    }

    public static List<Player> getPlayers(Team team) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Player> players = null;

        try {
            Criteria cr = session.createCriteria(Player.class);
            cr.add(Restrictions.eq("team", team));
            players = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return players;
    }

}
