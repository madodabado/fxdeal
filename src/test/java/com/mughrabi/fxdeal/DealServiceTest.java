package com.mughrabi.fxdeal;

import com.mughrabi.dto.DealDTO;
import com.mughrabi.entity.Deal;
import com.mughrabi.repository.DealRepository;
import com.mughrabi.service.DealService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * @author - Mado
 */
@SpringBootTest
public class DealServiceTest {
    @Autowired
    private DealService dealService;

    @MockBean
    private DealRepository dealRepository;



    @Test
    public void testSaveSuccessDeal() throws Exception {
        DealDTO dealDTO = new DealDTO();
        dealDTO.setDealUniqueId("12345");
        dealDTO.setFromCurrencyIsoCode("USD");
        dealDTO.setToCurrencyIsoCode("EUR");
        dealDTO.setDealTimestamp(LocalDateTime.now());
        dealDTO.setDealAmount(500.0);

        when(dealRepository.findByDealUniqueId(anyString())).thenReturn(Optional.empty());

        Deal deal = dealService.saveDeal(dealDTO);
    }

    @Test
    public void testSaveExistingDeal() {
        DealDTO dealDTO = new DealDTO();
        dealDTO.setDealUniqueId("12345");
        dealDTO.setFromCurrencyIsoCode("USD");
        dealDTO.setToCurrencyIsoCode("EUR");
        dealDTO.setDealTimestamp(LocalDateTime.now());
        dealDTO.setDealAmount(10.0);

        when(dealRepository.findByDealUniqueId(anyString())).thenReturn(Optional.of(new Deal()));

        assertThrows(Exception.class, () -> {
            dealService.saveDeal(dealDTO);
        });
    }

}
