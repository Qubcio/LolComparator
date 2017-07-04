package com.qubcio.jsoup.controller;

import com.qubcio.jsoup.facade.ChampionFacade;
import com.qubcio.jsoup.model.dto.ChampionDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/champion/{championId}")
class ChampionController {

    private final ChampionFacade championFacade;

    @RequestMapping(method = RequestMethod.GET, produces =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<ChampionDto> greetings(@PathVariable Integer championId) {
        ChampionDto championDto = championFacade.findById(championId);
        if (championDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(championDto, HttpStatus.OK);
    }
}
