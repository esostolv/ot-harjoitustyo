# Testaus
Peliä testattiin automaattisilla JUnit-testeillä yksikkö- ja integraatiotestauksen keinoin. Lisäksi ohjelman toimivuutta testattiin manuaalisesti.

## Yksikkötestaus
Yksikkötestaus suoritettiin ainoastaan sovelluslogiiikasta huolehtivan pakkauksen, *fi.breakout.logics*, luokille *Pad* ja *Ball*. Kumpaakin luokkaa varten on oma testiluokkansa. Muiden luokkien testaus tapahtui integraatiotesteinä. 
## Integraatiotestaus
Sovelluslogiikan luokille suoritettiin integraatiostestejä. Erityisesti luokan *Breakout* testeissä luotiin myös muiden luokkien, kuten *Ball*, *Pad* ja *Wall* olioita, joiden toimintaa ja metodeja testattiin osana luokan *Breakout* testejä. <br>
### Testauskattavuus 
Käyttöliittymän rakentava koodi pakkauksessa *fi.breakout.gui* rajattiin automatisoidun testauksen ulkopuolelle. Testauksen ulkopuolelle jätettiin lisäksi yksinkertaiset getterit ja setterit. 
## Käyttöliittymän testaus
Sovelluksen toimivuutta testattiin lisäksi manuaalisesti sekä paikallisesti Netbeansissa että yliopiston etätyöpöydällä komentorivillä käyttöohjeen kuvaamalla tavalla. 
### Toiminnallisuudet
Sovellus toteuttaa määrittelydokumentissa esitetyt toiminnallisuudet. Sovelluksen toiminnallisuuksissa varmistettiin, että toiminnallisuudet toimivat käyttöohjeessa ohjeistetulla tavalla. <br>

## Laadulliset ongelmat testauksen jälkeen 
