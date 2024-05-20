package com.mughrabi.service;

import com.mughrabi.dto.DealDTO;
import com.mughrabi.entity.Deal;
import com.mughrabi.repository.DealRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Optional;
import java.util.Set;

/**
 * @author - Mado
 */
@Service
@Slf4j
@Validated

public class DealService {
    private final Validator validator;
    private final DealRepository dealRepository;
    @Autowired
    public DealService(DealRepository dealRepository, Validator validator) {
        this.dealRepository = dealRepository;
        this.validator = validator;
    }


    public Deal saveDeal(DealDTO dealDTO) throws Exception {
        log.error("Deal Service Starting Saving Deals ...");

        Set<ConstraintViolation<DealDTO>> violations = validator.validate(dealDTO);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<DealDTO> violation : violations) {
                sb.append(violation.getMessage()).append("\n");
            }
            log.error("Error validating Deal : " + sb.toString());
            throw new IllegalArgumentException("Validation errors: " + sb.toString());
        }


        Optional<Deal> existingDeal = dealRepository.findByDealUniqueId(dealDTO.getDealUniqueId());

        if (existingDeal.isPresent()) {
            log.error("Deal is already exist error");
            throw new Exception("Deal with this ID already exists");
        }
        log.info("Deal has been validated successfully will start inserting to the DB");


        Deal deal = new Deal();
        deal.setDealUniqueId(dealDTO.getDealUniqueId());
        deal.setFromCurrencyIsoCode(dealDTO.getFromCurrencyIsoCode());
        deal.setToCurrencyIsoCode(dealDTO.getToCurrencyIsoCode());
        deal.setDealTimestamp(dealDTO.getDealTimestamp());
        deal.setDealAmount(dealDTO.getDealAmount());

        return dealRepository.save(deal);
    }
}
