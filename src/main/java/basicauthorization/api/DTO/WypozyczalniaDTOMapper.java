package basicauthorization.api.DTO;


import basicauthorization.api.Model.Wypozyczalnia;

import java.util.List;
import java.util.stream.Collectors;

public class WypozyczalniaDTOMapper {
    private WypozyczalniaDTOMapper() {
    }

    public static List<WypozyczalniaDTO> mapToWypozyczalniaDTOs(List<Wypozyczalnia> wypozyczalnias){
        return wypozyczalnias.stream()
                .map(wypozyczalnia -> mapToWypozyczalniaDTO(wypozyczalnia))
                .collect(Collectors.toList());
    }

    private static WypozyczalniaDTO mapToWypozyczalniaDTO(Wypozyczalnia wypozyczalnia) {
        return WypozyczalniaDTO.builder()
                .id(wypozyczalnia.getId())
                .miasto(wypozyczalnia.getMiasto())
                .nazwa(wypozyczalnia.getNazwa())
                .ulica(wypozyczalnia.getUlica())
                .wlasciciel(wypozyczalnia.getWlasciciel())
                .build();
    }
}
