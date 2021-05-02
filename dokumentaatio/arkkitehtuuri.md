# Arkkitehtuurikuvaus
# Ohjelman rakenne
Ohjelman rakenteessa sovelluslogiikka on erotettu omaan pakkaukseensa *logic*, ja JavaFX:llä toteutettu käyttöliittymä omaan pakkaukseensa *gui*.

# Käyttöliittymä
Käyttöliittymä on toteutettu JavaFX:llä. Siinä on neljä erilaista näkymää *scene*-olioina: päävalikko, pelitila, pelitulosten tarkastelu sekä pelin ohjeet. Näkymistä yksi kerrallaan on sijoitettuna näkyviin stage-olioon. <br>
<br> Luokka *main* on sovelluksen pääluokka, josta käynnistetään varsinainen käyttöliittymä luokassa *ui*. *Main*-luokka on olemassa, jotta generoitavan -jar-tiedoston pääluokka ei perisi JavaFX:n luokkaa *Application*. <br>
<br> Luokassa *ui* tapahtuu käyttöliittymän luonti. Jokainen käyttöliittymän neljästä näkymästä luodaan omassa metodissaan. 
# Sovelluslogiikka
Ohjelman luokkakaavio:
![Luokkakaavio](https://user-images.githubusercontent.com/73749539/115287940-84605880-a159-11eb-9321-f628d73d1918.png)

# Päätoiminnallisuudet
Pelin alustuksen toiminnallisuutta kuvataan sekvenssikaavion avulla. Sekvenssikaaviossa on kuvattu ohjelmassa pelialustan luominen ja pallo-olion luominen peliin. Vastaavalla tavalla luodaan myös alusta sekä tiiliseinä peliä varten. <br>

![Sekvenssikaavio2](https://user-images.githubusercontent.com/73749539/116285659-06263680-a797-11eb-80bc-7f61f30ffd8f.png)


