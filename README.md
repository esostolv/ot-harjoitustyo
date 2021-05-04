# Breakout
Breakout on peli, jossa pelaaja pyrkii hajottamaan tiiliseinää pallon avulla. Palloa ohjaillaan oikeaan suuntaan liikuttelemalla ruudun alareunassa olevaa alustaa.  
## Dokumentaatio 
[Käyttöohje](https://github.com/esostolv/ot-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md)<br>
[Vaativuusmäärittely](https://github.com/esostolv/ot-harjoitustyo/blob/master/dokumentaatio/vaativuusmaarittely.md) <br>
[Arkkitehtuurikuvaus](https://github.com/esostolv/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md) <br>
[Työaikakirjanpito](https://github.com/esostolv/ot-harjoitustyo/blob/master/dokumentaatio/tyoaikakirjanpito.md) <br>
## Releaset
[Viikko5](https://github.com/esostolv/ot-harjoitustyo/releases/tag/viikko5)
## Komentoriviohjeet
### Testaus
Testit suoritetaan komentorivillä komennolla "*mvn test*" <br>
Testauskattavuusraportti luodaan komentorivillä komennolla "*mvn jacoco:report*" <br> 
Testikattavuusraportti löytyy tiedostona nimellä *index.html* hakemistosta *target/site/jacoco* <br>
### Suoritettavan jarin generointi
Jar-tiedosto voidaan generoida komentorivillä komennolla "*mvn package*" <br>
### Checkstyle-tarkastus
Checkstyle-tarkastukset suoritetaan komentorivillä komennolla "*mvn jxr:jxr checkstyle:checkstyle*" <br>
Checkstyle-raportti löytyy tiedostona nimellä *checkstyle.html* hakemistosta *target/site* <br>
### Javadocin generointi
Javadoc-raportti voidaan generoida komentorivillä komennolla "*mvn javadoc:javadoc*" <br>
Javadoc-raportti löytyy tiedostona nimellä *index.html* hakemistosta *target/site/apidocs*
