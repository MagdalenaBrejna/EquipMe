package mb.equip_me.services.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@EnableDiscoveryClient
@EntityScan("mb.equip_me")
@EnableJpaRepositories("mb.equip_me")
@PropertySource("classpath:user-server.yml")
public class UserServer {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "user-server");
        SpringApplication.run(UserServer.class, args);
    }
}