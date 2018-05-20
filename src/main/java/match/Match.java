package match;

import competition.Competition;
import team.Team;

import javax.persistence.*;
import java.util.GregorianCalendar;
import java.util.Set;
import models.staff.MatchResult;

@Entity
@Table(name = "matches")
public class Match {

    private int id;
    private Team homeTeam;
    private Team awayTeam;
    private GregorianCalendar fixtureDate;
    private Competition competition;
    private models.staff.MatchResult matchResult;

    public Match() {
    }

    public Match(Team homeTeam, Team awayTeam, GregorianCalendar fixtureDate, Competition competition) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
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

    @ManyToOne()
    @JoinColumn(name = "home_match_id", nullable = false)
    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team team) {
        this.homeTeam = team;
    }

    @ManyToOne()
    @JoinColumn(name = "away_match_id", nullable = false)
    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team team) {
        this.awayTeam = team;
    }

    @Column(name = "fixture_date")
    public GregorianCalendar getFixtureDate() {
        return fixtureDate;
    }

    public void setFixtureDate(GregorianCalendar fixtureDate) {
        this.fixtureDate = fixtureDate;
    }

    @ManyToOne
    @JoinColumn(name="match_competition_id", nullable = false)
    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "match_result")
    public MatchResult getMatchResult() {
        return this.matchResult;
    }

    public void setMatchResult(MatchResult matchResult) {
        this.matchResult = matchResult;
        if (matchResult == MatchResult.HOMEWIN) {
            homeTeam.winMatch();
        } else if (this.matchResult == MatchResult.AWAYWIN) {
            awayTeam.winMatch();
        }
        else {
            homeTeam.drawMatch();
            awayTeam.drawMatch();
        }
    }
}
