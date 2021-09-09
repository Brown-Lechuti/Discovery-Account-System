package za.ac.nwu.ac.web.sb.configurations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/*import org.springframework.web.servlet.config.annotation.EnableWebMvc;*/

@Configuration
/*@EnableWebMvc2*/
@ComponentScan(basePackages = {"za.ac.nwu.ac.web.sb.controllers","za.ac.nwu.ac.web.sb.exceptions","za.ac.nwu.ac.repo.dto"})
public class WebConfig
{

} 