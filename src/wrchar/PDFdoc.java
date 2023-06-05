package wrchar;
//
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
/**
 *
 * @author  Criogenox
 */
public class PDFdoc {
    
    public static void main(Image img0, Image img1, Image img11, Image img2,
                            Image img3, File filename, String winfo,
                            String rinfo, String adinfo, double[] tab,
                            double rrwr, double rrwl, double inrr, double inrl, 
                            double rrb2b, double rrtg) 
                            throws IOException {
        
        try (PDDocument doc = new PDDocument()) {  
            PDPage page;
            PDPageContentStream content; 
                page = new PDPage();
                doc.addPage(page);
                content = new PDPageContentStream(doc, page);   
                mainContent(doc, content, img0, img1, img11, img2, img3,
                            winfo, rinfo, adinfo, tab, rrwr, rrwl, inrr, inrl, 
                            rrb2b, rrtg);  
                content.close();
                doc.save(filename);
            doc.close();
        }  
    }
    //
    static void mainContent(PDDocument doc, PDPageContentStream content, 
                            Image img0,Image img1,Image img11, Image img2,
                            Image img3, String winfo, String rinfo, String adinfo,
                            double[] tab, double rrwr, double rrwl, double inrr, 
                            double inrl, double rrb2b, double rrtg)  throws IOException{
            //  LOGO          
            PDImageXObject logo = PDImageXObject.createFromFile("imgs/contact.png", doc);          
	    float scale00 = (float) 0.02;
	    content.drawImage(logo, 12, 742, 
                              logo.getWidth()*scale00, 
                              logo.getHeight()*scale00);
            // Charts
            BufferedImage image0 = SwingFXUtils.fromFXImage(img0, null);
            PDImageXObject imObj0 = LosslessFactory.createFromImage(doc, image0);
            float scale0 = (float) 0.36;
            System.out.println(imObj0.getWidth());
            System.out.println(imObj0.getHeight());
            content.drawImage(imObj0, 115, 480, 
                              imObj0.getWidth()*scale0, 
                              imObj0.getHeight()*scale0);   // 100 450
            //------------------------------------------------------------------
            BufferedImage image1 = SwingFXUtils.fromFXImage(img1, null);
            PDImageXObject imObj1 = LosslessFactory.createFromImage(doc, image1);
            float scale1 = (float) 0.4;
            content.drawImage(imObj1, 58, 10, 
                              imObj1.getWidth()*scale1, 
                              imObj1.getHeight()*scale1);   // 40 170
            //------------------------------------------------------------------
            BufferedImage image11 = SwingFXUtils.fromFXImage(img11, null);
            PDImageXObject imObj11 = LosslessFactory.createFromImage(doc, image11);
            content.drawImage(imObj11, 150, 155, 
                              imObj11.getWidth()*scale1, 
                              imObj11.getHeight()*scale1);   // 40 170
            //------------------------------------------------------------------
            BufferedImage image2 = SwingFXUtils.fromFXImage(img2, null);
            PDImageXObject imObj2 = LosslessFactory.createFromImage(doc, image2);
            float scale2 = (float) 0.25;
            content.drawImage(imObj2, 30, 300, 
                              imObj2.getWidth()*scale2, 
                              imObj2.getHeight()*scale2);   // 30 20
            //------------------------------------------------------------------
            BufferedImage image3 = SwingFXUtils.fromFXImage(img3, null);
            PDImageXObject imObj3 = LosslessFactory.createFromImage(doc, image3);
            content.drawImage(imObj3, 320, 300, 
                              imObj3.getWidth()*scale2, 
                              imObj3.getHeight()*scale2);   // 320 20
            //------------------------------------------------------------------
            //  Lines  
            line(content, 6, 786, 607, 786);
            line(content, 10, 782, 603, 782); //
            line(content, 200, 761, 603, 761);
            line(content, 10, 740, 603, 740); //
            line(content, 33, 718, 102, 718);
            line(content, 510, 718, 558, 718);
            line(content, 70, 260, 138, 260);
            //
            int sft = 30, sfh = 400;
            line(content, sfh+100, sft+637, sfh+167, sft+637);
            line(content, sfh+100, sft+620, sfh+167, sft+620);
            line(content, sfh+132, sft+637, sfh+132, sft+490); 
            line(content, sfh+100, sft+637, sfh+100, sft+490); 
            line(content, sfh+167, sft+637, sfh+167, sft+490); 
            int it = 0;
            for (int i = 1; i < 14; i++){
                line(content, sfh+100, sft+610+it, sfh+167, sft+610+it);
            it = it - 10;
            }
            //
            line(content, 10, 10, 603, 10); //
            line(content, 6, 6, 607, 6);
            //
            line(content, 6, 6, 6, 786);
            line(content, 10, 10, 10, 782); //
            //
            line(content, 603, 10, 603, 782); //
            line(content, 607, 6, 607, 786);
            line(content, 200, 740, 200, 782);
            line(content, 500, 740, 500, 761);
            //
            String newdateFormat = new SimpleDateFormat ("dd/MM/yyyy").
                                   format(new java.util.Date());
            // 
            //  Text
            String[] winf, rinf, adinf; 
            winf = winfo.split("/");
            rinf = rinfo.split("/");
            adinf = adinfo.split("/");
            //
            String title0 = "LILIK software Ltd.";
            float sf=6, ind = 8, vind = 0; 
            text(content, PDType1Font.HELVETICA_BOLD,
                    15, 60,756, title0);
            text(content, PDType1Font.HELVETICA_BOLD,
                    8, 270,769,
                    "Railway applications — Wheel / Rail Contact Characterization Program");
            text(content, PDType1Font.HELVETICA_BOLD,
                    8, 250, 748,
                    "Generic Asymetric Contact Analysis - Technical report");
            text(content, PDType1Font.HELVETICA_BOLD,
                    8, 523, 748, "Date: "+ newdateFormat);
            //
            text(content, PDType1Font.HELVETICA_BOLD,
                    sf, ind+25, vind+720, "Wheel/Rail Data Profiles");
            //
            text(content, PDType1Font.HELVETICA_BOLD,
                    sf, ind+20, vind+700, "Wheel diameter:");
            text(content, PDType1Font.HELVETICA_BOLD,
                    sf, ind+25, vind+690, "— right wheel: "+ rrwr + " mm");
            text(content, PDType1Font.HELVETICA_BOLD,
                    sf, ind+25, vind+680, "— left wheel: "+ rrwl + " mm");
            //
            DecimalFormat inf=new DecimalFormat("#");
            text(content, PDType1Font.HELVETICA_BOLD,
                    sf, ind+20, vind+665, "Rail's initial inclination:");
            text(content, PDType1Font.HELVETICA_BOLD,
                    sf, ind+25, vind+655, "— right rail: 1/"+ inf.format(inrr));
            text(content, PDType1Font.HELVETICA_BOLD,
                    sf, ind+25, vind+645, "— left rail: 1/"+ inf.format(inrl));
            //
            text(content, PDType1Font.HELVETICA_BOLD,
                    sf, ind+20, vind+630, "Wheel's model:");
            text(content, PDType1Font.HELVETICA_BOLD,
                    sf, ind+25, vind+620, "— " + winf[0]);
            if(winf.length == 2){
            text(content, PDType1Font.HELVETICA_BOLD,
                    sf, ind+25, vind+610, "— " + winf[1]);}
            //
            text(content, PDType1Font.HELVETICA_BOLD,
                    sf, ind+20, vind+595, "Rail's model:");
            text(content, PDType1Font.HELVETICA_BOLD,
                    sf, ind+25, vind+585, "— " + rinf[0]);
            if(rinf.length == 2){text(content, PDType1Font.HELVETICA_BOLD,
                    sf, ind+25, vind+575, "— " + rinf[1]);}
            //
            int onem = 0;
            if(rinf.length == 1){onem = 10;}
            text(content, PDType1Font.HELVETICA_BOLD,
                    sf, ind+20, 560+onem, "Back-to-back: "+ rrb2b +" mm");
            text(content, PDType1Font.HELVETICA_BOLD,
                    sf, ind+20, 545+onem, "Track gauge: "+ rrtg + " mm");   
            //
            text(content, PDType1Font.HELVETICA_BOLD,
                    sf, ind+20, vind+530+onem, "Aditional info:");
            int inc = 520+onem;
            for (String adinfi : adinf) {
            text(content, PDType1Font.HELVETICA_BOLD,
                    sf, ind+25, vind+inc, "— " + adinfi);
            inc = inc - 10;
            }      
            //
            text(content, PDType1Font.HELVETICA_BOLD,
                    sf, sfh+110, 720, "Analysis Results");
            text(content, PDType1Font.HELVETICA_BOLD,
                    sf, sfh+90, 700, "— In accordance with EN 15302");
            text(content, PDType1Font.HELVETICA_BOLD,
                    sf, sfh+90, 690, "Method: integration of non-linear");
            text(content, PDType1Font.HELVETICA_BOLD,
                    sf, sfh+115, 680, "differential equation");
            text(content, PDType1Font.HELVETICA_BOLD,
                    sf, sfh+90, 510, "NOTE: nominal value for 3 mm");
            //
            text(content, PDType1Font.HELVETICA_BOLD,
                    sf, sfh+102, sft+630, "Lat. displ.");
            text(content, PDType1Font.HELVETICA_BOLD,
                    sf, sfh+109, sft+623, "[mm]");
            text(content, PDType1Font.HELVETICA_BOLD,
                    sf, sfh+135, sft+630, "Equivalent");
            text(content, PDType1Font.HELVETICA_BOLD,
                    sf, sfh+139, sft+623, "conicity");
            //
            DecimalFormat ndf=new DecimalFormat("#.##");
            int itn = 0, itnt = 0;
            for (int i = 2; i < 15; i++){
                 double ip = i;
                 text(content, PDType1Font.HELVETICA_BOLD,
                 sf, sfh+112, sft+612+itn, String.valueOf(ip/2));
                 itn = itn - 10;
            }
            for (int j = 0; j < tab.length; j++){
                 text(content, PDType1Font.HELVETICA_BOLD,
                 sf, sfh+143, sft+612+itnt, String.valueOf(ndf.format(tab[j])));
                 itnt = itnt - 10;
            }
            //
            text(content, PDType1Font.HELVETICA_BOLD,
                    sf, 70, 262, "Potential contact points");
            text(content, PDType1Font.HELVETICA_BOLD,
                    sf, 63, 250, "(no-penetration assumption)");
            text(content, PDType1Font.HELVETICA_BOLD,
                    sf, 63, 230, "Right wheel/rail pair models:");
            String wr;
            if(winf.length == 2){wr = winf[1];} else {wr = winf[0];}
            text(content, PDType1Font.HELVETICA_BOLD,
                    sf, 63, 220, "— " + wr);
            String rr;
            if(rinf.length == 2){rr = rinf[1];} else {rr = rinf[0];}
            text(content, PDType1Font.HELVETICA_BOLD,
                    sf, 63, 210, "— " + rr);
            //
            text(content, PDType1Font.HELVETICA_BOLD,
                    sf, 468, 100, "Left wheel/rail pair models:");
            text(content, PDType1Font.HELVETICA_BOLD,
                    sf, 468, 90, "— " + winf[0]);
            text(content, PDType1Font.HELVETICA_BOLD,
                    sf, 468, 80, "— " + rinf[0]);
    }
    //
    static void text(PDPageContentStream content, PDFont pdFont, float sizeFont, 
                     float iniH, float iniV,  String text) throws IOException {
        
        content.beginText();   
        content.setFont(pdFont, sizeFont);
        content.newLineAtOffset(iniH, iniV);  
        content.showText(text);
        content.endText();
    }
    //
    static void line(PDPageContentStream content, float iniH, float iniV,
                     float finH, float finV) throws IOException {
        
        content.moveTo(iniH, iniV);
        content.lineTo(finH, finV);
        content.stroke();
    }   
}
