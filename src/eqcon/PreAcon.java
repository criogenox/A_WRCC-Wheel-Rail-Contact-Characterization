package eqcon;
//
import static java.lang.Math.abs;
import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;
/**
 *
 * @author  Criogenox
 */
public class PreAcon {
    
    public double[][] main(double[] s, double[] yii, int cas){
        //
        int idmins;
        if (cas == 1){
          // min dr>=0 (dr~0)
          double mins = Arrays.stream(s).filter(a -> a > 0).min().orElse(-1);
          // idx for dr~0
          idmins = ArrayUtils.indexOf(s, mins);
        } else {
            if (s.length%2 == 0){
               idmins = (s.length)/2;
            } else { 
               idmins = (s.length-1)/2;
            }
        }
        //
        double[] sip = Arrays.copyOfRange(s, idmins,s.length);
        double[] sipc = new double[sip.length];
        double[][] yemm = new double[idmins-1][6];
        for (int j = 0; j < idmins-1; j++){
            double si = s[j];
            Arrays.setAll(sipc, i -> abs(sip[i] - si));   
            double minsipc = Arrays.stream(sipc).filter(a -> a > 0).min().
                             orElse(-1);
            int idxd = ArrayUtils.indexOf(sipc, minsipc);
            yemm[j][0] = (yii[idxd+idmins-1] - yii[j])/2;
            yemm[j][1] = yii[j];
            yemm[j][2] = yii[idxd+idmins-1];
            yemm[j][3] = j;
            yemm[j][4] = idxd+idmins-1;
            yemm[j][5] = s[j];               
        }
    return yemm;
    }
}
