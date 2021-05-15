# Vaatimusmäärittely <h1>
## Sovelluksen tarkoitus <h2>
Sovellus on Breakout-peli, jossa pelaaja tuhoaa ruudun yläosassa olevia laatikoita pallon ja alustan avulla. Kun pallo osuu laatikkoon, laatikko tuhoutuu, pelaaja saa pisteen, ja pallo kimpoaa takaisin alas. Kun pallo tulee ruudun alaosaan ja osuu alutaan, pallo kimpoaa takaisin ylös. Jos pallo ei osu alustaan, se putoaa, ja peli päättyy. Peli päättyy myös, kun kaikki laatikot on tuhottu.
## Käyttäjät <h2>
Sovelluksella on vain yhdenlaisia käyttäjiä. Käyttäjä voi pelata peliä. Pelin päätyttyä käyttäjä voi tallettaa pelituloksensa tietokantaan. Käyttäjä voi myös tarkastella aiempia pelituloksia ja tilastoja tietokannasta.
## Toiminnallisuudet <h2>
- sovelluksella on valikko 
    - valikosta käyttäjä voi aloittaa uuden pelin 
    - käyttäjä voi avata pelitulosten tarkastelun
    - käyttäjä voi tarkastella pelin ohjeita
    - käyttäjä voi sulkea sovelluksen 
- käyttäjä voi aloittaa uuden pelin ja pelata pelin
    - Peli luo pelialueen 
    - Peli luo alustan, pallon ja seinän 
    - Pallo lähtee liikkeelle, kun peli alkaa
    - Alusta liikkuu sivuille nuolinäppäimillä 
    - Pallo liikkuu ylös, kunnes törmää seinään / tiileen 
    - Jos pallo osuu seinään, sen sivuttainen kulkusuunta kääntyy
    - Tiili tuhoutuu, kun pallo osuu siihen
    - Peli päättyy, jos pallo putoaa laudan ohi 
    - Peli päättyy, kun kaikki tiilet on tuhottu
- pelin loputtua käyttäjä voi tallettaa tuloksensa tietokantaan
- käyttäjä voi selata tietokannasta aiempia pelituloksia ja tilastoja
## Perusversiota laajentavat jatkokehitysideat <h2>
- käyttäjä voi valita vaikeustason, jolloin pelissä on kenties monimutkaisempi "tiiliseinä" tai suurempi nopeus pallolla tai joitakin esteitä.
- helpotuksena käyttäjä voisi valita leveämmän alustan
- toinen käyttäjäryhmä: ylläpito, joka voi nollata pelitulostiedot
## Toimintaympäristön rajoitteet <h2>
- käyttäjän pelitulokset talletetaan tietokoneessa olevaan tietokantaan
- ohjelmistoa käytetään Linux-käyttöjärjestelmässä 
