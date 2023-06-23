package Calculos;

public class Creditos {
    public double VR(double sal, double salm){
        
        double VRd = 0;
        
        if (sal >= salm){
            VRd = sal * 0.03;
        }
                                
        return VRd;
    }
    public double VA(double sal, double salm){
        
        double salm3x = salm * 3;
        double VAd = 0;
        
        if (sal >= salm3x){
            VAd = sal * 0.02;
        }
                        
        return VAd;
    }
    public double VT(double sal){
        
        double VTd = sal * 0.06;
        
        return VTd;
    }
    public double ConvenioM(double sal, double salm){
                        
        double ConvM = 0;
        
        if (sal >= salm){
            ConvM = sal * 0.04;
        }
                       
        return ConvM;
    }
}
