package calc;
//
import static java.lang.Math.abs;
import static java.lang.Math.acos;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import java.util.Arrays;
/**
 * 
 * @author  Criogenox
 */
public class MatMet {
    //***
    public double[][] multm(double[][] A, double[][] B){
        //
        int newrow1 = A.length;
        int newrow2 = B.length;
        int newcol2 = B[0].length;
        int i, j, k;
        double C[][] = new double[newrow1][newcol2];
        // 
        for (i = 0; i < newrow1; i++) {
            for (j = 0; j < newcol2; j++) {
                for (k = 0; k < newrow2; k++)
                    C[i][j] += A[i][k] * B[k][j];
            }
        }
        return C;
    }
    //***
    double g;
    public double[][] roll(double r0, double ce, double d_l, double s, 
                           double[] y, double[] z){  
        //
        g = (ce*(d_l/1000))/(s-r0*ce);
        double[][] Rg = {{cos(g), -sin(g)}, {sin(g), cos(g)}};
        double[] zr0 = new double[z.length];
        Arrays.setAll(zr0, i -> z[i] - r0);
        double[][] zy = {y,zr0};
        double[][] wR = multm(Rg,zy);
        double[] yr = new double[wR[0].length];
        double[] zr = new double[yr.length];
        Arrays.setAll(yr, i -> wR[0][i]+(d_l+r0*g));
        Arrays.setAll(zr, i -> wR[1][i]+ r0);
        double[][] zyr = {yr,zr};
        //   
        return zyr; 
    }
    //***
    public double[][] inverse(double[][] mat){
        //	
        double[][] temp = mat;
        double det = temp[0][0]*temp[1][1] - temp[0][1]*temp[1][0];
        if(det==0.0)throw new IllegalArgumentException("Matrix is singular");
        double[][] inv = new double[2][2];
        inv[0][0] = temp[1][1]/det;
        inv[1][1] = temp[0][0]/det;
        inv[1][0] = -temp[1][0]/det;
        inv[0][1] = -temp[0][1]/det;
        //      
        return inv;
    	}
    //***
    public double[][] point(double zp,double v, double yp, double d_l, double r0){
        //
        double[][] Rg = {{cos(g), -sin(g)}, {sin(g), cos(g)}};
        double[][] RgI = inverse(Rg);
        double[][] temp = {{yp-d_l-r0*g},{zp-v-r0}}; 
        double[][] Rt = multm(RgI,temp);
        //
        double[][] p = {{Rt[0][0]},{Rt[1][0]+r0}};
        //
        return p;
    }
    //***
    public double angrol(double[] yi, double[] y, double[] z, double s, int r){
        //
        double x0 = yi[r];
        double y0 = z[r];
        double t = (z[r+2]-z[r])/(yi[r+2] - yi[r]);
        double[] ra = new double[y.length]; // horizontal reference line
        Arrays.setAll(ra, i -> t*(y[i]+s-x0)+y0);
        double[] vd1={y[1] - y[0], ra[1] - ra[0]};
        double[] vd2={y[1] - y[0], y0 - y0};
        double a = abs(dot(vd1,vd2));
        double b = Math.pow(vd1[0],2)+ Math.pow(vd1[1],2);        
        double c = Math.pow(vd2[0],2)+ Math.pow(vd2[1],2);
        double rad = acos(a/Math.pow((b*c),0.5));
        //
        return rad;
    }
    //***
    public double dot(double x[], double y[]){
        //
        if(x.length != y.length)
           throw new RuntimeException("Arrays must be same size");
        double sum = 0;
            for(int i = 0; i < x.length; i++){
                sum += x[i] * y[i];
            }
       return sum;
    }
}