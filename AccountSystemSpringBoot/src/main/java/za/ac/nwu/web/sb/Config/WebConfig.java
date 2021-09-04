package za.ac.nwu.web.sb.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/*import org.springframework.web.servlet.config.annotation.EnableWebMvc;*/

@Configuration
/*@EnableWebMvc*/
@ComponentScan(basePackages = {
        "za.ac.nwu.ac.web.sb.controller",
        "za.ac.nwu.ac.web.sb.exception"
})
public class WebConfig
{
} 