package com.dingtai.customermager;

import com.dingtai.customermager.utils.LogUtil;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 后台API
 *
 * @author wangyanhui
 * @date 2017-11-27 17:58
 */
@SpringBootApplication
public class DingtaiApiApplication {

    private static Logger log = LogUtil.get();

    public static void main(String[] args) {
        SpringApplication.run(DingtaiApiApplication.class, args);
        log.info("后台API启动成功...");
    }
}
