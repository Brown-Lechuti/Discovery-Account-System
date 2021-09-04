package za.ac.nwu.web.sb.controller;

/*import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import za.ac.nwu.ac.domain.service.GeneralResponse;*
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;*/
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import za.ac.nwu.web.sb.service.Greeting;

@RestController
public class Controller
{
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name)
    {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }


    /*@RequestMapping("/")
    public String getHelloWorld()
    {
        return "Hello World";
    }*/
   /* @GetMapping("/ping")
    public GeneralResponse<String> ping(@ResponseParam(value = "echo", defaultvalue = "pong") String echo)
    {
        return new GeneralResponse<String>(successful: true, echo);
    }*/
}
