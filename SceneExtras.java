public class SceneExtras {
    int rank;
    String name;
    boolean taken;

    public SceneExtras(int rk, String extrasName) {
        rank = rk;
        name = extrasName;
        taken = false;
    }

    protected void setAvailability(boolean occupied) { this.taken = occupied; }

    public int getRank() {
        return this.rank;
    }
    public String getName() {
        return this.name;
    }
    public boolean getAvailability() { return this.taken; }
}
