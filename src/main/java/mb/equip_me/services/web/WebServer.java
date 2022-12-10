package mb.equip_me.services.web;

import mb.equip_me.services.web.item.WebItemController;
import mb.equip_me.services.web.item.WebItemService;
import mb.equip_me.services.web.user.WebUserController;
import mb.equip_me.services.web.user.WebUserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude = { HibernateJpaAutoConfiguration.class, DataSourceAutoConfiguration.class })
@EnableDiscoveryClient
@ComponentScan(useDefaultFilters=false)
public class WebServer {

    public static final String USER_SERVICE_URL = "http://USER-SERVICE";
    public static final String ITEM_SERVICE_URL = "http://ITEM-SERVICE";

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "web-server");
        SpringApplication.run(WebServer.class, args);
    }

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public WebUserService userService() {
        return new WebUserService(USER_SERVICE_URL);
    }

    @Bean
    public WebUserController userController() {
        return new WebUserController(userService());
    }

    @Bean
    public WebItemService itemService() {
        return new WebItemService(ITEM_SERVICE_URL);
    }

    @Bean
    public WebItemController itemController() {
        return new WebItemController(itemService());
    }
}