package in.aman.gatekeeper.analytics.dtos.responsedto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class HealthResponse {

    private String serviceName;
    private String serviceDescription;
    private String appStatus;
}
