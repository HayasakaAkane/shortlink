package org.natsume.shortlink.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ClassName: ShortLinkAdminApplication
 * Package: org.natsume.shortlink.admin
 * Description: 用户启动类
 *
 * @Author natsume
 * @Create 2025/1/17 15:00
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("org.natsume.shortlink.admin.dao.mapper")
public class ShortLinkAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShortLinkAdminApplication.class, args);
    }
}
