package match;

import competition.Competition;
import team.Team;

import javax.persistence.*;
import java.util.GregorianCalendar;
import java.util.Set;

@Entity
@Table(name = "matches")
public class Match {

    private int id;
    private Set<Team> teams;
    private GregorianCalendar fixtureDate;
    private Competition competition;

    public Match() {
    }

    public Match(Set<Team> teams, GregorianCalendar fixtureDate, Competition competition) {
        this.teams = teams;
        this.fixtureDate = fixtureDate;
        this.competition = competition;
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

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "team_matches",
            joinColumns = {@JoinColumn(name = "match_id", nullable = false, updatable = false)},
        inverseJoinColumns = {@JoinColumn(name = "team_id", nullable = false, updatable = false)})
    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    @Column(name = "fixture_date")
    public GregorianCalendar getFixtureDate() {
        return fixtureDate;
    }

    public void setFixtureDate(GregorianCalendar fixtureDate) {
        this.fixtureDate = fixtureDate;
    }

    @ManyToOne
    @JoinColumn(name="match_id", nullable = false)
    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }
}
