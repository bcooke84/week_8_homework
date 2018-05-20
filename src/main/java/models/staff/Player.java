package models.staff;

import team.Team;

import javax.persistence.*;
import java.util.GregorianCalendar;

@Entity
@Table(name = "players")
public class Player extends Staff {
    private Position position;
    private int squadNumber;
    private Team team;

    public Player() {
    }

    public Player(String name, int salary, int age, GregorianCalendar contractStart, GregorianCalendar contractEnd, Position position, int squadNumber) {
        super(name, salary, age, contractStart, contractEnd);
        this.position = position;
        this.squadNumber = squadNumber;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "position")
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Column(name = "squad_number")
    public int getSquadNumber() {
        return squadNumber;
    }

    public void setSquadNumber(int squadNumber) {
        this.squadNumber = squadNumber;
    }

    @ManyToOne()
    @JoinColumn(name = "player_id", nullable = true)
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
