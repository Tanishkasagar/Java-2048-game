import java.awt.*;
import java.net.URL;
import java.util.Hashtable;
import java.util.Map;
import javax.swing.*;

public class GUI {

    int frameHeight = 394;
    int frameWidth = 328;
    int gameBoardSize = 296;
    int marginSize = 16;
    Color backgroundColor = new Color(255, 255, 120);

    Map numberTiles;

    JFrame frame;

    public GUI() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loadNumberTiles();

        GameBoard gb = new GameBoard();

        // North panel
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout());
        northPanel.setPreferredSize(new Dimension(frameWidth, 82));

        JLabel gameLabel = new JLabel("1024", SwingConstants.CENTER);
        gameLabel.setFont(new Font("Serif", Font.BOLD, 20));
        northPanel.add(gameLabel);
        northPanel.add(new JLabel("<html>Score:<br>524</html>", SwingConstants.CENTER));
        northPanel.add(new JLabel("<html>High Score:<br>2000</html>", SwingConstants.CENTER));
        northPanel.setBackground(backgroundColor);

        // Other panels

        JPanel westBuffer = new JPanel();
        westBuffer.setPreferredSize(new Dimension(marginSize, gameBoardSize));
        westBuffer.setBackground(backgroundColor);

        JPanel eastBuffer = new JPanel();
        eastBuffer.setPreferredSize(new Dimension(marginSize, gameBoardSize));
        eastBuffer.setBackground(backgroundColor);

        JPanel southBuffer = new JPanel();
        southBuffer.setPreferredSize(new Dimension(frameWidth, marginSize));
        southBuffer.setBackground(backgroundColor);

        // Add Panels to Frame

        frame.getContentPane().add(northPanel, BorderLayout.NORTH);
        frame.getContentPane().add(westBuffer, BorderLayout.WEST);
        frame.getContentPane().add(eastBuffer, BorderLayout.EAST);
        frame.getContentPane().add(southBuffer, BorderLayout.SOUTH);
        frame.getContentPane().add(gb, BorderLayout.CENTER);

        frame.getContentPane().setPreferredSize(new Dimension(frameWidth, frameHeight));
        frame.pack();
        frame.setVisible(true);

    }

    private void loadNumberTiles() {
        numberTiles = new Hashtable();
        ClassLoader cldr = this.getClass().getClassLoader();
        URL url0000 = cldr.getResource("images/0.png");
        URL url0001 = cldr.getResource("images/1.png");
        URL url0002 = cldr.getResource("images/2.png");
        URL url0004 = cldr.getResource("images/4.png");
        URL url0008 = cldr.getResource("images/8.png");
        URL url0016 = cldr.getResource("images/16.png");
        URL url0032 = cldr.getResource("images/32.png");
        URL url0064 = cldr.getResource("images/64.png");
        URL url0128 = cldr.getResource("images/128.png");
        URL url0256 = cldr.getResource("images/256.png");
        URL url0512 = cldr.getResource("images/512.png");
        URL url1024 = cldr.getResource("images/1024.png");
        numberTiles.put(0, new ImageIcon(url0000));
        numberTiles.put(1, new ImageIcon(url0001));
        numberTiles.put(2, new ImageIcon(url0002));
        numberTiles.put(4, new ImageIcon(url0004));
        numberTiles.put(8, new ImageIcon(url0008));
        numberTiles.put(16, new ImageIcon(url0016));
        numberTiles.put(32, new ImageIcon(url0032));
        numberTiles.put(64, new ImageIcon(url0064));
        numberTiles.put(128, new ImageIcon(url0128));
        numberTiles.put(256, new ImageIcon(url0256));
        numberTiles.put(512, new ImageIcon(url0512));
        numberTiles.put(1024, new ImageIcon(url1024));
    }

    class GameBoard extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(new Color(20, 20, 20));
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            int[][] test = {
                {0, 1, 2, 3},
                {4, 8, 16, 32},
                {64, 128, 256, 512},
                {1024, 0, 0, 0}
            };
            for (int y = 1; y < 5; y++) {
                for (int x = 1; x < 5; x++) {
                    int X = (8 * x) + (64 * (x-1));
                    int Y = (8 * y) + (64 * (y-1));
                    
                    int thisNumber = test[y-1][x-1];

                    if (numberTiles.containsKey(thisNumber)) {
                        ImageIcon thisTile = (ImageIcon)numberTiles.get(thisNumber);
                        thisTile.paintIcon(this, g, X, Y);
                    }
                }
            }
        }
    }
}
