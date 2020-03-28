package com.viniciusgomes.awesome.util;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component // a classe será scaneada pelo @ComponentScan do ApplicationStart
// Especializações de Component
@Repository // Usado quando se está trabalhando com DAO
@Service // Usado para classes que trabalham como serviço
public class DateUtil {
    public String formatLocalDateTimeToDatabaseStyle (LocalDateTime localDateTime) {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime);
    }
}
