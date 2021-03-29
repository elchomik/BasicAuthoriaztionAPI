package basicauthorization.api.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class Klient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long wypozyczalniaId;
    private String imie;
    private String nazwisko;
    private String pesel;
    private int wiek;

    @Override
    public String toString() {
        return "Klient{" +
                "id=" + id +
                ", wypozyczalniaId=" + wypozyczalniaId +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", pesel='" + pesel + '\'' +
                ", wiek=" + wiek +
                '}';
    }
}
