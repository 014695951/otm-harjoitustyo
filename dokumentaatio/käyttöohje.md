# Ohjeet komentoriviltä suoritettaviin toimenpiteisiin: 

* testaus: mvn test
* testiraportin suoritus: mvn jacoco:report
* suoritettavan jarin generointi: mvn package
* checkstyletarkastuksen suorittaminen: mvn jxr:jxr checkstyle:checkstyle

# Ohjelman suorittaminen
* Ohjelman suorittaminen tapahtuu komennolla java -jar asteroidipeli.jar

# Pelin aloittaminen
* Peli alkaa suoraan ohjelman käynnistämisestä

# Pelin lopettaminen
* Pelin voi lopettaa lopeta-painikkeesta, joka näkyy ruudulla aluksen tuhouduttua.

# Tuloksen tallentaminen
* Top-10 pelaajat saavat nimimerkkinsä näkyviin lopetusvalikossa. Mikäli pisteet ovat riittävän korkeat näytölle tulee näkyviin   tekstikenttä, johon nimimerkin voi kirjoittaa (max 25 merkkiä). 

# Aluksen kontrollit:
* alas (S)
* ylös (W)
* oikealle (D)
* vasemmalle (A)
* ampuu (vasen hiiren painike)
* kääntyy (hiirellä)
