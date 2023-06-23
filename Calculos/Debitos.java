package Calculos;

public class Debitos {
    public double CalcHrx(double horaex, double sal, double bonus){
        
        double multH = ((sal / 22) / 8) * 0.50;
        
        double valhex = bonus + (multH * horaex);
        
        return valhex;
    }
}
