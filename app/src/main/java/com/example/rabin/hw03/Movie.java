package com.example.rabin.hw03;

import android.support.annotation.NonNull;
import android.widget.Toast;

import java.io.Serializable;

public class Movie implements Serializable {
    String sname, sdesc, sgenre, svalue, syear, simdb;


    public Movie() {
        this.sname = sname;
        this.sdesc = sdesc;
        this.sgenre = sgenre;
        this.svalue = svalue;
        this.syear = syear;
        this.simdb = simdb;

    }

    public String getSname() {
        return sname;

    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSdesc() {
        return sdesc;
    }

    public void setSdesc(String sdesc) {
        this.sdesc = sdesc;
    }

    public String getSgenre() {
        return sgenre;
    }

    public void setSgenre(String sgenre) {
        this.sgenre = sgenre;
    }

    public String getSvalue() {
        return svalue;
    }

    public void setSvalue(String svalue) {
        this.svalue = svalue;
    }

    public String getSyear() {
        return syear;
    }

    public void setSyear(String syear) {
        this.syear = syear;
    }

    public String getSimdb() {
        return simdb;
    }

    public void setSimdb(String simdb) {
        this.simdb = simdb;
    }

    public String toString() {
        return "Movie{" +
                "sname='" + sname + '\'' +
                ", sdesc='" + sdesc + '\'' +
                ", sgenre='" + sgenre + '\'' +
                ", svalue='" + svalue + '\'' +
                ", syear='" + syear + '\'' +
                ", simdb='" + simdb + '\'' +
                '}';
    }


}
