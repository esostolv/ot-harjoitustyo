# Breakout
Breakout on peli, jossa pelaaja pyrkii hajottamaan tiiliseinää pallon avulla. Palloa ohjaillaan oikeaan suuntaan liikuttelemalla ruudun alareunassa olevaa alustaa.  
## Dokumentaatio 
[Vaativuusmäärittely](https://github.com/esostolv/ot-harjoitustyo/blob/master/dokumentaatio/vaativuusmaarittely.md) <br>
[Arkkitehtuurikuvaus](https://github.com/esostolv/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md) <br>
[Työaikakirjanpito](https://github.com/esostolv/ot-harjoitustyo/blob/master/dokumentaatio/tyoaikakirjanpito.md) <br>
## Komentoriviohjeet
### Testaus
Testit suoritetaan komentorivillä komennolla mvn test <br>
Testauskattavuusraportti luodaan komentorivillä komennolla mvn jacoco:report <br> 
### Suoritettavan jarin generointi
Jar-tiedosto voidaan generoida komentorivillä komennolla mvn package <br>
### Checkstyle-tarkastus
Checkstyle-tarkastukset suoritetaan komentorivillä komennolla  mvn jxr:jxr checkstyle:checkstyle
