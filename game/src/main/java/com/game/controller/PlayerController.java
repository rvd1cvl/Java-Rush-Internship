package com.game.controller;

import com.game.controller.requests.CreatePlayerRequest;
import com.game.controller.response.CreatePlayerResponse;
import com.game.dto.PlayerDto;
import com.game.entity.Player;
import com.game.entity.Profession;
import com.game.entity.Race;
import com.game.service.PlayerService;
import com.game.service.converter.RequestConverter;
import com.game.service.converter.ResponseConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {

    private final PlayerService playerService;
    private final RequestConverter requestConverter;
    private final ResponseConverter responseConverter;

    public PlayerController(PlayerService playerService, RequestConverter requestConverter,
                            ResponseConverter responseConverter) {
        this.playerService = playerService;
        this.requestConverter = requestConverter;
        this.responseConverter = responseConverter;
    }



    @GetMapping(path = "/rest/players")
    public List<Player> getAllPlayers(@RequestParam(required = false) String name,
                                      @RequestParam(required = false) String title,
                                      @RequestParam(required = false) Race race,
                                      @RequestParam(required = false) Profession profession,
                                      @RequestParam(required = false) Long after,
                                      @RequestParam(required = false) Long before,
                                      @RequestParam(required = false) Boolean banned,
                                      @RequestParam(required = false) Integer minExperience,
                                      @RequestParam(required = false) Integer maxExperience,
                                      @RequestParam(required = false) Integer minLevel,
                                      @RequestParam(required = false) Integer maxLevel,
                                      @RequestParam(required = false) PlayerOrder order,
                                      @RequestParam(required = false) Integer pageNumber,
                                      @RequestParam(required = false) Integer pageSize) {
        if (pageNumber == null) {
            pageNumber = 0;
        }

        if (pageSize == null) {
            pageSize = 3;
        }

        return playerService.getPlayers(pageNumber, pageSize);
    }

    @GetMapping("/rest/players/count")
    public Integer getPlayersCount(@RequestParam(required = false) String name,
                                   @RequestParam(required = false) String title,
                                   @RequestParam(required = false) Race race,
                                   @RequestParam(required = false) Profession profession,
                                   @RequestParam(required = false) Long after,
                                   @RequestParam(required = false) Long before,
                                   @RequestParam(required = false) Boolean banned,
                                   @RequestParam(required = false) Integer minExperience,
                                   @RequestParam(required = false) Integer maxExperience,
                                   @RequestParam(required = false) Integer minLevel,
                                   @RequestParam(required = false) Integer maxLevel,
                                   @RequestParam(required = false) PlayerOrder order,
                                   @RequestParam(required = false) Integer pageNumber,
                                   @RequestParam(required = false) Integer pageSize) {
        return  playerService.getPlayersCount();
    }

    @PostMapping("/rest/players")
    public ResponseEntity<CreatePlayerResponse> createNewPlayer(@RequestBody CreatePlayerRequest createPlayerRequest) {
        PlayerDto playerDto = requestConverter.convert(createPlayerRequest);

        PlayerDto savedPlayer = playerService.create(playerDto);
        CreatePlayerResponse response = responseConverter.convert(savedPlayer);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
