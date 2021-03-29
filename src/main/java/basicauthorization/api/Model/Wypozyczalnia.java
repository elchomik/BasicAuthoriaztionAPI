package basicauthorization.api.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Wypozyczalnia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nazwa;
    private String ulica;
    private String miasto;
    private String wlasciciel;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "wypozyczalniaId",insertable = false,updatable = false)
    private List<Klient> klient;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "wypozyczalniaId",insertable = false,updatable = false)
    private List<Samochod> samochod;

}
