# Arkkitehtuurikuvaus
# Ohjelman rakenne
Ohjelman rakenteessa sovelluslogiikka on erotettu omaan pakkaukseensa *logic*, ja JavaFX:llä toteutettu käyttöliittymä omaan pakkaukseensa *gui*. Tiedon pysyväistalletus toteutetaan tietokannan avulla pakkauksessa *dao*. <br>
![Pakkauskaavio](https://user-images.githubusercontent.com/73749539/118396690-4d4a6d80-b659-11eb-9b54-00665cc354a3.png)


# Käyttöliittymä
Käyttöliittymä on toteutettu JavaFX:llä. Siinä on neljä erilaista näkymää *scene*-olioina: päävalikko, pelitila, pelitulosten tarkastelu sekä pelin ohjeet. Näkymistä yksi kerrallaan on sijoitettuna näkyviin stage-olioon. <br>
<br> Luokka *main* on sovelluksen pääluokka, josta käynnistetään varsinainen käyttöliittymä luokassa *ui*. *Main*-luokka on olemassa, jotta generoitavan -jar-tiedoston pääluokka ei perisi JavaFX:n luokkaa *Application*. <br>
<br> Luokassa *ui* tapahtuu käyttöliittymän luonti. Jokainen käyttöliittymän neljästä näkymästä luodaan omassa metodissaan. 
# Sovelluslogiikka
Sovelluslogiikka on sijoitettu yhden pakkauksen sisään. Luokka *Breakout* käsittelee pelin tapahtumat ja luo pelissä tarvittavat oliot: pallon, alustan ja tiiliseinän. <br>
<br> Luokat *Ball*, *Pad* ja *Wall* ovat pallon, alustan ja tiilten luontia varten: kukin luokka luo kyseisen olion ja oliota vastaavan muodon. Lisäksi luokat sisältävät metodit pallon ja alustan liikuttamiseen. 
Ohjelman luokkakaavio:<br>
![Luokkakaavio2](https://user-images.githubusercontent.com/73749539/117053625-dab8c400-ad21-11eb-82ea-07276bd53b50.png)
# Tiedon pysyväistalletus
Tietojen pysyväistalletus tapahtuu pakkauksen *breakout.dao* luokassa *Statistics*. Tiedon pysyväistalletus on toteutettu SQLite-tietokannan avulla. Sovelluksen käynnistyessä hakemistoon luodaan tarvittaessa uusi tietokantatiedosto. Pelin päätyttyä käyttäjä voi halutessaan tallettaa pelituloksensa ja nimimerkkinsä tietokantaan. 
# Päätoiminnallisuudet
Pelin alustuksen toiminnallisuutta kuvataan sekvenssikaavion avulla. Sekvenssikaaviossa on kuvattu ohjelmassa pelialustan luominen ja pallo-olion luominen peliin. Vastaavalla tavalla luodaan myös alusta sekä tiiliseinä peliä varten. <br>

![Breakout](https://user-images.githubusercontent.com/73749539/117054328-a7c30000-ad22-11eb-9b68-3a32d672c190.png)

Varsinainen pelin tapahtumien käsittely toteutetaan *Ui*-luokassa AnimationTimer()-tapahtumankäsittelijällä. Jokaisessa tapahtumankäsittelyssä toistuu seuraavat asiat: alustan liikuttaminen, pallon liikuttaminen, törmäyksen tarkistaminen, pallon putoamisen tarkistaminen. Tapahtumakierros, jossa pallo hajottaa tiilen, on kuvattu sekvenssikaaviona. Metodeihin liittyvien if-lauseiden haarat on jätetty pois kaavion selkeyttämisen vuoksi.<br> 
![Sekvenssikaavio3](https://user-images.githubusercontent.com/73749539/118378154-6102bf00-b5da-11eb-8c9d-878193dd2b4e.png)

# Ohjelman rakenteen heikkoudet
Pelin moottorina toimiva tapahtumankäsittely toteutetaan AnimationTimer()-metodin avulla käyttöliittymäluokassa *Ui*, vaikka kyseessä on enemmän sovelluslogiikkaan liittyvä ominaisuus, joka pitäisi käsitellä pakkauksen *logics* alla. <br>
<br> Sovelluksen käyttöliittymän luova luokka on kohtuuttoman pitkä, sillä luokassa on lukuisia metodeita eri näkymien luomiseen. Nämä olisi järkevää erottaa omiksi luokikseen, tai ainakin ryhmitellä pariin-kolmeen pienempään luokkaan. <br
<br> Ohjelman parametrit, kuten pelialueen olioiden mitat ja paikat, ovat sovelluksen koodissa nyt kovakoodattuina vakioina. Ohjelman laajentamisen kannalta näiden olisi hyvä olla erillisessä konfiguraatiotiedostossa, josta niitä olisi helppo tarvittaessa muokata. 


