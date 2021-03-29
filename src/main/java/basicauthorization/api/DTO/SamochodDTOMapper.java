package basicauthorization.api.DTO;

import basicauthorization.api.Model.Samochod;

import java.util.List;
import java.util.stream.Collectors;

public class SamochodDTOMapper {
    private SamochodDTOMapper() {
    }

    public static List<SamochodDTO> mapToSamochodDTOs(List<Samochod> samochods){
        return samochods.stream()
                .map(samochod -> mapToSamochodDTO(samochod))
                .collect(Collectors.toList());
    }

    private static SamochodDTO mapToSamochodDTO(Samochod samochod) {
        return SamochodDTO.builder()
                .id(samochod.getId())
                .marka(samochod.getMarka())
                .model(samochod.getModel())
                .nazwa(samochod.getNazwa())
                .przebieg(samochod.getPrzebieg())
                .rok(samochod.getRok())
                .wypozyczalniaId(samochod.getWypozyczalniaId())
                .build();
    }
}
