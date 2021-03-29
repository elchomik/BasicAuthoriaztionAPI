package basicauthorization.api.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SamochodDTO {
    private Long id;
    private Long wypozyczalniaId;
    private String nazwa;
    private String model;
    private String marka;
    private double przebieg;
    private int rok;
}
