package za.ac.nwu.web.sb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMapping;
/*import za.ac.nwu.ac.domain.service.GeneralResponse;*/

@RestController
public class Controller
{
    @GetMapping("/")
    public String getHelloWorld()
    {
        return "Hello World";
    }
   /* @GetMapping("/ping")
    public GeneralResponse<String> ping(@ResponseParam(value = "echo", defaultvalue = "pong") String echo)
    {
        return new GeneralResponse<String>(successful: true, echo);
    }*/
}
