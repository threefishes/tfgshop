package cn.enilu.flash.service;

import cn.enilu.flash.BaseApplicationStartTest;
import cn.enilu.flash.service.api.express.kdniao.KdniaoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ：enilu
 * @date ：Created in 2020/5/31 22:06
 */
public class KdniaoServiceTest extends BaseApplicationStartTest {
    @Autowired
    private KdniaoService kdniaoService;
    @Test
    public void realTimeQuery() {
//        YT4544755661648
        kdniaoService.realTimeQuery("YT9420173297830","YTO");

    }
}
