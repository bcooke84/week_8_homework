package team;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import models.staff.Manager;
import models.staff.Player;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "teams")
public class Team {

    private int id;
    private String name;
    private Set<match.Match> matches;
    private Set<Player> players;
    private Manager manager;
    private String stadium;
    private int points;

    public Team() {
    }

    public Team(String name, String stadium, Manager manager) {
        this.name = name;
        this.matches = new HashSet<match.Match>();
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

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "team_matches",
    joinColumns = {@JoinColumn(name = "team_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "match_id", nullable = false, updatable = false)})
    public Set<match.Match> getMatches() {
        return matches;
    }

    public void setMatches(Set<match.Match> matches) {
        this.matches = matches;
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
}
