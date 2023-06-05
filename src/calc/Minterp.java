package calc;
//
import smile.interpolation.CubicSplineInterpolation1D;
/**
 *
 * @author  Criogenox
 */
public class Minterp {
    //
    public double[][] cubic(double[][] xy, double[] yr){
        //
        var cubic = new CubicSplineInterpolation1D(xy[0], xy[1]);
        //
        double[][] data = new double[2][yr.length];
        for (int i = 0; i < yr.length; i++) {
          data[0][i] = yr[i];
          data[1][i] = cubic.interpolate(yr[i]);
        }
        return data;
    }
}

