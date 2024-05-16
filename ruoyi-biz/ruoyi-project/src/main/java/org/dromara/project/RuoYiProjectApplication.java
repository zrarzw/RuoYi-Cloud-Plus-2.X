package org.dromara.project;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;

/**
 * 业务-项目模块
 *
 * @author ruoyi
 */
@EnableDubbo
@SpringBootApplication
public class RuoYiProjectApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(RuoYiProjectApplication.class);
        application.setApplicationStartup(new BufferingApplicationStartup(2048));
        application.run(args);
        System.out.println("(♥◠‿◠)ﾉﾞ  业务模块-项目启动成功   ლ(´ڡ`ლ)ﾞ  ");
    }
}
