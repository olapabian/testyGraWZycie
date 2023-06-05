# testyGraWZycie
Gra w życie (https://pl.wikipedia.org/wiki/Gra_w_%C5%BCycie). Gra odbywa się w turach, na kwadratowej planszy – wielość planszy ma być ustawiana w konstruktorze. Każde pole planszy może być "żywe" albo "martwe". Stan pola może zmienić się po turze w zależności od stanu jego sąsiadów:

 

1. Jeśli żywa komórka ma mniej niż 2 żywych sąsiadów ginie z samotności

2. Jeżeli żywa komórka ma 2 albo 3 żywych sąsiadów przeżyje do następnej tury

3. Jeżeli żywa komórka ma więcej niż 3 żywych sąsiadów ginie z przeludnienia

4. Jeśli martwa komórka ma dokładnie 3 żywych sąsiadów, ożywa.

 

Przejście do kolejnej tury odbywa się w jednym kroku, czyli określając aktualny stan danej komórki bierze się pod uwagę stany jej i jej sąsiadów z poprzedniej tury (a nie być może częściowo uaktualnione stany z obecnej tury).

 

Napisz program implementujący grę w życie. Ma on zawierać klasę Board zawierającą tablicę reprezentującą planszę – można stworzyć w razie potrzeby również pomocnicze klasy.

Klasa Board ma zwierać metody:

Wyliczającą dla danej komórki (jej współrzędne podane jako argumenty) ilość jej żywych sąsiadów.
Dla podanej komórki (współrzędne podanej jako argument) zmieniającą jej stan w zależności od ilości żywych sąsiadów (ma używać poprzedniej metody).
Metodę w której będzie znajdować się pętla przebiegająca po wszystkich komórkach i aktualizująca ich stan.
 

Napisz klasę testową BoardTest, która będzie testować działanie metod klasy Board. Należy napisać przynajmniej 7 testów (test w rozumieniu sprawdzenie, a niekoniecznie metoda z adnotacją @Test):

Przynajmniej 3 testy dla metody liczącej ilość sąsiadów: dla komórki ze środka planszy, z rogu oraz z brzegu (ale nie rogu) planszy.
Przynajmniej cztery testy dla metody wyliczającej nowy stan komórki (zgodnie z zasadami 1-4).
Można odpisać więcej testów (np. testy metod z podanymi błędnymi współrzędnymi, wyliczanie nowego stanu dla komórek z różnych miejsc planszy).

Dodatkowe uwagi odnośnie pracy domowej:

1. Oceniane będę przeze mnie tylko testy. Oczywiście kod gry musi działać, aby testy przechodziły, ale nie będę za bardzo przeglądać kodu gry (mogę do niego zajrzeć tylko po to aby mieć pewność że rozwiązanie jest samodzielne).

2. Nie trzeba robić żadnego interfejsu graficznego dla gry. Nie trzeba robić nawet interfejsu który będzie rysować planszę na konsoli. Oczywiście jeśli ktoś chce to może to zrobić ale to nie będzie oceniane.

3. Kod w zasadzie nie musi zawierać uruchomienia gry. Kod klasy Board musi zawierać metody takie jak podane są w treści zadania - czyli wyliczanie stanu pojedynczej komórki w następnej generacji oraz dla wszystkich komórek wyliczenie następnego ich stanu. Aby uruchomić grę potrzeba jeszcze metodę która wylicza następny stan dla wszystkich komórek wrzucić w pętlę - nie trzeba tego robić. Oczywiście jeśli Państwo chcą można napisać taką metodę albo dodać pętlę w main() ale nie będzie to oceniane.

4. Na potrzeby testów będzie trzeba wygenerować pożądane stany komórek - np. żywą komórkę która ma 2 żywych sąsiadów itd. Dlatego należy dodać do klasy Board możliwość ustawiania pożądanej stanu komórek, np. możliwość ustawienia dla danych współrzędnych x i y stanu komórki pod tymi współrzędnymi. Wówczas w klasie z testami należy generować sprawdzane układy planszy - można dla każdego testu wygenerować nową planszę albo wygenerować jedną która będzie zawierała wszystkie przypadki. Albo jeszcze w inny sposób rozwiązać ten problem. To zależy od Państwa.
