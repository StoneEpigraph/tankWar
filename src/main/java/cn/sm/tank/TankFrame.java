package cn.sm.tank;

import cn.sm.tank.constant.Dir;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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

    private TankFrame() {
        setLocation(200, 400);
        setSize(800, 600);
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
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("xxx");
        player.paint(g);
    }

    public static void launch() {
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

    private class MyKeyListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    player.setDir(Dir.LEFT);
                    break;
                case KeyEvent.VK_RIGHT:
                    player.setDir(Dir.RIGHT);
                    break;
                case KeyEvent.VK_UP:
                    player.setDir(Dir.UP);
                    break;
                case KeyEvent.VK_DOWN:
                    player.setDir(Dir.DOWN);
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);
        }
    }
}
