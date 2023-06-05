package calc;
//
import java.io.FileNotFoundException;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
/**
 *
 * @author  Criogenox
 */
public class Chart {
    //
    public LineChart create(double[][] number, double[][] numberr) 
                                     throws FileNotFoundException {

        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();  
        xAxis.setLabel("Transverse direction [mm]");
        yAxis.setLabel("Vertical distance (height) [mm]");
        LineChart lineChart = new LineChart(xAxis,yAxis);
        lineChart.setTitle("Right Wheel-Rail Pair  -  Relative Rail Coodinate System");
        lineChart.setId("inipos");
        XYChart.Series series = new XYChart.Series();
        XYChart.Series seriesr = new XYChart.Series();
        //
        for(int i = 0; i<number[0].length; i++) {
             series.getData().add(new XYChart.Data(number[0][i], number[1][i]));
        }
        for(int i = 0; i<numberr[0].length; i++) {
             seriesr.getData().add(new XYChart.Data(numberr[0][i], numberr[1][i]));   
        }
        lineChart.getData().addAll(series, seriesr);
        series.getNode().setStyle("-fx-stroke: black;");
        seriesr.getNode().setStyle("-fx-stroke: red;");
        //        
        lineChart.setCreateSymbols(false);
        lineChart.setLegendVisible(false);
        return lineChart;
    }
    //***
    public LineChart createinv(double[][] number, double[][] numberr) 
                                     throws FileNotFoundException {

        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();  
        xAxis.setLabel("Transverse direction [mm]");
        yAxis.setLabel("Vertical distance (height) [mm]");
        LineChart lineChart = new LineChart(xAxis,yAxis);
        lineChart.setTitle("Left Wheel-Rail Pair  -  Relative Rail Coodinate System");
        lineChart.setId("inipos");
        XYChart.Series series = new XYChart.Series();
        XYChart.Series seriesr = new XYChart.Series();
        //
        for(int i = 0; i<number[0].length; i++) {
             series.getData().add(new XYChart.Data(-number[0][i], number[1][i]));
        }
        for(int i = 0; i<numberr[0].length; i++) {
             seriesr.getData().add(new XYChart.Data(-numberr[0][i], numberr[1][i]));     
        }
        lineChart.getData().addAll(series, seriesr);
        series.getNode().setStyle("-fx-stroke: black;");
        seriesr.getNode().setStyle("-fx-stroke: red;");
        //        
        lineChart.setCreateSymbols(false);
        lineChart.setLegendVisible(false);
        return lineChart;
    }
    //***
    public LineChart create(double[][] number, double[][] numberr, double[][] p) 
                                     throws FileNotFoundException {
        double xlimi = number[0][0]*0.98;
        double xlimf = number[0][number[0].length-1]*1.02;
        final NumberAxis xAxis = new NumberAxis(xlimi,xlimf,10);
        final NumberAxis yAxis = new NumberAxis();  
        xAxis.setLabel("Transverse direction [mm]");
        yAxis.setLabel("Vertical distance (height) [mm]");
        LineChart lineChart = new LineChart(xAxis,yAxis);
        lineChart.setTitle("Right Wheel-Rail Pair  -  Track Coordinate System");
        lineChart.setId("conpon");
        XYChart.Series series = new XYChart.Series();
        XYChart.Series seriesr = new XYChart.Series();
        //
        for(int i = 0; i<p[0].length; i++) {
            XYChart.Series seriesp = new XYChart.Series();
            seriesp.getData().add(new XYChart.Data(p[0][i], p[1][i]));
            seriesp.getData().add(new XYChart.Data(p[2][i], p[3][i]+10));
            lineChart.getData().add(seriesp);
            seriesp.getNode().setStyle("-fx-stroke: blue;-fx-stroke-width: 1px");
        }
        //
        for(int i = 0; i<number[0].length; i++) {
             series.getData().add(new XYChart.Data(number[0][i], number[1][i]+10));
        }
        for(int i = 0; i<numberr[0].length; i++) {
             seriesr.getData().add(new XYChart.Data(numberr[0][i], numberr[1][i])); 
        }
        lineChart.getData().addAll(series, seriesr);
        series.getNode().setStyle("-fx-stroke: black;");
        seriesr.getNode().setStyle("-fx-stroke: red;");
        //        
        lineChart.setCreateSymbols(false);
        lineChart.setLegendVisible(false);
        return lineChart;
    }
    //***
    public LineChart createinv(double[][] number, double[][] numberr, double[][] p) 
                                     throws FileNotFoundException {
        double xlimi = number[0][0]*0.98;
        double xlimf = number[0][number[0].length-1]*1.02;
        final NumberAxis xAxis = new NumberAxis(-xlimf,-xlimi,10);
        final NumberAxis yAxis = new NumberAxis();  
        xAxis.setLabel("Transverse direction [mm]");
        yAxis.setLabel("Vetical distance (height) [mm]");
        LineChart lineChart = new LineChart(xAxis,yAxis);
        lineChart.setTitle("Left Wheel-Rail Pair  -  Track Coordinate System");
        lineChart.setId("conpon");
        XYChart.Series series = new XYChart.Series();
        XYChart.Series seriesr = new XYChart.Series();
        //
        for(int i = 0; i<p[0].length; i++) {
            XYChart.Series seriesp = new XYChart.Series();
            seriesp.getData().add(new XYChart.Data(-p[0][i], p[1][i]));
            seriesp.getData().add(new XYChart.Data(-p[2][i], p[3][i]+10));
            lineChart.getData().add(seriesp);
            seriesp.getNode().setStyle("-fx-stroke: blue;-fx-stroke-width: 1px");
        }
        //
        for(int i = 0; i<number[0].length; i++) {
             series.getData().add(new XYChart.Data(-number[0][i], number[1][i]+10));
        }
        for(int i = 0; i<numberr[0].length; i++) {
             seriesr.getData().add(new XYChart.Data(-numberr[0][i], numberr[1][i]));
             
        }
        lineChart.getData().addAll(series, seriesr);
        series.getNode().setStyle("-fx-stroke: black;");
        seriesr.getNode().setStyle("-fx-stroke: red;");
        //        
        lineChart.setCreateSymbols(false);
        lineChart.setLegendVisible(false);
        return lineChart;
    }
}
