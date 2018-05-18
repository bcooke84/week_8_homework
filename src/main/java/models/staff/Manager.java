package models.staff;

import team.Team;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="managers")
public class Manager extends Staff {

    private String formation;
    private Team team;

    public Manager() {
    }

    public Manager(String name, int salary, int age, String formation) {
        super(name, salary, age);
        this.formation = formation;
    }

    @Column(name = "formation")
    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    @Column(name = "team")
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
