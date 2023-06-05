package eqcon;
//
import static java.lang.Math.abs;
import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;
/**
 *
 * @author  Criogenox
 */
public class DefMat {
    
    public double[][] main(double[][] yemm){
        //
        double[] yemmone = new double[yemm.length];
        Arrays.setAll(yemmone, i -> abs(yemm[i][0] - 1)); 
        double minone = Arrays.stream(yemmone).min().orElse(-1);
        int idone = ArrayUtils.indexOf(yemmone, minone);
        double[][] yc = new double[idone+1][6];
        for (int i = 0; i < idone+1; i++) {
            yc[i] = yemm[idone-i].clone();
        }
    return yc;
    }    
}
