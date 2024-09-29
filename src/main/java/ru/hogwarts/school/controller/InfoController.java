package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.school.service.InfoService;

@RestController
@RequestMapping("/port")
public class InfoController {

    private InfoService infoService;

    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }
    @GetMapping()
    public String getInfo() {
            return infoService.getPort();
        }
}
