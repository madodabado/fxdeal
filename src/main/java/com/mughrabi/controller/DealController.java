package com.mughrabi.controller;

import com.mughrabi.dto.DealDTO;
import com.mughrabi.entity.Deal;
import com.mughrabi.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.BindingResult;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author - Mado
 */
@RestController
@RequestMapping("/api/deals")
@Slf4j
public class DealController {
    private final DealService dealService;

    @Autowired
    public DealController(DealService dealService) {
        this.dealService = dealService;
    }

    @PostMapping
    public ResponseEntity<?> createDeal( @Valid @RequestBody DealDTO dealDTO, BindingResult bindingResult) {
        log.info("Starting API Call to Create Deal");

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors);
        }

        try {
            Deal savedDeal = dealService.saveDeal(dealDTO);
            return ResponseEntity.ok(savedDeal);
        } catch (Exception e) {
            log.error("Catching Exception while creating the deal");
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
