package cn.sm.tank;

import cn.sm.tank.ResourceMgr;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @ClassName ResourceMgrTest
 * @Description TODO
 * @Author StoneEpigraph
 * @Date 4/22/22 6:08 PM
 * @Version 1.0
 **/
public class ResourceMgrTest {

    @Test
    public void testResourceLoad() {
        assertNotNull(ResourceMgr.goodTankL);
    }

}
