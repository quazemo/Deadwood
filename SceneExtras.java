public class SceneExtras {
    int rank;
    String name;

    public SceneExtras(int rk, String extrasName) {
        rank = rk;
        name = extrasName;
    }

    // getters
    protected getRank() {
        return this.rank;
    }
    protected getName() {
        return this.name;
    }
}