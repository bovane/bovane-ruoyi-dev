package work.bovane;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import java.net.InetAddress;

/**
 * 启动程序
 * 
 * @author ruoyi
 */
@Slf4j
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class RuoYiApplication implements ApplicationRunner {

    private ConfigurableApplicationContext context;

    @Autowired
    public RuoYiApplication(ConfigurableApplicationContext context) {
        this.context = context;
    }
    @Value("${server.port:8080}")
    private String port;

    @Value("${server.servlet.context-path}")
    private String contextPath;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (context.isActive()) {
            InetAddress address = InetAddress.getLocalHost();
            String urlBase = String.format("http://%s:%s", address.getHostAddress(), port);

            log.info(",--.   ,--.          ,--.,--.              ,--.        ,-----.,------.  ,------.");
            log.info("|   `.'   | ,---.  ,-|  |`--' ,---. ,--,--.|  |,-----.'  .--./|  .-.  \\ |  .--. '");
            log.info("|  |'.'|  || .-. :' .-. |,--.| .--'' ,-.  ||  |'-----'|  |    |  |  \\  :|  '--'.'");
            log.info("|  |   |  |\\   --.\\ `-' ||  |\\ `--.\\ '-'  ||  |       '  '--'\\|  '--'  /|  |\\  \\");
            log.info("`--'   `--' `----' `---' `--' `---' `--`--'`--'        `-----'`-------' `--' '--'");
            log.info("Medical-CDR 根地地址：{}", urlBase + contextPath);
            log.info("Medical-CDR 文档地址：{}", urlBase + contextPath + "/doc.html");
            log.info("WebService  访问地址：{}", urlBase + contextPath + "/webservice");
        }
    }
}
