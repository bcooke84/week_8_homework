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

    public Player(String name, int age, Position position) {
        super(name, age);
        this.position = position;
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

    public void signForTeam(Team team, int squadNumber, int salary) {
        this.team = team;
        this.setSquadNumber(squadNumber);
        this.setSalary(salary);
    }

}
