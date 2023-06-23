package principal;

import java.util.Scanner;
import java.text.DecimalFormat;
import Calculos.INSS;
import Calculos.IRPF;
import Calculos.Creditos;
import Calculos.Debitos;

public class Tela_Holerite {

    public static void main(String[] args) {

        INSS desc = new INSS();
        IRPF descI = new IRPF();
        Creditos cred = new Creditos();
        Debitos add = new Debitos();
        DecimalFormat df = new DecimalFormat("#,###.00");
        Scanner sc = new Scanner(System.in);

        int a = 0, r = 0, h = 0;
        int resp;

        double sal, horaex, bonus;
        double salm = 1212.00;
        double sal2m = 2427.35;
        double sal3m = 3641.03;
        double sal4m = 7087.22;

        double Sirpf = 1903.98;
        double Sirpf2 = 2826.65;
        double Sirpf3 = 3751.05;
        double Sirpf4 = 4664.68;

        do{
            System.out.printf("\nInforme seu nome: ");
            String nome = sc.nextLine();
            System.out.printf("Infome o Salário: ");
            sal = sc.nextDouble();
            sc.nextLine();
            System.out.printf("Infome a Hora extra: ");
            horaex = sc.nextDouble();
            sc.nextLine();
            System.out.printf("Infome o Bônus (se existir): ");
            bonus = sc.nextDouble();
            sc.nextLine();
                                   
            double a1 = (int) a;
            double a2 = (int) a;
            double r1 = (int) r;
            double h1 = (int) h;

            r1 = cred.VR(sal, salm) + cred.VA(sal, salm) + cred.VT(sal) + cred.ConvenioM(sal, salm);
            h1 = add.CalcHrx(horaex, sal, bonus);

            System.out.println("\n--------------------------------------------------------------");
            System.out.println("|\t\t\t - HOLERITE - \t\t\t\t|");
            System.out.println("--------------------------------------------------------------");
            System.out.println("|\t\t\t\t\t\t\t\t|");
            System.out.printf("|NOME:\t %s \t\t\t\t|%n", nome);
            System.out.println("|\t\t\t\t\t\t\t\t|");
            System.out.printf("|CRÉDITOS: - %.2f \t\t\t\t\t\t|%n", r1);
            System.out.printf("|Salário Bruto:\t R$ %s \t\t\t\t\t|%n", df.format(sal));
            System.out.println("|\t\t\t\t\t\t\t\t|");
            System.out.printf("|DÉBITOS: - %.2f \t\t\t\t\t\t|%n", h1);

            if (sal <= Sirpf) {
                a1 = 0;
                System.out.printf("|Desconto IRFF:\t R$ %.2f \t\t\t\t\t|%n", a1);
            } else if (sal > Sirpf && sal <= Sirpf2) {
                a1 = descI.CalcIRPF1(sal);
                System.out.printf("|Desconto IRFF:\t R$ %.2f \t\t\t\t\t|%n", a1);
            } else if (sal > Sirpf2 && sal <= Sirpf3) {
                a1 = descI.CalcIRPF2(sal);
                System.out.printf("|Desconto IRFF:\t R$ %.2f \t\t\t\t\t|%n", a1);
            } else if (sal > Sirpf3 && sal <= Sirpf4) {
                a1 = descI.CalcIRPF3(sal);
                System.out.printf("|Desconto IRFF:\t R$ %.2f \t\t\t\t\t|%n", a1);
            } else if (sal > Sirpf4) {
                a1 = descI.CalcIRPF4(sal);
                System.out.printf("|Desconto IRFF:\t R$ %.2f \t\t\t\t\t|%n", a1);
            }

            if (sal <= salm) {
                a2 = desc.CalcINSSd1(sal);
                System.out.printf("|Desconto INSS:\t R$ %.2f\t\t\t\t\t|%n", a2);
            } else if (sal > salm && sal <= sal2m) {
                a2 = desc.CalcINSSd2(sal);
                System.out.printf("|Desconto INSS:\t R$ %.2f\t\t\t\t\t|%n", a2);
            } else if (sal > sal2m && sal <= sal3m) {
                a2 = desc.CalcINSSd3(sal);
                System.out.printf("|Desconto INSS:\t R$ %.2f\t\t\t\t\t|%n", a2);
            } else if (sal > sal3m && sal <= sal4m) {
                a2 = desc.CalcINSSd4(sal);
                System.out.printf("|Desconto INSS:\t R$ %.2f\t\t\t\t\t|%n", a2);
            } else if (sal > sal4m) {
                a2 = desc.CalcINSSd4(sal);
                System.out.printf("|Desconto INSS:\t R$ %.2f\t\t\t\t\t|%n", a2);
            }
            
            
            System.out.printf("|Salário Líquido:\tR$ %s \t\t\t\t|%n", df.format((sal + h1) - (r1 + a1 + a2)));
            System.out.println("--------------------------------------------------------------");

            System.out.println("\nDeseja continuar preenchendo holerites?\nDigite S para sim, e N para não");
            resp = sc.next().charAt(0);
            sc.nextLine();
            
        }while (resp == 's'||resp == 'S');
    }
}
