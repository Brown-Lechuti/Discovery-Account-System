package za.ac.nwu.ac.web.sb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import za.ac.nwu.ac.repo.dto.Member;
import za.ac.nwu.ac.repo.dto.Member_Repo;
import za.ac.nwu.ac.web.sb.services.Greeting;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@Service
public class CreditAccController
{
    @Autowired
    Member_Repo repo;
    @GetMapping("/test")
    public String test()
    {
        Member member = new Member("Brown","Lechuti","2021-09-09",2,50);
        repo.save(member);
        return repo.findAll().stream().findFirst().toString();
    }
    /*private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }*/
}
