package eqcon.mvnver;
//

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @author Criogenox
 */
public class PreCalc {
    public double[][] main(double[] yi0, double[] dr, int cas, double e, double r0) {

        int idx;
        // min dr>=0 (dr~0)
        double minPos = Arrays.stream(dr).filter(a -> a > 0).min().orElse(-1);
        // idx for dr~0
        idx = ArrayUtils.indexOf(dr, minPos);
        // s(y) function calculation
        double[] s0 = new cumsum().main(dr, idx);
        // choose case (1 asymmetric / 2 symmetric)
        double dy = 0.01;
        double ini = yi0[0];
        double end = yi0[yi0.length - 1];
        double ip = 1 + ((end - ini) / dy);
        int ipi = (int) ip;
        // create tranversal y vector [mm]
        double[] yii = new VecOp().linspace(ini, end, ipi);
        // interpolation of s(y) function
        double[] s = new Vinterp().cubic(s0, yi0, yii);
        // define general parameter matrix
        double[][] yemm = new PreAcon().main(s, yii, cas);
        // filter definite parameter matrix
        double[][] yc = new DefMat().main(yemm);
        // conicity calculation
        double[] ang = new Calc().main(yc, s, e, r0, dy);
        // filter y vector to plot
        double[] ycp = new VecOp().m2vc(yc, 0, 0, yc.length);
        //
        double[][] out = {ycp, ang};
//******************************************************************************
        return out;
    }
}
  
