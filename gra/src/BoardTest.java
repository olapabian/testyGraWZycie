import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardTest {
    @Test //srodkowa komowrka
    public void testZywiSasiedziSrodek()
    {
        boolean tab[][]={{false,false,true},
                        {false,true,false},
                        {true,true,true}};
        Board board = new Board(3,3,tab);
        int liveNeighbors = board.zywiSasiedzi(1, 1);
        assertEquals(4, liveNeighbors);
    }
    @Test // komorka w rogu
    public void testZywiSasiedziRog()
    {
        //wyskokosc y-szerokosc
        boolean tab[][]={{false,false,true,false},    //|
                        {false,true,false,true},      //|x
                        {true,true,true,false}};      //|
                        //________________________
                                  //y
        Board board = new Board(3,4,tab);
        int liveNeighbors = board.zywiSasiedzi(2, 3);
        assertEquals(2, liveNeighbors);
    }
    @Test // komorka z boku
    public void testZywiSasiedziBok()
    {
        boolean tab[][]={{false,false,true,false},
                        {false,true,false,true},
                        {true,true,true,false}};
        Board board = new Board(3,4,tab);
        int liveNeighbors = board.zywiSasiedzi(2, 1);
        assertEquals(3, liveNeighbors);
    }
    @Test // Jeśli żywa komórka ma mniej niż 2 żywych sąsiadów ginie z samotności
    public void testZmiana1()
    {
        //dla jednego zapalonego
        boolean tab[][]={{false,false,true/*ta ma sie zmienic na false*/,false},
                        {false,false,true,false},
                        {true,true,true,false}};
        Board board = new Board(3,4,tab);
        board.zmiana(0, 2);
        assertEquals(false, tab[0][2]);
        //dla zadnego nie zapalonego
        boolean tab2[][]={{false,false,true/*ta ma sie zmienic na false*/,false},
                        {false,false,false,false},
                        {true,true,true,false}};
        Board board2 = new Board(3,4,tab2);
        board.zmiana(0, 2);
        assertEquals(false, tab[0][2]);
    }
    @Test // Jeżeli żywa komórka ma 2 albo 3 żywych sąsiadów przeżyje do następnej tury
    public void testZmiana2()
    {
        //dla 2 zapalonych sasiadow
        boolean tab[][]={{false,false,true,false},
                {false,false,true,false},
                {true,true,true/*ta ma sie nie zmienic*/,false}};
        Board board = new Board(3,4,tab);
        board.zmiana(2, 2);
        assertEquals(true, tab[2][2]);
        //dla 3 zapalonych sasiadow
        boolean tab2[][]={{false,false,true,false},
                {false,false,true,false},
                {true,true,true/*ta ma sie nie zmienic*/,true}};
        Board board2 = new Board(3,4,tab2);
        board.zmiana(2, 2);
        assertEquals(true, tab[2][2]);
    }
    @Test//Jeżeli żywa komórka ma więcej niż 3 żywych sąsiadów ginie z przeludnienia
    public void testZmiana3()
    {
        //dla 4 zapalonych sasiadow
        boolean tab[][]={{false,false,true,false},
                        {false,false,true,true},
                        {true,true,true/*ta ma sie  zmienic na flase*/,true}};
        Board board = new Board(3,4,tab);
        board.zmiana(2, 2);
        assertEquals(false, tab[2][2]);
    }
    @Test//Jeśli martwa komórka ma dokładnie 3 żywych sąsiadów, ożywa.
    public void testZmiana4()
    {
        //dla 3 zapalonych sasiadow
        boolean tab[][]={{false,false,true,false},
                {false,false,true,false},
                {true,true,false/*ta ma sie  zmienic na true*/,true}};
        Board board = new Board(3,4,tab);
        board.zmiana(2, 2);
        assertEquals(true, tab[2][2]);
    }
}
