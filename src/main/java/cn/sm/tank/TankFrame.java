package cn.sm.tank;

import cn.sm.tank.constant.Dir;
import cn.sm.tank.entity.NpcTank;
import cn.sm.tank.entity.Player;
import org.junit.jupiter.api.ClassOrderer;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @ClassName TankFrame
 * @Description TODO
 * @Author StoneEpigraph
 * @Date 4/22/22 8:56 AM
 * @Version 1.0
 **/
public class TankFrame extends Frame {

    public static TankFrame INSTANCE = new TankFrame();
    Player player = new Player();
    private java.util.List<NpcTank> npcTank = new ArrayList<>();
    private int GAME_WIDTH= 1024;
    private int GAME_HEIGHT = 768;
    private int BAD_TANK_INIT_LEN = 10;

    private TankFrame() {
        setLocation(200, 400);
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setTitle("Tank War");
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        setVisible(true);
        addKeyListener(new MyKeyListener());

        // NPC
        for (int i = 0; i < BAD_TANK_INIT_LEN; i++) {
            npcTank.add(new NpcTank((int) (Math.random() * GAME_WIDTH), (int) (Math.random() * GAME_HEIGHT / 2)));
        }
    }

    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("xxx");
        player.paint(g);
        for (NpcTank npc : npcTank) {
            npc.paint(g);
        }
    }

    public static void launch() {
    }

    private class MyKeyListener extends KeyAdapter {

        boolean bL = false;
        boolean bR = false;
        boolean bU = false;
        boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    setMainTankDir();
                    player.setDir(Dir.LEFT);
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    setMainTankDir();
                    player.setDir(Dir.RIGHT);
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    setMainTankDir();
                    player.setDir(Dir.UP);
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    setMainTankDir();
                    player.setDir(Dir.DOWN);
                    break;
                case KeyEvent.VK_SPACE:
                    player.fire();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    setMainTankDir();
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    setMainTankDir();
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    setMainTankDir();
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    setMainTankDir();
                    break;
            }

        }

        private void setMainTankDir() {
            if (!bL && !bR && !bU && !bD) {
                player.setMoving(false);
            } else {
                if (bL) {
                    player.setDir(Dir.LEFT);
                } else if (bR) {
                    player.setDir(Dir.RIGHT);
                } else if (bU) {
                    player.setDir(Dir.UP);
                } else if (bD) {
                    player.setDir(Dir.DOWN);
                }
                player.setMoving(true);
            }


        }
    }

    public static void main(String[] args) {
        TankFrame tf = TankFrame.INSTANCE;

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tf.repaint();
            }
        }).start();
    }
}
