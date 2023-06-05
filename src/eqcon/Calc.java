package eqcon;
//
import static java.lang.Math.abs;
import java.util.Arrays;
/**
 *
 * @author  Criogenox
 */
public class Calc {
    
    public double[] main(double[][] yc, double[] s, double e, double r0, double dy){
        //
        int k = 0;
        double[] ang = new double[yc.length];
        for (double[] yci : yc) {
            int imin = (int) yci[3];
            int imax = (int) yci[4];
            // s(imin:imax)
            double[] si = Arrays.copyOfRange(s, imin, imax+1);
            double[] psi = new double[si.length];
            double C = yci[5];
            // psi= abs(sqrt((-2/(e*r0)).*([s(imin:imax)]-yc(i,6))));
            Arrays.setAll(psi, i -> abs(Math.sqrt(-2/(e*r0)*(si[i]-C)))); 
            // xplot(i)={cumsum([0 2*(dy./(psi(1:end-1)+psi(2:end)))./1000])};
            double[] xplot = new double[si.length];
            int lidx = psi.length;
            for (int j = 0; j < lidx-1; j++){
                xplot[j+1] = 2*(dy/(psi[j]+psi[j+1]))/1000;
            }
            Arrays.parallelPrefix(xplot, 0, xplot.length, (x, y) -> (x + y));
            // lambda(i)=2*xplot{i}(end);            
            double lambda = 2*xplot[lidx-1];
            // ang=((pi./(lambda*1000)).^2).*(2*e*r0);            
            ang[k] = Math.pow((Math.PI/(lambda*1000)),2)*(2*e*r0);
            k=k+1;
        }
    return ang;
    }
}
