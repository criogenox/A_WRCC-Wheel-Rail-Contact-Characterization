package wrchar.mvnver;
//

import static java.lang.Math.abs;

import java.util.Arrays;

import javafx.scene.control.Alert;
import org.apache.commons.lang3.ArrayUtils;

/**
 * @author Criogenox
 */
public class Table {

    public double[] main(double[] ycp, double[] ang) {
        //
        double[] ymm = {1, 1.5, 2, 2.5, 3, 3.5, 4, 4.5, 5, 5.5, 6, 6.5, 7};
        double[] ycpt = new double[ycp.length];
        double[] table = new double[ymm.length];
        int j = 0;
        for (double var : ymm) {
            Arrays.setAll(ycpt, i -> abs(ycp[i] - var));
            double min = Arrays.stream(ycpt).min().orElse(-1);
            if (min == -1) {
                Alert eq_diag = new Alert(Alert.AlertType.ERROR);
                eq_diag.setTitle("ERROR");
                eq_diag.setHeaderText("Unable to compute the complete "
                        + "set of conicity values");
                eq_diag.setContentText("Check the smoothness of the "
                        + "profiles' characterization data");
                eq_diag.showAndWait();
            }
            int id = ArrayUtils.indexOf(ycpt, min);
            table[j] = ang[id];
            j++;
        }
        return table;
    }
}

