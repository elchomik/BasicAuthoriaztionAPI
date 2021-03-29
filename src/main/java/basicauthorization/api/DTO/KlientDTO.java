package basicauthorization.api.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class KlientDTO {
    private Long id;
    private Long wypozyczalniaId;
    private String imie;
    private String nazwisko;
    private String pesel;
    private int wiek;
}
