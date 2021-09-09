package za.ac.nwu.ac.web.sb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import za.ac.nwu.ac.repo.dto.Member_Repo;

@SpringBootApplication
public class RestServiceApplication extends SpringBootServletInitializer
{
   /* @Autowired
    Member_Repo*/
    public static void main(String[] args)
    {
        SpringApplication.run(RestServiceApplication.class, args);
    }
}