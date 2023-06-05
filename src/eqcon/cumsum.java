package eqcon;
//
import com.google.common.primitives.Doubles;
import java.util.Arrays;
/**
 *
 * @author  Criogenox
 */
public class cumsum {

    public double[] main(double[] arr1, int idx) {
        //
        // custom Riemann sum (according to EN15302 Standard - Annex B.2 step b)
        double[] arri = Arrays.copyOfRange(arr1, 0, idx+1);
        double[] arrd = Arrays.copyOfRange(arr1, idx+1,arr1.length);
        double[] arrinv = new VecOp().reverse(arri);
        double dy = 0.1;
        double[] arrinvdy = new double[arrinv.length];
        Arrays.setAll(arrinvdy, i -> -dy*arrinv[i]);
        double[] arrddy = new double[arrd.length];
        Arrays.setAll(arrddy, i -> dy*arrd[i]);
        Arrays.parallelPrefix(arrinvdy, 0, arrinvdy.length, (x, y) -> (x + y));
        Arrays.parallelPrefix(arrddy, 0, arrddy.length, (x, y) -> (x + y));
        double[] arridy = new VecOp().reverse(arrinvdy);
        double[] s = Doubles.concat(arridy, arrddy);
    return s;
    }
}
