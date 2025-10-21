public class CelestialObject {
    private int x;
    private int y;
    private int size;
    private int vx;
    private int vy;

    /**
     * creates celestial object at a specific position and velocity
     */
    public CelestialObject(int x, int y, int size, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.vx = vx;
        this.vy = vy;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getSize() { return size; }
    public int getVx() { return vx; }
    public int getVy() { return vy; }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }


}
