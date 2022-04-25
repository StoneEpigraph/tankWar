package cn.sm.tank.entity;

import cn.sm.tank.ResourceMgr;
import cn.sm.tank.constant.Dir;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.awt.*;
import java.util.Arrays;

/**
 * @ClassName NpcTank
 * @Description TODO
 * @Author StoneEpigraph
 * @Date 4/25/22 12:39 PM
 * @Version 1.0
 **/
public class NpcTank extends Tank {

    private static float TURN_ON_CHANCE = 0.1f;
    private static int SPEED = 5;

    private int x, y;
    private Dir dir = Dir.DOWN;

    private boolean isLive = true;
    private boolean isMoving = false;

    public NpcTank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics g) {
        switch (dir) {
            case UP:
                g.drawImage(ResourceMgr.badTankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.badTankD, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourceMgr.badTankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.badTankR, x, y, null);
                break;
        }
        move();
    }

    public void move() {
        if (Math.random() < TURN_ON_CHANCE) {
            // 随机方向
            dir = Arrays.asList(Dir.values()).get((int) (Math.random() * Dir.values().length));
        };
        if (!isLive) {
            return;
        }

        // TODO 边界检测

        switch (dir) {
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
        }
    }
}
