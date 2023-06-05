public class Board {
    private int h,w;
    private boolean tab[][]; //true- zywy false martwy

    public Board(int h, int w, boolean[][] tab) {
        this.h = h;
        this.w = w;
        this.tab = tab;
    }
    public int zywiSasiedzi(int x,int y)
    {
        //x-wyskokosc y-szerokosc
        int ile=0;
        int sasiedzi[][] = {{x-1, y-1}, {x-1, y}, {x-1, y+1},
            {x, y-1}, {x, y+1},
            {x+1, y-1}, {x+1, y}, {x+1, y+1}};
        for(int i=0;i<8;++i)
        {
            if(sasiedzi[i][0] >=0 && sasiedzi[i][0]<h && sasiedzi[i][1] >=0 && sasiedzi[i][1]<w)
            {
                if(tab[sasiedzi[i][0]][sasiedzi[i][1]]==true)
                {
                    ile++;
                }
            }
        }
        return ile;
    }
    public void zmiana(int x, int y)
    {
        int iloscZywych=zywiSasiedzi(x,y);
        if(tab[x][y]==true)//jesli jest zywa
        {
            if(iloscZywych<2 || iloscZywych>3)
            {
                tab[x][y]=false;//umiera
            }
        }
        else if(iloscZywych==3) //jesli jest niezywa i ma 3 zywych sasiadow
        {
            tab[x][y]=true;//ozywa
        }
    }
    public void aktualizacja()
    {
        for(int i=0;i<h;++i)
        {
            for(int j=0;j<w;++j)
            {
                zmiana(i,j);
            }
        }
    }

}
