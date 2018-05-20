package models.staff;

import team.Team;

import javax.persistence.*;
import java.util.GregorianCalendar;

@Entity
@Table(name="managers")
public class Manager extends Staff {

    private String formation;
    private Team team;

    public Manager() {
    }

    public Manager(String name, int age, String formation) {
        super(name, age);
        this.formation = formation;
    }

    @Column(name = "formation")
    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    @OneToOne(mappedBy = "manager", cascade = CascadeType.PERSIST)
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }



}
