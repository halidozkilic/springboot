package com.toyota.faultdetection.resource;

import com.toyota.faultdetection.domain.Fault;
import com.toyota.faultdetection.dto.FaultDTO;
import com.toyota.faultdetection.service.FaultService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/toyota")
public class FaultResource {

    private final FaultService faultService;

    public FaultResource(FaultService faultService) {
        this.faultService = faultService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/faults")
    public ResponseEntity<List<FaultDTO>> getFaults() {
        List<FaultDTO> faults = faultService.getAll().stream()
                .map(FaultDTO::fromEntity)
                .collect(Collectors.toList());

        return ResponseEntity.ok(faults);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/faults")
    public ResponseEntity<URI> createFault(@RequestBody FaultDTO faultDTO) {
        Fault persistedFault = faultService.save(faultDTO.toEntity());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(persistedFault.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/faults/{faultId}")
    public ResponseEntity<?> deleteFault(@PathVariable Long faultId) {
        faultService.delete(faultId);
        return ResponseEntity.noContent().build();
    }
}