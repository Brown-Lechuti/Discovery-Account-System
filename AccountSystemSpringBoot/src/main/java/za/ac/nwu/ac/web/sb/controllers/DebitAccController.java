package za.ac.nwu.ac.web.sb.controllers;

/*import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import za.ac.nwu.ac.domain.service.GeneralResponse;*
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;*/

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DebitAccController
{
    @RequestMapping(value = "/hello")
    public String Hello() {
        return "Hello World";
    }

}
