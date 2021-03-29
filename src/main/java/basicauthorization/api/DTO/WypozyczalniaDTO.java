package basicauthorization.api.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class WypozyczalniaDTO {
    private Long id;
    private String nazwa;
    private String ulica;
    private String miasto;
    private String wlasciciel;
}
