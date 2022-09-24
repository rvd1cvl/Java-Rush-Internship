package com.game.controller;

import com.game.controller.filters.PlayerFilter;
import com.game.controller.requests.CreatePlayerRequest;
import com.game.controller.requests.UpdatePlayerRequest;
import com.game.controller.response.CreatePlayerResponse;
import com.game.controller.response.GetPlayerResponse;
import com.game.controller.response.UpdatePlayerResponse;
import com.game.dto.PlayerDto;
import com.game.entity.Profession;
import com.game.entity.Race;
import com.game.service.PlayerService;
import com.game.service.converter.FilterBuilder;
import com.game.service.converter.RequestConverter;
import com.game.service.converter.ResponseConverter;
import com.game.utils.CreatePlayerRequestValidator;
import com.game.utils.DeletePlayerRequestValidator;
import com.game.utils.GetPlayerValidator;
import com.game.utils.UpdatePlayerRequestValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class PlayerRestController {

    private final PlayerService playerService;
    private final RequestConverter requestConverter;
    private final ResponseConverter responseConverter;
    private final FilterBuilder filterBuilder;

    public PlayerRestController(PlayerService playerService, RequestConverter requestConverter,
                                ResponseConverter responseConverter, FilterBuilder filterBuilder) {
        this.playerService = playerService;
        this.requestConverter = requestConverter;
        this.responseConverter = responseConverter;
        this.filterBuilder = filterBuilder;
    }

    @GetMapping(path = "/players")
    public List<GetPlayerResponse> getAllPlayers(@RequestParam(required = false) String name,
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
        PlayerFilter filter = filterBuilder.createFilter(name, title, race, profession, after, before, banned,
                minExperience, maxExperience, minLevel, maxLevel, order, pageNumber, pageSize);
        List<PlayerDto> playerDtoList = playerService.getPlayers(filter);
        return responseConverter.convertToGetAllPlayersResponse(playerDtoList);
    }

    @GetMapping("/players/count")
    public ResponseEntity<Integer> getPlayersCount(@RequestParam(required = false) String name,
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
        PlayerFilter filter = filterBuilder.createFilter(name, title, race, profession, after, before, banned,
                minExperience, maxExperience, minLevel, maxLevel, order, pageNumber, pageSize);
        return new ResponseEntity<>(playerService.getPlayersCount(filter), HttpStatus.OK);
    }

    @PostMapping("/players")
    public ResponseEntity<CreatePlayerResponse> createNewPlayer(@RequestBody CreatePlayerRequest createPlayerRequest) {
        CreatePlayerRequestValidator createPlayerResponseValidator = new CreatePlayerRequestValidator();
        if (!createPlayerResponseValidator.validate(createPlayerRequest)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        PlayerDto playerDto = requestConverter.convertToPlayerDto(createPlayerRequest);

        PlayerDto savedPlayer = playerService.create(playerDto);
        CreatePlayerResponse response = responseConverter.convertToCreatePlayerResponse(savedPlayer);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/players/{id}")
    public ResponseEntity<?> deletePlayer(@PathVariable Long id) {
        DeletePlayerRequestValidator deletePlayerRequestValidator = new DeletePlayerRequestValidator();
        boolean isValid = deletePlayerRequestValidator.validate(id);

        if (!isValid) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            playerService.delete(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/players/{id}")
    public ResponseEntity<UpdatePlayerResponse> updatePlayer(@RequestBody UpdatePlayerRequest updatePlayerRequest,
                                                             @PathVariable Long id) {
        UpdatePlayerRequestValidator updatePlayerRequestValidator = new UpdatePlayerRequestValidator(id);

        if (!updatePlayerRequestValidator.validate(updatePlayerRequest)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        PlayerDto playerDto = requestConverter.convertToPlayerDto(updatePlayerRequest, id);

        PlayerDto updatedPlayer = playerService.update(playerDto);

        if (updatedPlayer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        UpdatePlayerResponse response = responseConverter.convertToUpdatePlayerResponse(updatedPlayer);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/players/{id}")
    public ResponseEntity<GetPlayerResponse> getPlayer(@PathVariable Long id) {
        GetPlayerValidator getPlayerValidator = new GetPlayerValidator();
        if (!getPlayerValidator.validate(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        PlayerDto player = playerService.get(id);
        if (player == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        GetPlayerResponse response = responseConverter.convertToGetPlayerResponse(player);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
