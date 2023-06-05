package eqcon;

import smile.interpolation.CubicSplineInterpolation1D;
/**
 *
 * @author  Criogenox
 */
public class Vinterp {
    //
    public double[] cubic(double[] s0, double[] yi, double[] yii){
        //
        var cubic = new CubicSplineInterpolation1D(yi, s0);
        //
        double[] data = new double[yii.length];
        for (int i = 0; i < yii.length; i++) {
            data[i] = cubic.interpolate(yii[i]);
        }
        return data;
    }
}

