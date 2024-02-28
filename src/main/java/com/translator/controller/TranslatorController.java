package com.translator.controller;

import com.translator.model.RequestTxt;
import com.translator.model.ResponseTranslate;
import com.translator.services.TranslatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/translate")
public class TranslatorController {

    @Autowired
    private TranslatorService translatorService;

    @PostMapping
    public ResponseEntity<ResponseTranslate> translateToFrench(@RequestBody RequestTxt requestTxt) throws Exception {
        return new ResponseEntity<>(translatorService.translateEngToFrench(requestTxt),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getMessage(){
        return new ResponseEntity("welcome to translator app",HttpStatus.OK);
    }
}
