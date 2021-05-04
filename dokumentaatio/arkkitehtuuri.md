# Arkkitehtuurikuvaus
# Ohjelman rakenne
Ohjelman rakenteessa sovelluslogiikka on erotettu omaan pakkaukseensa *logic*, ja JavaFX:llä toteutettu käyttöliittymä omaan pakkaukseensa *gui*. <br>
![Pakkauskaavio](https://user-images.githubusercontent.com/73749539/117053177-50706000-ad21-11eb-9563-431832626863.png)

# Käyttöliittymä
Käyttöliittymä on toteutettu JavaFX:llä. Siinä on neljä erilaista näkymää *scene*-olioina: päävalikko, pelitila, pelitulosten tarkastelu sekä pelin ohjeet. Näkymistä yksi kerrallaan on sijoitettuna näkyviin stage-olioon. <br>
<br> Luokka *main* on sovelluksen pääluokka, josta käynnistetään varsinainen käyttöliittymä luokassa *ui*. *Main*-luokka on olemassa, jotta generoitavan -jar-tiedoston pääluokka ei perisi JavaFX:n luokkaa *Application*. <br>
<br> Luokassa *ui* tapahtuu käyttöliittymän luonti. Jokainen käyttöliittymän neljästä näkymästä luodaan omassa metodissaan. 
# Sovelluslogiikka
Sovelluslogiikka on sijoitettu yhden pakkauksen sisään. Luokka *Breakout* käsittelee pelin tapahtumat ja luo pelissä tarvittavat oliot: pallon, alustan ja tiiliseinän. <br>
<br> Luokat *Ball*, *Pad* ja *Wall* ovat pallon, alustan ja tiilten luontia varten: kukin luokka luo kyseisen olion ja oliota vastaavan muodon. Lisäksi luokat sisältävät metodit pallon ja alustan liikuttamiseen. 
Ohjelman luokkakaavio:<br>
![Luokkakaavio2](https://user-images.githubusercontent.com/73749539/117053625-dab8c400-ad21-11eb-82ea-07276bd53b50.png)

# Päätoiminnallisuudet
Pelin alustuksen toiminnallisuutta kuvataan sekvenssikaavion avulla. Sekvenssikaaviossa on kuvattu ohjelmassa pelialustan luominen ja pallo-olion luominen peliin. Vastaavalla tavalla luodaan myös alusta sekä tiiliseinä peliä varten. <br>

![Breakout](https://user-images.githubusercontent.com/73749539/117054328-a7c30000-ad22-11eb-9b68-3a32d672c190.png)



