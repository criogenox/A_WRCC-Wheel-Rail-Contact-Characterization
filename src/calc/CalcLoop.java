package calc;
//
import java.util.Arrays;
import javafx.scene.control.Alert;
import org.apache.commons.lang3.ArrayUtils;
/**
 *
 * @author  Criogenox
 */
public class CalcLoop {
    //
    public double[][] main(double[] dl, double r0, double beta, double s, 
                           double[][] wt, double[][] rt, double[][] railr){
        //
        double[][] p = new double[6][dl.length];
        ////*******************************************////
        //// **** contact points calculation loop **** ////
        ////*******************************************////
        for (int j = 0; j < dl.length; j++) {    
        double d_l = dl[j];
        // roto-traslation of wheel profile
        double[][] wrt= new MatMet().roll(r0, beta, d_l, s, wt[0] , wt[1]);
        // interpolated wheel profile in rail coordinates
        double[][] wts = new Minterp().cubic(wrt,rt[0]);
        // height profile comparison
        double[] pcom = new double[wt[0].length];
        Arrays.setAll(pcom, i -> rt[1][i] - wts[1][i]);
        // max distance between profiles
        double d; int idx;
        double maxPos = Arrays.stream(pcom).filter(a -> a > 0).max().orElse(-1);
        double maxNeg = Arrays.stream(pcom).filter(a -> a < 0).max().orElse(-1);
        //
        if (maxPos == -1) {
           d = maxNeg;
           idx = ArrayUtils.indexOf(pcom, maxNeg);
        } else {
           d = maxPos;
           idx = ArrayUtils.indexOf(pcom, maxPos);
        }
        //
        if (maxNeg == -1) {
           Alert down;
           down = new Alert(Alert.AlertType.ERROR);                    
           down.setTitle("ERROR");
           down.setHeaderText("Check your profile data input!");
           down.setContentText("Click OK to continue");
           down.showAndWait();
           break;
        }
        // set contact point into original track coordinates
        double[][] pi = new MatMet().point(rt[1][idx],d, rt[0][idx], d_l, r0);
        p[0][j] = rt[0][idx];  p[2][j] = pi[0][0];
        p[1][j] = rt[1][idx];  p[3][j] = pi[1][0];
        // rolling contact radio
        double RR = r0 - wts[1][idx]; 
        p[4][j] = RR;
        // contact angle
        double ar = new MatMet().angrol(rt[0], railr[0], railr[1], s, idx);
        p[5][j] = ar; 
        }
        ////*********** end calculation loop ***********////
        return p;
    }
}
