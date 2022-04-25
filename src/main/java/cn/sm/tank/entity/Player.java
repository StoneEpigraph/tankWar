package cn.sm.tank.entity;

import cn.sm.tank.ResourceMgr;
import cn.sm.tank.TankFrame;
import cn.sm.tank.constant.Dir;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

/**
 * @ClassName Player
 * @Description TODO
 * @Author WhatsUpeng
 * @Date 4/22/22 9:17 AM
 * @Version 1.0
 **/
@Data
public class Player extends Tank {

    private static Logger logger = LoggerFactory.getLogger(Player.class);

    private Dir dir = Dir.UP;
    private static int SPEED = 5;
    private boolean isLive = true;
    private boolean isMoving = false;
    private Group group;

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

    public Player(int x, int y, Group group, TankFrame tf) {
        super(tf);
        this.x = x;
        this.y = y;
        this.group = group;
    }

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
        oldX = x;
        oldY = y;
        logger.debug("x: " + x + ", y: " + y + ", game_width: " + (tankFrame.GAME_WIDTH - ResourceMgr.goodTankL.getWidth())
            + ", game_height: " + (tankFrame.GAME_HEIGHT - ResourceMgr.goodTankL.getHeight()));
        if (!boundaryDetection(dir)) {
            return ;
        }

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
