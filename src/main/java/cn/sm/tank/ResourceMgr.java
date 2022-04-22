package cn.sm.tank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.nio.Buffer;

/**
 * @ClassName ResourceMrg
 * @Description TODO
 * @Author StoneEpigraph
 * @Date 4/22/22 1:10 PM
 * @Version 1.0
 **/
public class ResourceMgr {

    static Logger logger = LoggerFactory.getLogger(ResourceMgr.class);

    public static BufferedImage goodTankL, goodTankR, goodTankU, goodTankD;
    public static BufferedImage badTankL, badTankR, badTankU, badTankD;
    public static BufferedImage bullet;
    public static BufferedImage[] explodes = new BufferedImage[10];

    static {
        try {
            // 加载图片
            goodTankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("img/p1tankL.gif"));
            goodTankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("img/p1tankR.gif"));
            goodTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("img/p1tankU.gif"));
            goodTankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("img/p1tankD.gif"));
            badTankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("img/p2tankL.gif"));
            badTankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("img/p2tankR.gif"));
            badTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("img/p2tankU.gif"));
            badTankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("img/p2tankD.gif"));
            bullet = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("img/tankmissile.gif"));
        } catch (Exception e) {
            logger.error("ResourceMgr获取资源出错");
        }
    }
}
