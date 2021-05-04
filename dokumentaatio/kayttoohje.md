
# Ohjelman käynnistäminen 
Ohjelma voidaan käynnistää komentorivillä komennolla java -jar breakout.jar

## Päävalikko
Kun ohjelma käynnistetään, aukeaa päävalikko. Valikosta voi aloittaa uuden pelin, tarkastella aiempia pelituloksia, lukea pelin ohjeet sekä sulkea sovelluksen.

## Peli
Pelin tarkoituksena on tuhota ruudun yläreunassa oleva tiiliseinä pallon avulla. Pallon suuntaa ohjaillaan ruudun alareunassa liikkuvan alustan avulla. <br>
![Breakout1](https://user-images.githubusercontent.com/73749539/117026227-4724ca80-ad04-11eb-9325-193e72d3d433.png)
<br>
Peli käynnistyy heti, kun päävalikosta valitaan "Uusi peli". Tällöin pallo lähtee liikkumaan ylöspäin kohti tiiliseinää. Kun pallo osuu tiileen, tiili tuhoutuu,
ja pallon suunta muuttuu kohti alustaa. Kun pallo osuu alustaan, pallo kimpoaa takaisin ylöspäin. Pelaaja voi ohjailla alustaa sivusuunnassa nuolinäppäimillä. Peli päättyy, kun kaikki tiilet on tuhottu tai kun pallo putoaa alas alustan ohi.

## Aiempien tulosten tarkastelu


