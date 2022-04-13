package sk.stuba.fei.uim.oop;



public class Hra {
    int velkostHracejPlochy=6;
    public Hra() {
        Okno okno = new Okno(velkostHracejPlochy);
        HraciaPlocha plocha = new HraciaPlocha(velkostHracejPlochy,okno);
    }


}
