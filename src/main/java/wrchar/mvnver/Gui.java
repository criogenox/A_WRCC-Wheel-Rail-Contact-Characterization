package wrchar.mvnver;
//

import javafx.application.Application;

import static javafx.geometry.Pos.CENTER_LEFT;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.CheckBox;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;
//
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.tan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Objects;
//
import calc.mvnver.*;
import eqcon.mvnver.Chart;
import eqcon.mvnver.Eq3mm;
import eqcon.mvnver.PreCalc;
import eqcon.mvnver.VecOp;

/**
 * @author Criogenox
 */
//--------------------------------------------
public class Gui extends Application {
    //
    public static void main(String[] args) {
        Application.launch(args);
    }

    // Declaration of variables' types
    Label title, title2, title3, title4, lbrr, lbia, lbtck, lbrwp, lblwp, lbrrp,
            lblrp, lbin1, lbin2, lbin3, sep;
    TextField trwp, tlwp, trrp, tlrp, tin1, tin2, tin3;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;
    boolean L1, L2, L3, L4;
    Spinner<Double> sp1, sp2, sp3, sp4, sp5, sp6;
    CheckBox ck1;
    ImageView im1;
    TabPane tabPane;
    Tab tab00, tab0, tab1, tab2, tab3;
    HBox titleinfo, titleinfo2, titleinfo3, titleinfo4, pan, sepinfo;
    VBox chini, chcp;
    File file, pdf;
    FileChooser fCh;
    double[][] wheelr, wheell, railr, raill, pr, pl, wrt, wlt, rrt, rlt, out,
            profile, railrrot, raillrot;
    double[] dl, drf, dar;
    double rrwr, rrwl, inrr, inrl, rrb2b, rrtg;
    LineChart chart00, chart0, chart1, chart2, chart3, chartinir, chartinil;
    Alert pdf_diag, chart_diag, read_diag;
    int cas, id3mm;

    //
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Railway applications — "
                + "Wheel / Rail Contact Characterization Program");
        // Instantiation
        var aligcl = CENTER_LEFT;
        title = new Label("""
                   Generic Asymetric Contact Analysis
                \u300A   General Calculation Parameters   \u300B""");
        title.setPrefWidth(280);
        title.setAlignment(Pos.CENTER);
        title.setStyle("-fx-font-weight: bold");
        title.setFont(new Font("SansSerif", 14));
        //
        titleinfo = new HBox(5, title);
        titleinfo.setAlignment(Pos.CENTER);
        titleinfo.setPadding(new Insets(0, 0, 0, 0));
        titleinfo.setBackground(new Background(new BackgroundFill
                (Color.rgb(153, 204, 255), new CornerRadii(10),
                        new Insets(0))));
        titleinfo.setEffect(new DropShadow(1, Color.GRAY));
        //----------------------------------------------------------
        lbrr = new Label("R/L wheels' rolling-radius [mm]");
        lbrr.setPrefWidth(170);
        lbrr.setAlignment(aligcl);
        lbrr.setStyle("-fx-font-style: italic");
        //----------------------------------------------------------
        cas = 2;
        ck1 = new CheckBox("asymetric case");
        ck1.setOnAction(event -> sp2.getStyleClass().clear());
        ck1.setOnAction(event -> {
            check();
        });
        //----------------------------------------------------------
        lbia = new Label("R/L rail's initial inclination [n]");
        lbia.setPrefWidth(170);
        lbia.setAlignment(aligcl);
        lbia.setStyle("-fx-font-style: italic");
        //----------------------------------------------------------
        lbtck = new Label("Back-to-back/Track gauge [mm]");
        lbtck.setPrefWidth(170);
        lbtck.setAlignment(aligcl);
        lbtck.setStyle("-fx-font-style: italic");
        //----------------------------------------------------------
        title2 = new Label("\u300A   Wheel/Rail Data Profiles   \u300B");
        title2.setPrefWidth(270);
        title2.setAlignment(Pos.CENTER);
        title2.setStyle("-fx-font-weight: bold");
        title2.setFont(new Font("SansSerif", 14));
        //
        titleinfo2 = new HBox(5, title2);
        titleinfo2.setAlignment(Pos.CENTER);
        titleinfo2.setPadding(new Insets(0, 0, 0, 0));
        titleinfo2.setBackground(new Background(new BackgroundFill
                (Color.rgb(220, 220, 220), new CornerRadii(10),
                        new Insets(0))));
        titleinfo2.setEffect(new DropShadow(1, Color.GRAY));
        //----------------------------------------------------------
        title3 = new Label("\u300A   Profiles Technical Info   \u300B");
        title3.setPrefWidth(270);
        title3.setAlignment(Pos.CENTER);
        title3.setStyle("-fx-font-weight: bold");
        title3.setFont(new Font("SansSerif", 14));
        //
        titleinfo3 = new HBox(5, title3);
        titleinfo3.setAlignment(Pos.CENTER);
        titleinfo3.setPadding(new Insets(0, 0, 0, 0));
        titleinfo3.setBackground(new Background(new BackgroundFill
                (Color.rgb(220, 220, 220), new CornerRadii(10),
                        new Insets(0))));
        titleinfo3.setEffect(new DropShadow(1, Color.GRAY));
        //----------------------------------------------------------
        lbin1 = new Label("Wheel model:");
        lbin1.setPrefWidth(75);
        lbin1.setAlignment(aligcl);
        lbin1.setStyle("-fx-font-style: italic");
        //
        tin1 = new TextField();
        tin1.setPrefColumnCount(19);
        tin1.setPromptText("ex: (left) R-UIC 519B / (right) R-UIC 519A");
        tin1.setAlignment(Pos.CENTER);
        //
        lbin2 = new Label("Rail model:");
        lbin2.setPrefWidth(75);
        lbin2.setAlignment(aligcl);
        lbin2.setStyle("-fx-font-style: italic");
        tin2 = new TextField();
        tin2.setPrefColumnCount(19);
        tin2.setPromptText("ex: (left & right) S-UIC 519A");
        tin2.setAlignment(Pos.CENTER);
        //
        lbin3 = new Label("Aditional info:");
        lbin3.setPrefWidth(75);
        lbin3.setAlignment(aligcl);
        lbin3.setStyle("-fx-font-style: italic");
        tin3 = new TextField();
        tin3.setPrefColumnCount(19);
        tin3.setPromptText("ex: Operating time / Extra conditions");
        tin3.setAlignment(Pos.CENTER);
        //----------------------------------------------------------
        sep = new Label("************************************************");
        sep.setPrefWidth(320);
        sep.setAlignment(Pos.CENTER);
        sep.setStyle("-fx-font-weight: bold");
        sep.setFont(new Font("SansSerif", 14));
        //
        sepinfo = new HBox(5, sep);
        sepinfo.setAlignment(Pos.CENTER);
        sepinfo.setPadding(new Insets(0, 0, 0, 0));
        sepinfo.setBackground(new Background(new BackgroundFill
                (Color.rgb(220, 220, 220), new CornerRadii(10),
                        new Insets(0))));
        sepinfo.setEffect(new DropShadow(1, Color.GRAY));
        //----------------------------------------------------------
        title4 = new Label("\u300A   Main Calculations / Outputs   \u300B");
        title4.setPrefWidth(270);
        title4.setAlignment(Pos.CENTER);
        title4.setStyle("-fx-font-weight: bold");
        title4.setFont(new Font("SansSerif", 14));
        //
        titleinfo4 = new HBox(5, title4);
        titleinfo4.setAlignment(Pos.CENTER);
        titleinfo4.setPadding(new Insets(0, 0, 0, 0));
        titleinfo4.setBackground(new Background(new BackgroundFill
                (Color.rgb(253, 200, 75), new CornerRadii(10),
                        new Insets(0))));
        titleinfo4.setEffect(new DropShadow(1, Color.GRAY));
        //----------------------------------------------------------
        lbrwp = new Label("Right wheel:");
        lbrwp.setPrefWidth(65);
        lbrwp.setAlignment(aligcl);
        lbrwp.setStyle("-fx-font-style: italic");
        //
        trwp = new TextField();
        trwp.setPrefColumnCount(13);
        trwp.setPromptText("=== Select data file ===");
        trwp.setAlignment(Pos.CENTER);
        //
        btn1 = new Button("Search");
        btn1.setDisable(true);
        btn1.setPrefSize(80, 20);
        btn1.setOnAction(e -> {
            btn6.setDisable(false);
            wheelr = new readFile().main(primaryStage, trwp);
            L1 = true;
        });
        //-----------------------------------------
        lbrrp = new Label("Right rail:");
        lbrrp.setPrefWidth(65);
        lbrrp.setAlignment(aligcl);
        lbrrp.setStyle("-fx-font-style: italic");
        //
        trrp = new TextField();
        trrp.setPrefColumnCount(13);
        trrp.setPromptText("=== Select data file ===");
        trrp.setAlignment(Pos.CENTER);
        //
        btn2 = new Button("Search");
        btn2.setDisable(true);
        btn2.setPrefSize(80, 20);
        btn2.setOnAction(e -> {
            btn6.setDisable(false);
            railr = new readFile().main(primaryStage, trrp);
            L2 = true;
        });
        //-----------------------------------------
        lblwp = new Label("(Left) wheel:");
        lblwp.setPrefWidth(65);
        lblwp.setAlignment(aligcl);
        lblwp.setStyle("-fx-font-style: italic");
        //
        tlwp = new TextField();
        tlwp.setPrefColumnCount(13);
        tlwp.setPromptText("=== Select data file ===");
        tlwp.setAlignment(Pos.CENTER);
        //
        btn3 = new Button("Search");
        btn3.setPrefSize(80, 20);
        btn3.setOnAction(e -> {
            btn6.setDisable(false);
            wheell = new readFile().main(primaryStage, tlwp);
            L3 = true;
            L1 = true;
            if (cas == 2) {
                wheelr = wheell;
            }
        });
        //-----------------------------------------
        lblrp = new Label("(Left) rail:");
        lblrp.setPrefWidth(65);
        lblrp.setAlignment(aligcl);
        lblrp.setStyle("-fx-font-style: italic");
        //
        tlrp = new TextField();
        tlrp.setPrefColumnCount(13);
        tlrp.setPromptText("=== Select data file ===");
        tlrp.setAlignment(Pos.CENTER);
        //
        btn4 = new Button("Search");
        btn4.setPrefSize(80, 20);
        btn4.setOnAction(e -> {
            btn6.setDisable(false);
            raill = new readFile().main(primaryStage, tlrp);
            L4 = true;
            L2 = true;
            if (cas == 2) {
                railr = raill;
            }
        });
        //-----------------------------------------
        // spinners
        sp1 = new Spinner(460.0, 1100.0, 920.0, 1);
        sp1.editorProperty().get().setAlignment(Pos.CENTER);
        sp1.setMaxWidth(70);
        sp1.setEffect(new DropShadow(10, Color.GRAY));
        sp1.setVisible(false);
        //
        sp2 = new Spinner(460.0, 1100.0, 920.0, 1);
        sp2.editorProperty().get().setAlignment(Pos.CENTER);
        sp2.setMaxWidth(70);
        sp2.setEffect(new DropShadow(10, Color.GRAY));
        //
        sp3 = new Spinner(10.0, 60.0, 20.0, 1);
        sp3.editorProperty().get().setAlignment(Pos.CENTER);
        sp3.setMaxWidth(70);
        sp3.setEffect(new DropShadow(10, Color.GRAY));
        sp3.setVisible(false);
        //
        sp4 = new Spinner(10.0, 60.0, 20.0, 1);
        sp4.editorProperty().get().setAlignment(Pos.CENTER);
        sp4.setMaxWidth(70);
        sp4.setEffect(new DropShadow(10, Color.GRAY));
        //
        sp5 = new Spinner(850.0, 1700.0, 1360.0, 1);
        sp5.editorProperty().get().setAlignment(Pos.CENTER);
        sp5.setMaxWidth(70);
        sp5.setEffect(new DropShadow(10, Color.GRAY));
        //
        sp6 = new Spinner(850.0, 1700.0, 1435.0, 1);
        sp6.editorProperty().get().setAlignment(Pos.CENTER);
        sp6.setMaxWidth(70);
        sp6.setEffect(new DropShadow(10, Color.GRAY));
        //
        // default values
        rrwl = sp2.getValue();
        rrwr = rrwl;
        inrl = sp4.getValue();
        inrr = inrl;
        rrb2b = sp5.getValue();
        rrtg = sp6.getValue();
        // listeners
        sp1.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {
            if (!"".equals(newValue)) {
                rrwr = sp1.getValue();
                btn6.setDisable(false);
            }
        });
        sp2.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {
            if (!"".equals(newValue)) {
                rrwl = sp2.getValue();
                btn6.setDisable(false);
                if (cas == 2) {
                    rrwr = rrwl;
                }
            }
        });
        sp3.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {
            if (!"".equals(newValue)) {
                inrr = sp3.getValue();
                btn6.setDisable(false);
            }
        });
        sp4.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {
            if (!"".equals(newValue)) {
                inrl = sp4.getValue();
                btn6.setDisable(false);
                if (cas == 2) {
                    inrr = inrl;
                }
            }
        });
        sp5.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {
            if (!"".equals(newValue)) {
                rrb2b = sp5.getValue();
                btn6.setDisable(false);
            }
        });
        sp6.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {
            if (!"".equals(newValue)) {
                rrtg = sp6.getValue();
                btn6.setDisable(false);
            }
        });
        //----------------------------------------------------------------------
        btn5 = new Button("Calculate");
        btn5.setPrefSize(150, 20);
        btn5.setAlignment(Pos.CENTER);
        btn5.setEffect(new DropShadow(10, Color.GRAY));
        btn5.setDisable(true);
        btn5.setOnAction(e -> {
            btn5.setDisable(true);
            pointDetect();
            finalCharts();
        });
        //
        btn6 = new Button("Check Data");
        btn6.setPrefSize(150, 20);
        btn6.setAlignment(Pos.CENTER);
        btn6.setEffect(new DropShadow(10, Color.GRAY));
        btn6.setOnAction(e -> {
            if (L1 == true && L2 == true && L3 == true && L4 == true) {
                setProfiles();
                btn6.setDisable(true);
                btn5.setDisable(false);
            } else {
                // Alert
                Alert inp_diag = new Alert(AlertType.WARNING);
                inp_diag.setTitle("WARNING");
                inp_diag.setHeaderText("Missing Data");
                inp_diag.setContentText("Check your input fields");
                inp_diag.showAndWait();
            }
        });
        //
        btn7 = new Button("Save as PDF");
        btn7.setPrefSize(150, 20);
        btn7.setAlignment(Pos.CENTER);
        btn7.setEffect(new DropShadow(10, Color.GRAY));
        btn7.setOnAction(e -> {
            savePDF(primaryStage);
        });
        //
        btn8 = new Button("Save as text file ");
        btn8.setPrefSize(150, 20);
        btn8.setAlignment(Pos.CENTER);
        btn8.setEffect(new DropShadow(10, Color.GRAY));
        btn8.setOnAction(e ->
        {
            FileChooser newfile = new FileChooser();
            newfile.setTitle(" Save File ");
            File file1 = newfile.showSaveDialog(primaryStage);
            System.out.println(file1);
        });
        //----------------------------------------------------------------------  
        // Plot Tabs 
        tab00 = new Tab();
        tab00.setText("Wheel-Rail Initial Position");
        tab00.setStyle("-fx-font-weight: bold");
        tab00.setClosable(false);
        //
        tab0 = new Tab();
        tab0.setText("Potentials Contact Points");
        tab0.setStyle("-fx-font-weight: bold");
        tab0.setClosable(false);
        //
        tab1 = new Tab();
        tab1.setText("Equivalent Conicity (EN15302 - Nonlinear Method)");
        tab1.setStyle("-fx-font-weight: bold");
        tab1.setClosable(false);
        //
        tab2 = new Tab();
        tab2.setText("Wheels' Rolling Radii Difference");
        tab2.setStyle("-fx-font-weight: bold");
        tab2.setClosable(false);
        //
        tab3 = new Tab();
        tab3.setText("Wheel-Rail Contact Angles");
        tab3.setStyle("-fx-font-weight: bold");
        tab3.setClosable(false);
        //
        // TabPane
        tabPane = new TabPane(tab00, tab0, tab1, tab2, tab3);
        //
        // VBox 
        pan = new HBox(addGridPaneC());
        pan.setAlignment(Pos.BASELINE_CENTER);
        //
        VBox paneleft = new VBox(10, addGridPaneA(), addVBoxim(),
                addGridPaneB(), pan);
        paneleft.setPadding(new Insets(0, 0, 0, 0));
        paneleft.setAlignment(Pos.TOP_CENTER);
        //
        // Border Pane
        BorderPane border = new BorderPane();
        border.setCenter(tabPane);
        border.setLeft(paneleft);
        //    
        // Scene & Stage 
        Scene scene = new Scene(border);
        scene.getStylesheets().add(getClass().getResource("style.css").toString());
        Screen screen = Screen.getPrimary();
        primaryStage.setScene(scene);
        primaryStage.setWidth(screen.getVisualBounds().getWidth());
        primaryStage.setHeight(screen.getVisualBounds().getHeight());
        // Stage/window Icon 
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/wrchar/mvnver/contact.png")));
        primaryStage.show();
    }

    //**************************************************************************
    /*
     * GridPane A for diameters, inclinations, and gauges
     */
    private GridPane addGridPaneA() {
        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(10, 10, 0, 10));
        // Category in column 1-3, row 1
        grid.add(titleinfo, 0, 0, 3, 1);
        //                        c     r  cspan rspan
        GridPane.setHalignment(titleinfo, HPos.CENTER);
        //-----------------------------------------
        // Category in column 1, row 2
        grid.add(lbrr, 0, 1);
        // Category in column 2, row 2
        grid.add(sp1, 1, 1);
        // Category in column 3, row 2
        grid.add(sp2, 2, 1);
        //-----------------------------------------
        // Category in column 1, row 3
        grid.add(ck1, 0, 2);
        //-----------------------------------------
        // Category in column 1, row 4
        grid.add(lbia, 0, 3);
        // Category in column 2, row 4
        grid.add(sp3, 1, 3);
        // Category in column 3, row 4
        grid.add(sp4, 2, 3);
        //-----------------------------------------
        // Category in column 1, row 5
        grid.add(lbtck, 0, 4);
        // Category in column 2, row 5
        grid.add(sp5, 1, 4);
        // Category in column 3, row 5
        grid.add(sp6, 2, 4);
//        grid.setGridLinesVisible(true);
        return grid;
    }

    //-----------------------------------------
    /*
     * GridPane B for technical data
     */
    private GridPane addGridPaneB() {
        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(1, 10, 0, 10));
        // Category in column 1-3, row 1
        grid.add(titleinfo2, 0, 0, 3, 1);
        //                        c     r  cspan rspan
        GridPane.setHalignment(titleinfo2, HPos.CENTER);
        //-----------------------------------------
        // Category in column 1, row 2
        grid.add(lbrwp, 0, 1);
        // Category in column 2, row 2
        grid.add(trwp, 1, 1);
        // Category in column 3, row 2
        grid.add(btn1, 2, 1);
        //-----------------------------------------
        // Category in column 1, row 3
        grid.add(lbrrp, 0, 2);
        // Category in column 2, row 3
        grid.add(trrp, 1, 2);
        // Category in column 3, row 3
        grid.add(btn2, 2, 2);
        //-----------------------------------------
        // Category in column 1, row 4
        grid.add(lblwp, 0, 3);
        // Category in column 2, row 4
        grid.add(tlwp, 1, 3);
        // Category in column 3, row 4
        grid.add(btn3, 2, 3);
        //-----------------------------------------
        // Category in column 1, row 5
        grid.add(lblrp, 0, 4);
        // Category in column 2, row 5
        grid.add(tlrp, 1, 4);
        // Category in column 3, row 5
        grid.add(btn4, 2, 4);
        //-----------------------------------------
        // Category in column 1-3, row 6
        grid.add(titleinfo3, 0, 5, 3, 1);
        //                        c     r  cspan rspan
        GridPane.setHalignment(titleinfo3, HPos.CENTER);
        //-----------------------------------------
        // Category in column 1, row 7
        grid.add(lbin1, 0, 6);
        // Category in column 2, row 7
        grid.add(tin1, 1, 6, 2, 1);
        //-----------------------------------------
        // Category in column 1, row 8
        grid.add(lbin2, 0, 7);
        // Category in column 2, row 8
        grid.add(tin2, 1, 7, 2, 1);
        //-----------------------------------------  
        // Category in column 1, row 9
        grid.add(lbin3, 0, 8);
        // Category in column 2, row 9
        grid.add(tin3, 1, 8, 2, 1);
        //----------------------------------------- 
        // Category in column 2, row 10
        grid.add(sepinfo, 0, 9, 3, 1);
        //-----------------------------------------   
        // Category in column 1-3, row 11
        grid.add(titleinfo4, 0, 10, 3, 1);
        //                        c     r  cspan rspan
        GridPane.setHalignment(titleinfo4, HPos.CENTER);
        //-----------------------------------------      
//        grid.setGridLinesVisible(true);
        return grid;
    }

    //-----------------------------------------
    /*
     * GridPane C for main calculation / outputs
     */
    private GridPane addGridPaneC() {
        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(1, 10, 0, 10));
        // Category in column 1, row 1
        grid.add(btn5, 0, 0);
        // Category in column 2, row 1
        grid.add(btn6, 1, 0);
        // Category in column 1, row 2
        grid.add(btn7, 0, 1);
        // Category in column 2, row 2
        grid.add(btn8, 1, 1);
        //
//        grid2.setGridLinesVisible(true);
        return grid;
    }

    //-----------------------------------------
    /*
     * VBox image for the left region
     */
    private VBox addVBoxim() {
        im1 = new ImageView(new Image(Objects.requireNonNull(Gui.class.
                getResourceAsStream("/wrchar/mvnver/pm.png"))));
        im1.setFitHeight(150);
        im1.setFitWidth(310);
        VBox impm = new VBox(5, im1);
        impm.setPadding(new Insets(10, 10, 0, 10));
        impm.setAlignment(Pos.CENTER);
        return impm;
    }

    //-----------------------------------------
    private class readFile {
        private double[][] main(Stage primaryStage, TextField tf) {
            //
            fCh = new FileChooser();
            file = fCh.showOpenDialog(primaryStage);
            if (file == null) {
                //No Directory selected
            } else {
                String fileName = file.getAbsolutePath();
                tf.setPromptText(file.getAbsolutePath());
                tf.setEditable(false);
                try {
                    profile = new ReadFile().choose2(fileName);
//                System.out.println(fileName);        
                } catch (FileNotFoundException ex) {
                    read_diag = new Alert(AlertType.ERROR);
                    read_diag.setTitle("ERROR");
                    read_diag.setHeaderText(ex.toString());
                    read_diag.setContentText("Check your file according to"
                            + " requirements");
                    read_diag.showAndWait();
                }
            }
            return profile;
        }
    }

    //-----------------------------------------
    private void setProfiles() {
        // initial position chart
        try {
            chartinil = new calc.mvnver.Chart().createinv(wheell, raill);
            chartinir = new calc.mvnver.Chart().create(wheelr, railr);
        } catch (FileNotFoundException ex) {
            read_diag = new Alert(AlertType.ERROR);
            read_diag.setTitle("ERROR");
            read_diag.setHeaderText(ex.toString());
            read_diag.setContentText("Check your file according to"
                    + " requirements");
            read_diag.showAndWait();
        }
        //
        double alfa = 0.0;    // initial rail inclination 
        // rotation matrix
        double[][] R = {{cos(alfa), -sin(alfa)}, {sin(alfa), cos(alfa)}};
        // rotated rail
        railrrot = new MatMet().multm(R, railr);
        raillrot = new MatMet().multm(R, raill);
        // set profiles in track coordinates
        wrt = new VecOp().toTrack(wheelr, 0, 0, 1001, rrtg);
        wlt = new VecOp().toTrack(wheell, 0, 0, 1001, rrtg);
        rrt = new VecOp().toTrack(railrrot, 0, 0, 1001, rrtg);
        rlt = new VecOp().toTrack(raillrot, 0, 0, 1001, rrtg);
    }

    //-----------------------------------------
    private void pointDetect() {
        //**********************************************************************
        // ************************* Main Calculation **************************
        //********************************************************************** 
        // lateral increment
        double xmin = -7, xmax = 7;
        int step = (int) (1 + (xmax - xmin) / 0.1);
        dl = new VecOp().linspace(xmin, xmax, step);
        // contact points calculation
        pr = new CalcLoop().main(dl, rrwr, 1 / inrr, rrtg, wrt, rrt, railrrot);
        double[] dln = VecOp.mulSca(-1, dl);
        pl = new CalcLoop().main(dln, rrwl, 1 / inrl, rrtg, wlt, rlt, raillrot);
        // rolling radii difference
        double[] dr = new double[pr[0].length];
        Arrays.setAll(dr, i -> pr[4][i] - pl[4][i]);
        // wheel-rail contact angles
        dar = new double[pr[0].length];
        Arrays.setAll(dar, i -> tan(pl[5][i] - pr[5][i]));
        // dl drf dar
        double dr0 = rrwr - rrwl;
        drf = new double[dr.length];
        if (dr0 > 0) {
            Arrays.setAll(drf, i -> dr[i] - dr0 / 2);
        } else if (dr0 < 0) {
            Arrays.setAll(drf, i -> dr[i] + dr0 / 2);
        } else {
            Arrays.setAll(drf, i -> dr[i]);
        }
        //
        out = new PreCalc().main(dl, drf, cas, rrtg, inrl);
        //
        id3mm = new Eq3mm().main(out[0]);
    }

    //-----------------------------------------
    private void finalCharts() {
        try {
            // plot results
            chart00 = new calc.mvnver.Chart().createinv(wlt, rlt, pl);
            chart0 = new calc.mvnver.Chart().create(wrt, rrt, pr);
            chart1 = new eqcon.mvnver.Chart().create2(out[0], out[1], out[0][id3mm], out[1][id3mm]);
            chart2 = new eqcon.mvnver.Chart().create0(dl, drf);
            chart3 = new eqcon.mvnver.Chart().create1(dl, dar);
            chini = new VBox(5, chartinil, chartinir);
            chini.setPadding(new Insets(0, 0, 0, 0));
            chcp = new VBox(5, chart00, chart0);
            chcp.setPadding(new Insets(0, 0, 0, 0));
            tab00.setContent(chini);
            tab0.setContent(chcp);
            tab1.setContent(chart1);
            tab2.setContent(chart2);
            tab3.setContent(chart3);
            //
        } catch (FileNotFoundException ex) {
            // Alert
            chart_diag = new Alert(AlertType.ERROR);
            chart_diag.setTitle("ERROR");
            chart_diag.setHeaderText(ex.toString());
            chart_diag.setContentText("Check your data");
            chart_diag.showAndWait();
        }
    }

    //-----------------------------------------
    private void savePDF(Stage primaryStage) {
        FileChooser savefile = new FileChooser();
        savefile.setTitle("Save File");
        savefile.setInitialFileName("Final Technical Report " +
                new SimpleDateFormat("yyyy.MM.dd-HHmmss")
                        .format(new java.util.Date()) + ".pdf");
        pdf = savefile.showSaveDialog(primaryStage);
        if (pdf != null) {
            try {
                Image img0 = chart1.snapshot(null, null);
                Image img1 = chart00.snapshot(null, null);
                Image img11 = chart0.snapshot(null, null);
                Image img2 = chart2.snapshot(null, null);
                Image img3 = chart3.snapshot(null, null);
                String winfo = tin1.getText();
                String rinfo = tin2.getText();
                String adinfo = tin3.getText();
                double[] tab = new Table().main(out[0], out[1]);
                PDFdoc.main(img0, img1, img11, img2, img3, pdf, winfo,
                        rinfo, adinfo, tab, rrwr, rrwl, inrr, inrl, rrb2b,
                        rrtg);
            } catch (IOException ex) {
                // Alert
                pdf_diag = new Alert(AlertType.ERROR);
                pdf_diag.setTitle("ERROR");
                pdf_diag.setHeaderText(ex.toString());
                pdf_diag.setContentText("Push OK to continue");
                pdf_diag.showAndWait();
            }
        }
    }

    //-----------------------------------------
    private void check() {
        if (ck1.isSelected()) {
            sp1.setVisible(true);
            sp3.setVisible(true);
            btn1.setDisable(false);
            btn2.setDisable(false);
            rrwr = sp1.getValue();
            rrwl = sp2.getValue();
            inrr = sp3.getValue();
            inrl = sp4.getValue();
            cas = 1;
        }
        if (!ck1.isSelected()) {
            sp1.setVisible(false);
            sp3.setVisible(false);
            btn1.setDisable(true);
            btn2.setDisable(true);
            rrwl = sp2.getValue();
            rrwr = rrwl;
            inrl = sp4.getValue();
            inrr = inrl;
            cas = 2;
        }
    }
    //-----------------------------------------
}

