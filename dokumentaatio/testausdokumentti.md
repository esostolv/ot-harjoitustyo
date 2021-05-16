# Testaus
Peliä testattiin automaattisilla JUnit-testeillä yksikkö- ja integraatiotestauksen keinoin. Lisäksi ohjelman toimivuutta testattiin manuaalisesti.

## Yksikkötestaus
Yksikkötestaus suoritettiin ainoastaan sovelluslogiiikasta huolehtivan pakkauksen, *fi.breakout.logics*, luokille *Pad* ja *Ball* sekä tilastopakkauksen *fi.breakout.dao* luokalle *Statistics*. Jokaista testattua luokkaa varten on oma testiluokkansa. Muiden luokkien testaus tapahtui integraatiotesteinä. 
## Integraatiotestaus
Sovelluslogiikan luokille suoritettiin integraatiostestejä. Erityisesti luokan *Breakout* testeissä luotiin myös muiden luokkien, kuten *Ball*, *Pad* ja *Wall* olioita, joiden toimintaa ja metodeja testattiin osana luokan *Breakout* testejä. <br>
### Testauskattavuus 
Käyttöliittymän rakentava koodi pakkauksessa *fi.breakout.gui* rajattiin automatisoidun testauksen ulkopuolelle. Testauksen ulkopuolelle jätettiin lisäksi yksinkertaiset getterit ja setterit.<br>
<br> Ohjelman testauksen rivikattavuus oli 93 % ja haarautumakattavuus 91 %, eli kumpikin on varsin korkeat. <br>
![jacoco](https://user-images.githubusercontent.com/73749539/118395338-7d424280-b652-11eb-85dd-44f2d536f4a7.png)


## Käyttöliittymän testaus
Sovelluksen toimivuutta testattiin lisäksi manuaalisesti sekä paikallisesti Netbeansissa että yliopiston etätyöpöydällä komentorivillä käyttöohjeen kuvaamalla tavalla. Peliä yritettiin pelata erilaisin tuloksin, ja pelituloksia talletettiin tietokantaan. 
### Toiminnallisuudet
Sovellus toteuttaa määrittelydokumentissa esitetyt toiminnallisuudet. Sovelluksen toiminnallisuuksissa varmistettiin, että toiminnallisuudet toimivat käyttöohjeessa ohjeistetulla tavalla. <br>

## Laadulliset ongelmat testauksen jälkeen 
Testauksessa olisi voitu hyödyntää vielä monipuolisemmin integraatiotestejä. Nyt tietokannan toimintaa testattiin vain valmiilla syötteillä yksikkötesteinä, eikä lainkaan integraatiotesteinä *Breakout*-luokan kanssa. 
