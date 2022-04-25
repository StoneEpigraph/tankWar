package cn.sm.tank.entity;

import cn.sm.tank.ResourceMgr;
import cn.sm.tank.TankFrame;
import cn.sm.tank.constant.Dir;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName Tank
 * @Description TODO
 * @Author WhatsUpeng
 * @Date 4/25/22 12:37 PM
 * @Version 1.0
 **/
public abstract class Tank implements GameObject {

    private static Logger logger = LoggerFactory.getLogger(Tank.class);

    public int oldX, oldY;
    public int x, y;
    public TankFrame tankFrame;

    public Tank(TankFrame tf) {
        this.tankFrame = tf;
    }

    public boolean boundaryDetection(Dir dir) {
        logger.debug("x: " + x + ", y: " + y + ", game_width: " + (tankFrame.GAME_WIDTH - ResourceMgr.goodTankL.getWidth())
            + ", game_height: " + (tankFrame.GAME_HEIGHT - ResourceMgr.goodTankL.getHeight()));
        if (x <= 0 && dir == Dir.LEFT) {
            return false;
        }
        if (y <= 30 && dir == Dir.UP) {
            return false;
        }
        if (x >= tankFrame.GAME_WIDTH - ResourceMgr.goodTankL.getWidth() && dir == Dir.RIGHT) {
            return false;
        }
        if (y >= tankFrame.GAME_HEIGHT - ResourceMgr.goodTankL.getHeight() && dir == Dir.DOWN) {
            return false;
        }
        return true;
    }
}
