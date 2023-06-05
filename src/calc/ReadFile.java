package calc;
//
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author  Criogenox
 */
public class ReadFile {
    //
    public double[][] choose2(String fileName) throws FileNotFoundException{
        List<Double> list1= new ArrayList<>();
        List<Double> list2= new ArrayList<>();
//        String fileName = "s1002.dat";
        File filescan = new File(fileName);
        try (Scanner scanner = new Scanner(filescan)) {
            while (scanner.hasNext()) {
                list1.add(Double.valueOf(scanner.next()));
                list2.add(Double.valueOf(scanner.next()));
            }  
            scanner.close();
        }
        double[][] outmat = {list1.stream().mapToDouble(Double::doubleValue).toArray(),
                             list2.stream().mapToDouble(Double::doubleValue).toArray()};
        return outmat;
    }
//    public double[][] choose(String fileName) throws FileNotFoundException{
//        double[] number1 = new double[1001];
//        double[] number2 = new double[1001];
//        int j=0;
////        String fileName = "s1002.dat";
//        File filescan = new File(fileName);
//        try (Scanner scanner = new Scanner(filescan)) {
//            while (scanner.hasNext()) {
//                number1[j] = (Double.parseDouble(scanner.next()));
//                number2[j] = (Double.parseDouble(scanner.next()));
//                j=j+1;
//            }  
//            scanner.close();
//        }
//        double [][] num2d = {number1, number2};
//        return num2d;
//    }
}
