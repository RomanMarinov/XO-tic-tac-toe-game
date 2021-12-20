package com.dev_marinov.xo;

import android.content.Context;

class GamePlayersPC_test {
    Context con;
    String par1,par2;
    onGetXod  onGetXod;

    public GamePlayersPC_test(Context con, String par1, String par2) {
        this.con = con;
        this.par1 = par1;
        this.par2 = par2;
    }



    public void xod(int t1,int t2,String player)
    {
        //Рассчёт

        onGetXod.onGetXod(t1*t2,"X111");
    }


    interface onGetXod
    {
        void onGetXod(int par1,String id);

    }


    public void setOnGet(onGetXod onGetXod)
    {
        this.onGetXod = onGetXod;
    }


}
