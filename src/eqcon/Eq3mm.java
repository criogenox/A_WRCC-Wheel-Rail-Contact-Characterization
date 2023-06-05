package eqcon;
//
import static java.lang.Math.abs;
import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;
/**
 *
 * @author  Criogenox
 */
public class Eq3mm {
    
    public int main(double[] ycp){
        //
        double[] ycpone = new double[ycp.length];
        Arrays.setAll(ycpone, i -> abs(ycp[i] - 3)); 
        double min3 = Arrays.stream(ycpone).min().orElse(-1);
        int idmin3 = ArrayUtils.indexOf(ycpone, min3);
        //
    return idmin3;
    }    
}
