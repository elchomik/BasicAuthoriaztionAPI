INSERT INTO Wypozyczalnia(id,nazwa,ulica,miasto,wlasciciel) VALUES(1L,'Wypozycz u Mietka','ul.Jana Polaka','Lublin','Stefan Białek');
INSERT INTO Wypozyczalnia(id,nazwa,ulica,miasto,wlasciciel) VALUES(2L,'Wypozycz u Stasia','ul.Muzyczna','Lublin','Tomaszk Kotowski');
INSERT INTO Wypozyczalnia(id,nazwa,ulica,miasto,wlasciciel) VALUES(3L,'Wypozycz u Jasia','ul.Krochmalna','Lublin','Maria Kowalska');
INSERT INTO Wypozyczalnia(id,nazwa,ulica,miasto,wlasciciel) VALUES(4L,'Wypozycz u Bogdana','ul.Lwowksa','Wrocław','Andrzej Sosonwoski');
INSERT INTO Wypozyczalnia(id,nazwa,ulica,miasto,wlasciciel) VALUES(5L,'Wypozycz u Horacego','ul.Koryzonowa','Kraków','Grzegorz Chorzewski');
INSERT INTO Wypozyczalnia(id,nazwa,ulica,miasto,wlasciciel) VALUES(6L,'Wypozycz u Tomasza','ul.Czechowicza','Lublin','Jan Kowalski');
INSERT INTO Wypozyczalnia(id,nazwa,ulica,miasto,wlasciciel) VALUES(7L,'Wypozycz u Macieja','ul.Koncertowa','Poznań','Michał Maksymiuk');
INSERT INTO Wypozyczalnia(id,nazwa,ulica,miasto,wlasciciel) VALUES(8L,'Wypozycz u Piotra','ul.Paganiniego','Warszawa','Konrad Romanowski');
INSERT INTO Wypozyczalnia(id,nazwa,ulica,miasto,wlasciciel) VALUES(9L,'Wypozycz u Jacka','ul.Mackiewicza','Lublin','Tadeusz Sarzyński');
INSERT INTO Wypozyczalnia(id,nazwa,ulica,miasto,wlasciciel) VALUES(10L,'Wypozycz u Grzegorza','ul.Mickiewicza','Szczeci','Włodzimierz Kowalczyk');

INSERT INTO Klient(id,wypozyczalnia_id,imie,nazwisko,pesel,wiek) VALUES(1L,2L,'Jan','Brzeski','998373733',45);
INSERT INTO Klient(id,wypozyczalnia_id,imie,nazwisko,pesel,wiek) VALUES(2L,3L,'Tomasz','Brok','998373733',53);
INSERT INTO Klient(id,wypozyczalnia_id,imie,nazwisko,pesel,wiek) VALUES(3L,4L,'Paweł','Bik','998373733',35);
INSERT INTO Klient(id,wypozyczalnia_id,imie,nazwisko,pesel,wiek) VALUES(4L,6L,'Kasia','Brzeska','998373733',34);
INSERT INTO Klient(id,wypozyczalnia_id,imie,nazwisko,pesel,wiek) VALUES(5L,7L,'Asia','Porębska','998373733',46);
INSERT INTO Klient(id,wypozyczalnia_id,imie,nazwisko,pesel,wiek) VALUES(6L,8L,'Julka','Stefanowicz','998373733',46);
INSERT INTO Klient(id,wypozyczalnia_id,imie,nazwisko,pesel,wiek) VALUES(7L,5L,'Maria','Kowalska','998373733',48);
INSERT INTO Klient(id,wypozyczalnia_id,imie,nazwisko,pesel,wiek) VALUES(8L,1L,'Martyna','Jarosinka','998373733',49);
INSERT INTO Klient(id,wypozyczalnia_id,imie,nazwisko,pesel,wiek) VALUES(9L,10L,'Bożena','Caban','99833733',65);
INSERT INTO Klient(id,wypozyczalnia_id,imie,nazwisko,pesel,wiek) VALUES(10L,9L,'Stefania','Przypierdek','998373733',75);

INSERT INTO Samochod(id,wypozyczalnia_id,marka,model,rok,przebieg,nazwa) VALUES(1L,10L,'Volvo','32',1999,1990,'test1');
INSERT INTO Samochod(id,wypozyczalnia_id,marka,model,rok,przebieg,nazwa) VALUES(2L,9L,'Volvo','32',1999,1990,'test1');
INSERT INTO Samochod(id,wypozyczalnia_id,marka,model,rok,przebieg,nazwa) VALUES(3L,8L,'Volvo','32',1999,1990,'test1');
INSERT INTO Samochod(id,wypozyczalnia_id,marka,model,rok,przebieg,nazwa) VALUES(4L,7L,'Volvo','32',1999,1990,'test1');
INSERT INTO Samochod(id,wypozyczalnia_id,marka,model,rok,przebieg,nazwa) VALUES(5L,6L,'Volvo','32',1999,1990,'test1');
INSERT INTO Samochod(id,wypozyczalnia_id,marka,model,rok,przebieg,nazwa) VALUES(6L,5L,'Volvo','32',1999,1990,'test1');
INSERT INTO Samochod(id,wypozyczalnia_id,marka,model,rok,przebieg,nazwa) VALUES(7L,4L,'Volvo','32',1999,1990,'test1');
INSERT INTO Samochod(id,wypozyczalnia_id,marka,model,rok,przebieg,nazwa) VALUES(8L,3L,'Volvo','32',1999,1990,'test1');
INSERT INTO Samochod(id,wypozyczalnia_id,marka,model,rok,przebieg,nazwa) VALUES(9L,2L,'Volvo','32',1999,1990,'test1');
INSERT INTO Samochod(id,wypozyczalnia_id,marka,model,rok,przebieg,nazwa) VALUES(10L,1L,'Volvo','32',1999,1990,'test1');