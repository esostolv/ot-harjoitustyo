# Käyttöohje

## Ohjelman käynnistäminen 
Lataa uusimmasta releasesta jar-tiedosto tietokoneellesi. Ohjelma voidaan käynnistää komentorivillä jar-tiedoston tallennushakemistossa komennolla *java -jar breakout.jar*. <br>
<br>
Toinen mahdollisuus ohjelman käynnistämiseen on ladata uusimmasta releasesta projekti zip-tiedostona, jolloin ohjelma voidaan suorittaa komentorivillä projektin juurikansiossa komennolla *mvn compile exec:java -Dexec.mainClass=fi.breakout.gui.Main*


## Päävalikko
Kun ohjelma käynnistetään, aukeaa päävalikko. Valikosta voi aloittaa uuden pelin, tarkastella aiempia pelituloksia, lukea pelin ohjeet sekä sulkea sovelluksen. <br>
![menu](https://user-images.githubusercontent.com/73749539/117052694-b3adc280-ad20-11eb-8faa-4532a829aae3.png)


## Peli
Pelin tarkoituksena on tuhota ruudun yläreunassa oleva tiiliseinä pallon avulla. Pallon suuntaa ohjaillaan ruudun alareunassa liikkuvan alustan avulla. <br>
![Breakout1](https://user-images.githubusercontent.com/73749539/117052715-b9a3a380-ad20-11eb-8cad-487b98df114a.png)

<br>
Peli käynnistyy heti, kun päävalikosta valitaan "Uusi peli". Tällöin pallo lähtee liikkumaan ylöspäin kohti tiiliseinää. Kun pallo osuu tiileen, tiili tuhoutuu,
ja pallon suunta muuttuu kohti alustaa. Kun pallo osuu alustaan, pallo kimpoaa takaisin ylöspäin. Pelaaja voi ohjailla alustaa sivusuunnassa nuolinäppäimillä. Peli päättyy, kun kaikki tiilet on tuhottu tai kun pallo putoaa alas alustan ohi.<br>
<br>
Pelin jälkeen avautuvasta valikosta voi tallettaa pelituloksen. Tällöin ohjelma pyytää käyttäjältä syötteenä käyttäjän nimen, ja ohjelma tallettaa nimen ja pistemäärän tietokantaan.<br> 
<br> ![saveresult](https://user-images.githubusercontent.com/73749539/118395465-3b65cc00-b653-11eb-8f5a-cc009ae16e07.png)

## Aiempien tulosten tarkastelu

Päävalikosta voi valita painikkeesta *Tilastot* aiempien tulosten tarkastelun. Sivulla näkyy enintään kymmenen parasta tulosta, sekä kaikkien tulosten keskiarvo. <br>
<br> ![stats](https://user-images.githubusercontent.com/73749539/118395437-25f0a200-b653-11eb-8fd5-e99b9778ddb4.png)


