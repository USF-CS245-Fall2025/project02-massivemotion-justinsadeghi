public class CelestialObject {
    private int x;
    private int y;
    private int size;
    private int vx;
    private int vy;

    /**
     * Create a celestial object at a specific position, size and velocity
     * @param x - coordinate
     * @param y - coordinate
     * @param size of the object
     * @param vx horizontal velocity
     * @param vy vertical velocity
     */
    public CelestialObject(int x, int y, int size, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.vx = vx;
        this.vy = vy;
    }


    /**
     * Getter methods for position, size and velocity
     */
    public int getX() { return x; }
    public int getY() { return y; }
    public int getSize() { return size; }
    public int getVx() { return vx; }
    public int getVy() { return vy; }

    /**
     * Setter methods for position
     */
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }


}
