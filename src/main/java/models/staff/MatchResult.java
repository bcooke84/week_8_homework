package models.staff;

public enum MatchResult {

    HOMEWIN(3),
    DRAW(1),
    AWAYWIN(3);

    private final int points;

    MatchResult(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }
}
