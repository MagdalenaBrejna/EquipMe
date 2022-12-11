package mb.equip_me.services.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@EnableDiscoveryClient
@EntityScan("mb.equip_me")
@EnableJpaRepositories("mb.equip_me.services.item.domain")
@PropertySource("classpath:item-server.yml")
public class ItemServer {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "item-server");
        SpringApplication.run(mb.equip_me.services.item.ItemServer.class, args);
    }
}