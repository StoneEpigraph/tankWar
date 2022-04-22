package cn.sm.tank;

import cn.sm.tank.constant.Dir;
import lombok.Data;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

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

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        switch (dir) {
            case UP:
                g.drawImage(ResourceMgr.goodTankU, 100, 100, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.goodTankD, 100, 100, null);
                break;
            case LEFT:
                g.drawImage(ResourceMgr.goodTankL, 100, 100, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.goodTankR, 100, 100, null);
                break;

        }
    }
}
