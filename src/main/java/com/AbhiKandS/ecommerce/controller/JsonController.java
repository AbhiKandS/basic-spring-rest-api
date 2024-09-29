package com.AbhiKandS.ecommerce.controller;

import com.AbhiKandS.ecommerce.service.JsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.html.HTMLTableCaptionElement;

import javax.lang.model.util.Elements;

@RestController
@RequestMapping("/json")
public class JsonController {
    @Autowired
    JsonService jsonService;


    @CrossOrigin(origins = "*")
    @GetMapping("/get")
    ResponseEntity<String> getString() {
        String status = jsonService.displayString();
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/post")
    ResponseEntity<String> saveString(@RequestBody String json) {
        String status = jsonService.saveString(json);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

}
