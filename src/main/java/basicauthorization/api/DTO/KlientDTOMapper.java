package basicauthorization.api.DTO;

import basicauthorization.api.Model.Klient;

import java.util.List;
import java.util.stream.Collectors;

public class KlientDTOMapper {

    private KlientDTOMapper() {
    }

    public static List<KlientDTO> mapToKlientDTOs(List<Klient> klients) {

        return klients.stream()
                .map(klient -> mapToKlientDTO(klient))
                .collect(Collectors.toList());

    }

    private static KlientDTO mapToKlientDTO(Klient klient) {
        return KlientDTO.builder()
                .id(klient.getId())
                .imie(klient.getImie())
                .nazwisko(klient.getNazwisko())
                .pesel(klient.getPesel())
                .wypozyczalniaId(klient.getWypozyczalniaId())
                .wiek(klient.getWiek())
                .build();
    }
}
