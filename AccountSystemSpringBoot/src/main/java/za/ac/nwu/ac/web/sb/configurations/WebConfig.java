package za.ac.nwu.ac.web.sb.configurations;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import za.ac.nwu.ac.domain.dto.Member;
import za.ac.nwu.ac.repo.dto.Member_Repo;
/*import org.springframework.web.servlet.config.annotation.EnableWebMvc;*/
/*@EnableWebMvc2*/

@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackageClasses={Member_Repo.class})
@EntityScan(basePackageClasses= Member.class)
@ComponentScan(basePackages = {"za.ac.nwu.ac.web.sb.controllers","za.ac.nwu.ac.domain.dto",
       "za.ac.nwu.ac.repo.dto", "za.ac.nwu.ac.web.sb.exceptions"})
public class WebConfig
{

} 