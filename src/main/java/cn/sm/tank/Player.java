package cn.sm.tank;

import cn.sm.tank.constant.Dir;
import lombok.Data;

import java.awt.*;

/**
 * @ClassName Player
 * @Description TODO
 * @Author StoneEpigraph
 * @Date 4/22/22 9:17 AM
 * @Version 1.0
 **/
@Data
public class Player extends Frame {

    private Dir dir = Dir.UP;
    private static int SPEED = 5;
    private int x = 380;
    private int y = 540;
    private boolean isLive = true;
    private boolean isMoving = false;

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        switch (dir) {
            case UP:
                g.drawImage(ResourceMgr.goodTankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.goodTankD, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourceMgr.goodTankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.goodTankR, x, y, null);
                break;
        }
        move();
    }

    /**
     * 移动
     */
    public void move() {
        if (!isLive) {
            return;
        }
        if (!isMoving) {
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

    /**
     * 开火
     */
    public void fire() {

    }
}
