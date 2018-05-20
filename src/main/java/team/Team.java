package team;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import db.DBHelper;
import models.staff.Manager;
import models.staff.Player;

import javax.persistence.*;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "teams")
public class Team {

    private int id;
    private String name;
    private Set<match.Match> homeMatches;
    private Set<match.Match> awayMatches;
    private Set<Player> players;
    private Manager manager;
    private String stadium;
    private int points;

    public Team() {
    }

    public Team(String name, String stadium, Manager manager) {
        this.name = name;
        this.homeMatches = new HashSet<match.Match>();
        this.awayMatches = new HashSet<match.Match>();
        this.players = new HashSet<Player>();
        this.stadium = stadium;
        this.manager = manager;
        this.points = 0;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "homeTeam")
    public Set<match.Match> getHomeMatches() {
        return homeMatches;
    }

    public void setHomeMatches(Set<match.Match> homeMatches) {
        this.homeMatches = homeMatches;
    }


    @OneToMany(mappedBy = "awayTeam")
    public Set<match.Match> getAwayMatches() {
        return awayMatches;
    }

    public void setAwayMatches(Set<match.Match> awayMatches) {
        this.awayMatches = awayMatches;
    }

    @OneToMany(mappedBy = "team")
    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Column(name = "stadium")
    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    @Column(name = "points")
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void addManager(Manager manager) {
        this.manager = manager;
    }

    public void addHomeMatch(match.Match match) {
        this.homeMatches.add(match);
    }

    public void addAwayMatch(match.Match match) {
        this.awayMatches.add(match);
    }

    public void winMatch() {
        this.points += 3;
    }

    public void drawMatch() {
        this.points += 1;
    }


}
