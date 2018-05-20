package competition;

import match.Match;
import team.Team;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "competitions")
public abstract class Competition {

    private int id;
    private String name;
    private CompetitionType competitionType;
    private Set<Match> matches;

    public Competition() {
    }

    public Competition(String name, CompetitionType competitionType) {
        this.name = name;
        this.competitionType = competitionType;
        this.matches = new HashSet<Match>();
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

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "competition_type")
    public CompetitionType getCompetitionType() {
        return competitionType;
    }

    public void setCompetitionType(CompetitionType competitionType) {
        this.competitionType = competitionType;
    }

    @OneToMany(mappedBy = "competition")
    public Set<Match> getMatches() {
        return matches;
    }

    public void setMatches(Set<Match> matches) {
        this.matches = matches;
    }
}
