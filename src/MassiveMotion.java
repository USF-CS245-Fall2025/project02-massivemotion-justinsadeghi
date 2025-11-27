import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

    public class MassiveMotion extends JPanel implements ActionListener {

        private Timer tm;
        private List<CelestialObject> celestialObjects;
        private Properties props;

        private double genX, genY;
        private int bodySize, bodyVelocity;
        private int winX, winY;

    /**
     * Creates the star simulation using the config from a txt file
     * Reads the parameters and creates a list implementation based on config values
     * creates the space for the simulation, and starts animation timer
     * @param propfile the config
     * @throws IOException if file can't be read
     */
    public MassiveMotion(String propfile) throws IOException {
        props = new Properties();
        props.load(new FileInputStream(propfile));

        genX = Double.parseDouble(props.getProperty("gen_x"));
        genY = Double.parseDouble(props.getProperty("gen_y"));
        bodySize = Integer.parseInt(props.getProperty("body_size"));
        bodyVelocity = Integer.parseInt(props.getProperty("body_velocity"));
        winX = Integer.parseInt(props.getProperty("window_size_x"));
        winY = Integer.parseInt(props.getProperty("window_size_y"));

        String listType = props.getProperty("list");
        celestialObjects = createList(listType);

        int starX = Integer.parseInt(props.getProperty("star_position_x"));
        int starY = Integer.parseInt(props.getProperty("star_position_y"));
        int starSize = Integer.parseInt(props.getProperty("star_size"));
        int starVx = Integer.parseInt(props.getProperty("star_velocity_x"));
        int starVy = Integer.parseInt(props.getProperty("star_velocity_y"));

        celestialObjects.add(new CelestialObject(starX, starY, starSize, starVx, starVy));

        int delay = Integer.parseInt(props.getProperty("timer_delay"));
        tm = new Timer(delay, this);
        tm.start();
    }

    /**
     *Draws all objects on the canvas each frame
     * The first object is a star and is painted red, all the other comets are painted black
     * @param g, a graphics painter to draw shapes on the canvas
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(int i = 0; i < celestialObjects.size(); i++) {
            CelestialObject obj = celestialObjects.get(i);

            if(i == 0) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.BLACK);
            }
            g.fillOval(obj.getX(), obj.getY(), obj.getSize(), obj.getSize());
        }


        tm.start();
    }

    /**
     * Creates the list for storing the objects in the simulation
     *
     * @param type one of the four list realizations
     * @return the created list implementation
     */
    private List<CelestialObject> createList(String type) {
        type = type.toLowerCase();
        if ("arraylist".equals(type)) { return new ArrayList<>(); }
        if ("single".equals(type)) { return new LinkedList<>(); }
        if ("double".equals(type)) { return new DoublyLL<>(); }
        if ("dummyhead".equals(type)) { return new DummyHeadLL<>(); }
        return new ArrayList<>();
    }

    /**
     * Updates the simulation every frame, spawns new comets, removes the comets that are off screen, and refreshes canvas
     * @param actionEvent gets called every time timer reaches the delay (every 75ms)
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        // update positions
        for (int i = 0; i < celestialObjects.size(); i++) {
            CelestialObject obj = celestialObjects.get(i);
            obj.setX(obj.getX() + obj.getVx());
            obj.setY(obj.getY() + obj.getVy());
        }

        spawnComets();
        removeComets();


        repaint();
    }

    // Creates new comets at edges of screen using probability from config
    private void spawnComets() {
        double chanceX = Math.random();
        double chanceY = Math.random();

        //spawn from top or bottom
        if (chanceX < genX) {
            boolean top = Math.random() < 0.5;
            int startX = (int)(Math.random() * getWidth());
            int startY;
            int vx = genVelocity(bodyVelocity);
            int vy;

            if (top) {
                startY = 0;
                vy = genVelocity(bodyVelocity);
            } else {
                startY = getHeight();
                vy = -genVelocity(bodyVelocity); //need negative velocity since it will move up
            }

            CelestialObject obj = new CelestialObject(startX, startY, bodySize, vx, vy);
            celestialObjects.add(obj);
        }

        //spawn from left or right
        if (chanceY < genY) {
            boolean left = Math.random() < 0.5;
            int startY = (int)(Math.random() * getHeight());
            int startX;
            int vx;
            int vy = genVelocity(bodyVelocity);

            if (left) {
                startX = 0;
                vx = genVelocity(bodyVelocity);
            } else {
                startX = getWidth();
                vx = -genVelocity(bodyVelocity); //need negative velocity since it will move left
            }

            CelestialObject obj = new CelestialObject(startX, startY, bodySize, vx, vy);
            celestialObjects.add(obj);
        }
    }

    private int genVelocity(int maxVelocity) {
        return (int)(Math.random() * maxVelocity) + 1; // plus 1 so the velocity is never 0
    }

    //remove comets from the list that don't appear on screen
    private void removeComets() {
        for (int i = celestialObjects.size() - 1; i > 0; i--) { //skip star index at 0
            CelestialObject obj = celestialObjects.get(i);
            if (obj.getX() < 0 || obj.getX() > getWidth() || obj.getY() < 0 || obj.getY() > getHeight()) {
                celestialObjects.remove(i);
            }
        }
    }

    private int getWindowX() { return winX; }
    private int getWindowY() { return winY; }

    /**
     * creates canvas window and beings simulation
     * @param args provide config file in command line arg
     * @throws IOException if file path incorrect
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Massive Motion starting...");
        MassiveMotion mm = new MassiveMotion(args[0]);
        //MassiveMotion mm = new MassiveMotion("src/MassiveMotion.txt");

        JFrame jf = new JFrame();
        jf.setTitle("Massive Motion");
        jf.setSize(mm.getWindowX(), mm.getWindowY());
        jf.add(mm);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}