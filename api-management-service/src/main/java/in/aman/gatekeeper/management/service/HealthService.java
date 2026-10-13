package in.aman.gatekeeper.management.service;

import in.aman.gatekeeper.management.dtos.ResponseDto.HealthResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HealthService {

    private final JdbcTemplate jdbcTemplate;

    public String getHealth() {

        String databaseStatus = "DOWN";
        String sql = "SELECT 1";
        try {
            Integer result = jdbcTemplate.queryForObject(sql, Integer.class);
            if(Integer.valueOf(1).equals(result)) {
                databaseStatus = "UP";
            }
        } catch (Exception e) {
            System.out.println("DB connection failed!" + e.getMessage());
        }

        return databaseStatus;
    }

}
