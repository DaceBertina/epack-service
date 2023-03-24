package estack.epack.controller;

import estack.epack.business.service.EpackService;
import estack.epack.domain.Epack;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Log4j2
@Tag(description = "IT course", name = "epack")
@RestController
@RequestMapping(value="/api/v1/epacks")
@RequiredArgsConstructor
public class EpackController {

    private final EpackService epackService;

    private final RestTemplate restTemplate;

    @Operation(summary = "Adds and saves the course in the database.",
               description = "If provide correct data, saves it.",
               tags = {"epack"})
    @ApiResponses(value = { @ApiResponse(description = "successful operation", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Epack.class)), @Content(mediaType = "application/json", schema = @Schema(implementation = Epack.class)) }) })
    @PostMapping(value = "/course", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Epack> addEpack (@Valid @RequestBody Epack epack, BindingResult bindingResult) {
        log.info("Add new course by passing: {}", epack);

        if (bindingResult.hasErrors()) {
            log.error("New course cannot be added: error in {}", bindingResult);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Epack newEpack = epackService.createEpack(epack);
        return new ResponseEntity<>(newEpack, HttpStatus.CREATED);
    }

    @GetMapping("/{epackId}")
    public ResponseEntity<Epack> getEpack(@PathVariable final Long epackId) {
        return ResponseEntity.ok(epackService.findEpackById(epackId));
    }

//    @GetMapping(value = "/{id}")
//    public String getEpack(@PathVariable("id") String id, @RequestBody Epack epack) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
//        HttpEntity<Epack> entity = new HttpEntity<>(epack, headers);
//
//        return restTemplate.exchange(
//                "http://localhost:8084/epacks/"+id, HttpMethod.GET, entity, String.class).getBody();
//    }
}
