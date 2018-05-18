package models.staff;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "players")
public class Player extends Staff {
    private Position position;
    private int squadNumber;

    public Player() {
    }

    public Player(String name, int salary, int age, Position position, int squadNumber) {
        super(name, salary, age);
        this.position = position;
        this.squadNumber = squadNumber;
    }

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
}
