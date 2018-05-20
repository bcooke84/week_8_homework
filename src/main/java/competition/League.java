package competition;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "leagues")
public class League extends Competition {

    public League() {
    }

    public League(String name, CompetitionType competitionType) {
        super(name, competitionType);
    }



}
