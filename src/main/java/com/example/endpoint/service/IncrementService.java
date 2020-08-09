package com.example.endpoint.service;

import com.example.endpoint.exceptions.IncrementServiceException;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class IncrementService {
    private Integer incrementBy = 1;

    public String increment(String number) {
        if (incrementBy == null || incrementBy == 0)
            return number;

        try {
            int parseInt = Integer.parseInt(number);
            StringBuilder result = new StringBuilder();
            while (parseInt > 0) {
                final int lastDigit = ((parseInt % 10) + incrementBy) % 10;
                result.append(lastDigit);
                parseInt /= 10;
            }
            return result.reverse().toString();
        } catch (NumberFormatException e) {
            throw new IncrementServiceException("Неверный формат числа", e);
        }
    }
}
