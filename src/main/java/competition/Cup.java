package competition;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cups")
public class Cup extends Competition {

    private String finalVenue;

    public Cup() {
    }

    public Cup(String name, CompetitionType competitionType, String finalVenue) {
        super(name, competitionType);
        this.finalVenue = finalVenue;
    }

    @Column(name = "final_venue")
    public String getFinalVenue() {
        return finalVenue;
    }

    public void setFinalVenue(String finalVenue) {
        this.finalVenue = finalVenue;
    }
}
