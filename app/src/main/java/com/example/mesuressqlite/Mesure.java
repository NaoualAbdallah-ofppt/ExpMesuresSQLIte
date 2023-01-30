package com.example.mesuressqlite;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class Mesure {
    public Mesure(Date dateM, Float poidsM) {
        DateM = dateM;
        PoidsM = poidsM;
    }

    Date DateM;

    @Override
    public String toString() {
GregorianCalendar GC = new GregorianCalendar();
GC.setTime(DateM);
        int mois=GC.get(GregorianCalendar.MONTH) + 1;
        int annee=GC.get(GregorianCalendar.YEAR) ;
        int jour=GC.get(GregorianCalendar.DATE);
        int heu = GC.get(GregorianCalendar.HOUR);
        return "Le : " +
                jour  + "/" + mois + "/" + annee +" at " + heu + " h : "
                + PoidsM +
                " Kg";
    }

    public void setDateM(Date dateM) {
        DateM = dateM;
    }

    public void setPoidsM(Float poidsM) {
        PoidsM = poidsM;
    }

    public Date getDateM() {
        return DateM;
    }

    public Float getPoidsM() {
        return PoidsM;


    }


    Float PoidsM;

}
