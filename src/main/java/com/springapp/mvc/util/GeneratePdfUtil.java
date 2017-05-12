package com.springapp.mvc.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.springapp.mvc.domain.product.Letter;
import com.springapp.mvc.domain.product.hmc.LiveToolEntity;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GeneratePdfUtil {

    private static PdfPTable getHeaderTable(String path) throws DocumentException, IOException {
        PdfPTable headerTable = new PdfPTable(3);
        headerTable.setWidthPercentage(100);
        headerTable.setWidths(new float[]{1.5f,0.5f,2f});

        Image imgLogo = Image.getInstance(path + "/images/logotype.png");
        PdfPCell cell1 = new PdfPCell(imgLogo,true);
        cell1.setBorder(Rectangle.NO_BORDER);

        PdfPCell cell2 = new PdfPCell();
        cell2.setBorder(Rectangle.NO_BORDER);

        Font font = new Font(Font.FontFamily.TIMES_ROMAN, 14);
        Font greenFont = new Font(Font.FontFamily.TIMES_ROMAN, 14);
        greenFont.setColor(new BaseColor(89, 178, 16));

        PdfPCell cell3 = new PdfPCell();
        Paragraph paragraph = new Paragraph();
        Chunk chunk = new Chunk("Vertical and horizontal machine centers\nUSA: ",font);
        paragraph.add(chunk);
        chunk = new Chunk("+1 203 556-50-69",greenFont);
        paragraph.add(chunk);
        chunk = new Chunk("\ncontact@",font);
        paragraph.add(chunk);
        chunk = new Chunk("vmccnc.com",greenFont);
        paragraph.add(chunk);
        paragraph.setAlignment(Element.ALIGN_RIGHT);
        cell3.addElement(paragraph);
        cell3.setBorder(Rectangle.NO_BORDER);

        headerTable.addCell(cell1);
        headerTable.addCell(cell2);
        headerTable.addCell(cell3);

        return headerTable;
    }

    private static void setForWhoData(Document document, String company, String director) throws DocumentException {
        Font fontBoldBig = new Font(Font.FontFamily.TIMES_ROMAN,22,Font.BOLD);
        Font fontNormal = new Font(Font.FontFamily.TIMES_ROMAN,13);

        Paragraph paragraph = new Paragraph("\nCommercial proposal",fontBoldBig);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph);

        paragraph = new Paragraph();
        Chunk chunk;
        if(!company.equals("")) {
            chunk = new Chunk("\nto the director of " + company, fontNormal);
            paragraph.add(chunk);
            if(!director.equals("")) {
                chunk = new Chunk(", " + director, fontNormal);
                paragraph.add(chunk);
            }
        } else if(!director.equals("")) {
            chunk = new Chunk("for " + director, fontNormal);
            paragraph.add(chunk);
        }
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date();
        chunk = new Chunk("\nfrom " + dateFormat.format(date), fontNormal);
        paragraph.add(chunk);

        document.add(paragraph);
    }

//    private static PdfPTable getOrderTable(String products, LiveToolEntity[] machines) throws DocumentException {
//        PdfPTable orderTable = new PdfPTable(6);
//        orderTable.setWidthPercentage(100);
//        orderTable.setSpacingBefore(20f);
//        orderTable.setSpacingAfter(10f);
//        orderTable.setWidths(new float[]{0.8f, 5f, 5f, 3f, 2.5f, 3f});
//
//        Font fontForHead = new Font(Font.FontFamily.TIMES_ROMAN,13,Font.BOLD);
//        Font fontForBody = new Font(Font.FontFamily.TIMES_ROMAN,12);
//
//        PdfPCell[] orderCells = new PdfPCell[6];
//        orderCells[0] = new PdfPCell(new Paragraph());
//        orderCells[1] = new PdfPCell(new Paragraph("Machine",fontForHead));
//        orderCells[2] = new PdfPCell(new Paragraph("Model",fontForHead));
//        orderCells[3] = new PdfPCell(new Paragraph("Price",fontForHead));
//        orderCells[4] = new PdfPCell(new Paragraph("Quantity",fontForHead));
//        orderCells[5] = new PdfPCell(new Paragraph("Total",fontForHead));
//        for(PdfPCell cell : orderCells) {
//            cell.setBackgroundColor(new BaseColor(238,238,238));
//            cell.setBorderColor(new BaseColor(22, 22, 22));
//            cell.setBorderWidth(1);
//            orderTable.addCell(cell);
//        }
//
//        String[] productsArr = products.split(";");
//        int orderTotal = 0;
//        for (int i = 0; i < machines.length; i++) {
//            orderCells[0] = new PdfPCell(new Paragraph(String.valueOf(i + 1),fontForBody));
//            orderCells[0].setHorizontalAlignment(Element.ALIGN_CENTER);
//            orderCells[1] = new PdfPCell(new Paragraph(machines[i].getType(),fontForBody));
//            orderCells[2] = new PdfPCell(new Paragraph(machines[i].getModel(),fontForBody));
////            double price = machines[i].getPrice();
//            orderCells[3] = new PdfPCell(new Paragraph("$" + price,fontForBody));
//            String num = productsArr[i].split(",")[1];
//            orderCells[4] = new PdfPCell(new Paragraph(num,fontForBody));
//            orderCells[4].setHorizontalAlignment(Element.ALIGN_CENTER);
//            double total = price * Double.parseDouble(num);
//            orderTotal += total;
//            orderCells[5] = new PdfPCell(new Paragraph("$" + String.valueOf(total) + ".00",fontForBody));
//            for(PdfPCell cell : orderCells) {
//                cell.setBackgroundColor(new BaseColor(238,238,238));
//                cell.setBorderColor(new BaseColor(22,22,22));
//                cell.setBorderWidth(1);
//                orderTable.addCell(cell);
//            }
//        }
//
//        orderCells[0] = new PdfPCell(new Paragraph("Order total",fontForBody));
//        orderCells[0].setColspan(5);
//        orderCells[0].setHorizontalAlignment(Element.ALIGN_RIGHT);
//        orderCells[1] = new PdfPCell(new Paragraph("$" + String.valueOf(orderTotal) + ".00",fontForBody));
//        for (int i = 0; i < 2; i++) {
//            orderCells[i].setBackgroundColor(new BaseColor(238,238,238));
//            orderCells[i].setBorderColor(new BaseColor(22, 22, 22));
//            orderCells[i].setBorderWidth(1);
//            orderTable.addCell(orderCells[i]);
//        }
//
//        return orderTable;
//    }

    private static PdfPTable getOrderTableWithoutPrices(String products, LiveToolEntity[] machines) throws DocumentException {
        PdfPTable orderTable = new PdfPTable(4);
        orderTable.setWidthPercentage(100);
        orderTable.setSpacingBefore(20f);
        orderTable.setSpacingAfter(10f);
        orderTable.setWidths(new float[]{0.8f, 8f, 8f, 2.5f});

        Font fontForHead = new Font(Font.FontFamily.TIMES_ROMAN,13,Font.BOLD);
        Font fontForBody = new Font(Font.FontFamily.TIMES_ROMAN,12);

        PdfPCell[] orderCells = new PdfPCell[4];
        orderCells[0] = new PdfPCell(new Paragraph());
        orderCells[1] = new PdfPCell(new Paragraph("Machine",fontForHead));
        orderCells[2] = new PdfPCell(new Paragraph("Model",fontForHead));
        orderCells[3] = new PdfPCell(new Paragraph("Quantity",fontForHead));
        for(PdfPCell cell : orderCells) {
            cell.setBackgroundColor(new BaseColor(238,238,238));
            cell.setBorderColor(new BaseColor(22, 22, 22));
            cell.setBorderWidth(1);
            orderTable.addCell(cell);
        }

        String[] productsArr = products.split(";");
        for (int i = 0; i < machines.length; i++) {
            orderCells[0] = new PdfPCell(new Paragraph(String.valueOf(i + 1),fontForBody));
            orderCells[0].setHorizontalAlignment(Element.ALIGN_CENTER);
            orderCells[1] = new PdfPCell(new Paragraph(machines[i].getType(),fontForBody));
            orderCells[2] = new PdfPCell(new Paragraph(machines[i].getModel(),fontForBody));
            String num = productsArr[i].split(",")[1];
            orderCells[3] = new PdfPCell(new Paragraph(num,fontForBody));
            orderCells[3].setHorizontalAlignment(Element.ALIGN_CENTER);
            for(PdfPCell cell : orderCells) {
                cell.setBackgroundColor(new BaseColor(238,238,238));
                cell.setBorderColor(new BaseColor(22,22,22));
                cell.setBorderWidth(1);
                orderTable.addCell(cell);
            }
        }

        return orderTable;
    }


    private static PdfPTable getItemTable(String path, LiveToolEntity machine, boolean showPrice) throws DocumentException, IOException {
        PdfPTable itemTable = new PdfPTable(4);
        itemTable.setWidthPercentage(100);
        itemTable.setSpacingBefore(20f);
        itemTable.setSpacingAfter(10f);
        itemTable.setWidths(new float[]{1f, 1f, 1f, 1f});

        Font fontBold = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD);
        Font font = new Font(Font.FontFamily.TIMES_ROMAN,12);

        PdfPCell[] itemCells = new PdfPCell[4];

        Image img;
        try {
            img = Image.getInstance(path + "/images/products/" + machine.getPhoto1());
            img.setScaleToFitHeight(false);
            itemCells[0] = new PdfPCell(img, true);
        } catch (Exception e) {
            itemCells[0] = new PdfPCell(new Paragraph(""));
        }
        itemCells[0].setColspan(2);
        itemCells[0].setPadding(1);
        itemCells[1] = new PdfPCell();
        itemCells[1].addElement(new Paragraph(machine.getModel(), fontBold));
        itemCells[1].addElement(new Paragraph(machine.getType() + "\n" + machine.getManufacturer() + ", " +
//                + machine.getProducingCountry() + ", " + machine.getInstrumentTypeEn() + "\nDrive type: "
//                + machine.getDriveType() +
                "\nTool Holder: " + machine.getToolHolder()
                + "\nDescription:\n" + machine.getDescription().replace("<br>",""), font));
        itemCells[1].setColspan(2);
        itemCells[1].setRowspan(2);
        itemCells[1].setPadding(5);
        for (int i = 0; i < 2; i++) {
            itemCells[i].setBorderColor(new BaseColor(22, 22, 22));
            itemTable.addCell(itemCells[i]);
        }

        try {
            img = Image.getInstance(path + "/images/products/" + machine.getPhoto2());
            img.setScaleToFitHeight(false);
            itemCells[0] = new PdfPCell(img, true);
        } catch (Exception e) {
            itemCells[0] = new PdfPCell(new Paragraph(""));
        }
        try {
            img = Image.getInstance(path + "/images/products/" + machine.getPhoto3());
            img.setScaleToFitHeight(false);
            itemCells[1] = new PdfPCell(img, true);
        } catch (Exception e) {
            itemCells[1] = new PdfPCell(new Paragraph(""));
        }
        for (int i = 0; i < 2; i++) {
            itemCells[i].setPadding(1);
            itemCells[i].setBorderColor(new BaseColor(22, 22, 22));
            itemTable.addCell(itemCells[i]);
        }

        itemCells[0] = new PdfPCell(new Paragraph("D", font));
        itemCells[1] = new PdfPCell(new Paragraph(String.valueOf(machine.getD()), font));
        itemCells[2] = new PdfPCell(new Paragraph("Clamping range, mm", font));
        itemCells[3] = new PdfPCell(new Paragraph(machine.getClampingRange(), font));
        for (int i = 0; i < 4; i++) {
            itemCells[i].setBackgroundColor(new BaseColor(238, 238, 238));
            itemCells[i].setBorderColor(new BaseColor(22, 22, 22));
            itemTable.addCell(itemCells[i]);
        }

        itemCells[0] = new PdfPCell(new Paragraph("S", font));
        itemCells[1] = new PdfPCell(new Paragraph(String.valueOf(machine.getS()), font));
        itemCells[2] = new PdfPCell(new Paragraph("Speed Max", font));
        itemCells[3] = new PdfPCell(new Paragraph(String.valueOf(machine.getSpeedMax()), font));
        for (int i = 0; i < 4; i++) {
            itemCells[i].setBorderColor(new BaseColor(22, 22, 22));
            itemTable.addCell(itemCells[i]);
        }

        itemCells[0] = new PdfPCell(new Paragraph("i", font));
        itemCells[1] = new PdfPCell(new Paragraph(String.valueOf(machine.getI()), font));
        itemCells[2] = new PdfPCell(new Paragraph("A", font));
        itemCells[3] = new PdfPCell(new Paragraph(String.valueOf(machine.getA()), font));
        for (int i = 0; i < 4; i++) {
            itemCells[i].setBackgroundColor(new BaseColor(238, 238, 238));
            itemCells[i].setBorderColor(new BaseColor(22, 22, 22));
            itemTable.addCell(itemCells[i]);
        }

        itemCells[0] = new PdfPCell(new Paragraph("B", font));
        itemCells[1] = new PdfPCell(new Paragraph(String.valueOf(machine.getB()), font));
        itemCells[2] = new PdfPCell(new Paragraph("C", font));
        itemCells[3] = new PdfPCell(new Paragraph(String.valueOf(machine.getC()), font));
        for (int i = 0; i < 4; i++) {
            itemCells[i].setBorderColor(new BaseColor(22, 22, 22));
            itemTable.addCell(itemCells[i]);
        }

        itemCells[0] = new PdfPCell(new Paragraph("E", font));
        itemCells[1] = new PdfPCell(new Paragraph(String.valueOf(machine.getE()), font));
        itemCells[2] = new PdfPCell(new Paragraph("M", font));
        itemCells[3] = new PdfPCell(new Paragraph(String.valueOf(machine.getM()), font));
        for (int i = 0; i < 4; i++) {
            itemCells[i].setBackgroundColor(new BaseColor(238, 238, 238));
            itemCells[i].setBorderColor(new BaseColor(22, 22, 22));
            itemTable.addCell(itemCells[i]);
        }

        itemCells[0] = new PdfPCell(new Paragraph("DIN", font));
        itemCells[1] = new PdfPCell(new Paragraph(machine.getDin(), font));
        itemCells[2] = new PdfPCell(new Paragraph("Coolant Supply", font));
        itemCells[3] = new PdfPCell(new Paragraph(String.valueOf(machine.getCoolantSupply()), font));
        for (int i = 0; i < 4; i++) {
            itemCells[i].setBorderColor(new BaseColor(22, 22, 22));
            itemTable.addCell(itemCells[i]);
        }

        itemCells[0] = new PdfPCell(new Paragraph("Code No.", font));
        itemCells[1] = new PdfPCell(new Paragraph(machine.getCodeNo(), font));
        itemCells[2] = new PdfPCell(new Paragraph("Order No.", font));
        itemCells[3] = new PdfPCell(new Paragraph(String.valueOf(machine.getOrderNo()), font));
        for (int i = 0; i < 4; i++) {
            itemCells[i].setBackgroundColor(new BaseColor(238, 238, 238));
            itemCells[i].setBorderColor(new BaseColor(22, 22, 22));
            itemTable.addCell(itemCells[i]);
        }
//
//        itemCells[0] = new PdfPCell(new Paragraph("Position/reposition precision, mm", font));
//        itemCells[1] = new PdfPCell(new Paragraph(machine.getPositionRepositionPrecision(), font));
//        itemCells[2] = new PdfPCell(new Paragraph("Machine launching, h", font));
//        itemCells[3] = new PdfPCell(new Paragraph(String.valueOf(machine.getMachineLaunching()), font));
//        for (int i = 0; i < 4; i++) {
//            itemCells[i].setBorderColor(new BaseColor(22, 22, 22));
//            itemTable.addCell(itemCells[i]);
//        }
//
//        if(showPrice) {
//            itemCells[1] = new PdfPCell(new Paragraph(""));
//            itemCells[1].setColspan(2);
//            itemCells[2] = new PdfPCell(new Paragraph("Price", font));
////            itemCells[3] = new PdfPCell(new Paragraph("$" + machine.getPrice(), font));
//            for (int i = 1; i < 4; i++) {
//                itemCells[i].setBackgroundColor(new BaseColor(238, 238, 238));
//                itemCells[i].setBorderColor(new BaseColor(22, 22, 22));
//                itemTable.addCell(itemCells[i]);
//            }
//        }

        return itemTable;
//        return null;
    }

    private static Paragraph getFooterParagraph() {
        Font font = new Font(Font.FontFamily.TIMES_ROMAN, 14);
        Font fontSmall = new Font(Font.FontFamily.TIMES_ROMAN, 12);
        Font fontSmallGreen = new Font(Font.FontFamily.TIMES_ROMAN, 12);
        fontSmallGreen.setColor(new BaseColor(89, 178, 16));

        Paragraph paragraph = new Paragraph();
        Chunk chunk = new Chunk("VMC & HMC",font);
        paragraph.add(chunk);
        chunk = new Chunk("\nvertical and horizontal machine centers\nUSA: ",fontSmall);
        paragraph.add(chunk);
        chunk = new Chunk("+1 203 556-50-69",fontSmallGreen);
        paragraph.add(chunk);
        chunk = new Chunk("\ncontact@",fontSmall);
        paragraph.add(chunk);
        chunk = new Chunk("vmccnc.com",fontSmallGreen);
        paragraph.add(chunk);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        return paragraph;
    }

    public static String createPDF(String path, String products, LiveToolEntity[] machines, String company, String director, boolean showPrice) throws Exception {
        Document document = new Document(PageSize.A4,50,50,50,50);
        String pathPdf = path + "/offer.pdf";
        PdfWriter.getInstance(document, new FileOutputStream(pathPdf));
        document.open();

        document.add(getHeaderTable(path));
        setForWhoData(document,company,director);
        if(!showPrice){
            document.add(getOrderTableWithoutPrices(products, machines));
        } else {
//            document.add(getOrderTable(products, machines));
        }
        for(LiveToolEntity machine : machines) {
            document.add(getItemTable(path, machine, showPrice));
        }
        document.add(getFooterParagraph());

        document.close();
        return pathPdf;
    }

    public static String createPDFSingle(String path, LiveToolEntity machine, String company, String director, boolean showPrice) throws Exception {
        Document document = new Document(PageSize.A4,50,50,50,50);
        String pathPdf = path + "/offer-single.pdf";
        PdfWriter.getInstance(document, new FileOutputStream(pathPdf));
        document.open();

        document.add(getHeaderTable(path));
        setForWhoData(document,company,director);
        document.add(getItemTable(path, machine, showPrice));
        document.add(getFooterParagraph());

        document.close();
        return pathPdf;
    }


    private static PdfPTable getHeaderTableChocolateLetter(String path) throws DocumentException, IOException {
        PdfPTable headerTable = new PdfPTable(3);
//        PdfPTable headerTable = new PdfPTable(2);
        headerTable.setWidthPercentage(100);
//        headerTable.setWidths(new float[]{1.5f,0.5f,2f});
        headerTable.setWidths(new float[]{2f,0.1f, 1.9f});

//cell1
//    Image imgLogo = Image.getInstance(path + "/images/logotype.png");
        Image imgLogo = Image.getInstance(path + "/images/logo_retina.png");
        PdfPCell cell1 = new PdfPCell(imgLogo,true);
        cell1.setBorder(Rectangle.NO_BORDER);
//cell2
        PdfPCell cell2 = new PdfPCell();
        cell2.setBorder(Rectangle.NO_BORDER);

        Font font = new Font(Font.FontFamily.TIMES_ROMAN, 14);
        Font greenFont = new Font(Font.FontFamily.TIMES_ROMAN, 14);
        greenFont.setColor(new BaseColor(89, 178, 16));

        PdfPCell cell3 = new PdfPCell();
        Paragraph paragraph = new Paragraph();
        Chunk chunk = new Chunk("Chocolate for your corporate identity.",font);
        paragraph.add(chunk);
        chunk = new Chunk("\n+375 (29) 255-88-88",greenFont);
        paragraph.add(chunk);
//        chunk = new Chunk("\ncontact@",font);
//        paragraph.add(chunk);
        chunk = new Chunk("\nwww.chocoart.by",greenFont);
        paragraph.add(chunk);
        paragraph.setAlignment(Element.ALIGN_RIGHT);
        cell3.addElement(paragraph);
        cell3.setBorder(Rectangle.NO_BORDER);

        headerTable.addCell(cell3);
        headerTable.addCell(cell2);
        headerTable.addCell(cell1);

        return headerTable;
    }

    private static void setForChocolateLetter(Document document, Letter inf, String director) throws DocumentException {
        Font fontBoldBig = new Font(Font.FontFamily.TIMES_ROMAN,22,Font.BOLD);
        Font fontNormal = new Font(Font.FontFamily.TIMES_ROMAN,14);
        Font fontNormal2 = new Font(Font.FontFamily.HELVETICA,14);
        //---------------
        PdfPTable headerTable = new PdfPTable(2);
        headerTable.setWidthPercentage(100);
        headerTable.setWidths(new float[]{2.5f, 1.5f});
//        headerTable.setWidths(new float[]{2.1f,0.1f, 1.8f});
//cell1
        PdfPCell cell1 = new PdfPCell();
        cell1.setBorder(Rectangle.NO_BORDER);
//cell2
        PdfPCell cell2 = new PdfPCell();
        cell2.setBorder(Rectangle.NO_BORDER);
        //------------------
        Paragraph paragraph1 = new Paragraph();
        Chunk chunk;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String stringDate = dateFormat.format(date);
        chunk = new Chunk(stringDate, fontNormal);
        paragraph1.add(chunk);
        paragraph1.setAlignment(Element.ALIGN_RIGHT);
//         document.add(paragraph);
// my
        cell2.addElement(paragraph1);
//         inf.setData(data);

//        if(!inf.getSubject().equals("")) {
//            chunk = new Chunk("\n\nto the director of " + inf.getSubject(), fontNormal);
//            paragraph.add(chunk);
//            if(!director.equals("")) {
//                chunk = new Chunk(", " + director, fontNormal);
//                paragraph.add(chunk);
//            }
//        } else if(!director.equals("")) {
//            chunk = new Chunk("for " + director, fontNormal);
//            paragraph.add(chunk);
//        }
        Paragraph paragraph = new Paragraph();
        if(!inf.getContactName().equals("")){
            paragraph = new Paragraph(""+inf.getContactName(),fontNormal);
//        document.add(paragraph);
            cell1.addElement(paragraph);
            if(!inf.getPosition().equals("")){
                paragraph = new Paragraph(inf.getPosition(),fontNormal);
//                  document.add(paragraph);
                cell1.addElement(paragraph);
            }
            paragraph = new Paragraph(inf.getCompany(),fontNormal);
//      document.add(paragraph);
            cell1.addElement(paragraph);
        }else{
            paragraph = new Paragraph(""+inf.getCompany(),fontNormal);
//     document.add(paragraph);
            cell1.addElement(paragraph);
        }
        paragraph = new Paragraph(inf.getAddress(),fontNormal);
//    document.add(paragraph);
        cell1.addElement(paragraph);
        if(!inf.getEmail().equals("")){
            paragraph = new Paragraph(inf.getEmail(),fontNormal);
//                document.add(paragraph);
            cell1.addElement(paragraph);
        }
        String w= inf.getWebsite().replaceAll("http://www.", "www.");
        String w2= w.replaceAll("com/", "com");
        paragraph = new Paragraph(w2,fontNormal);
//    document.add(paragraph);
        cell1.addElement(paragraph);
        paragraph.setAlignment(Element.ALIGN_LEFT);
        headerTable.addCell(cell1);
        headerTable.addCell(cell2);
        document.add(headerTable);
        if(!inf.getContactName().equals("")) {
            paragraph = new Paragraph("\nDear "+inf.getContactName()+",",fontNormal);
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);
        }else{
            paragraph = new Paragraph("\nDear chief of "+inf.getCompany()+",",fontNormal);
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);
        }
//        paragraph = new Paragraph("I hope you have a good day.",fontNormal);
//        document.add(paragraph);

        paragraph = new Paragraph("\nMy name is "+ inf.getManager() +".I am from Belarus.",fontNormal);
        paragraph.setAlignment(Element.ALIGN_BASELINE);
        document.add(paragraph);
//
//        paragraph = new Paragraph("I am a representative of VMCCNC group of companies. We work in USA and  Europe.",fontNormal);
//        paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
//        document.add(paragraph);

        paragraph = new Paragraph("\nI've browsed your website and noticed some information about your company:",fontNormal);
        paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
        document.add(paragraph);

        String s0 = inf.getDescription();
        String s1 = s0.replaceAll("\\r|\\n"," ");

        paragraph = new Paragraph("\""+s1+"\" ",fontNormal);


        paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
        document.add(paragraph);

        paragraph = new Paragraph("\nIt means you want to increase realization of yours products and communicate with your" +
                "customers. And sometimes you meet with customers and drink tea or coffee with candy " +
                "or chocolate. And very good if this chocolate would looks like your company stile.\n",fontNormal);
        paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
        document.add(paragraph);

        paragraph = new Paragraph("In this regard, I would like to offer you very tasty and very beautiful chocolate made in Belarus.\n",fontNormal);
        paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
        document.add(paragraph);

        paragraph = new Paragraph("I am a representative of chocolate factory “Belga-Prom”. We are producer of chocolate." +
                "We located in Minsk, Belarus." +
                "We could make interesting design of chocolate special for your company (with your company style).\n",fontNormal);
        paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
        document.add(paragraph);

        paragraph = new Paragraph("\n\"Make life sweet again!\"",fontNormal);
        paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
        document.add(paragraph);

        paragraph = new Paragraph("\nI hope you are interested our proposal.",fontNormal);
        document.add(paragraph);

        paragraph = new Paragraph("\nPlease message me,\n" +
                "And I give you more information about our tasty chocolate. :)\n",fontNormal);
        paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
        document.add(paragraph);

        paragraph = new Paragraph("\nHave a good day!",fontNormal);
        document.add(paragraph);

        paragraph = new Paragraph("\nBest regards,\n"+inf.getManager(),fontNormal);
        document.add(paragraph);
        paragraph = new Paragraph(inf.getEmailManager()+ "\n",fontNormal);
        document.add(paragraph);
        if (!inf.getPhoneManager().equals("")){
            paragraph = new Paragraph(inf.getPhoneManager()+ "\n",fontNormal);
            document.add(paragraph);
        }


    }

//    private static Paragraph getFooterParagraph() {
//        Font font = new Font(Font.FontFamily.TIMES_ROMAN, 14);
//        Font fontSmall = new Font(Font.FontFamily.TIMES_ROMAN, 12);
//        Font fontSmallGreen = new Font(Font.FontFamily.TIMES_ROMAN, 12);
//        fontSmallGreen.setColor(new BaseColor(89, 178, 16));
//
//        Paragraph paragraph = new Paragraph();
//        Chunk chunk = new Chunk();
////        chunk = new Chunk("VMC & HMC",font);
////        paragraph.add(chunk);
//        chunk = new Chunk("\nVertical and horizontal machine centers\nUSA: ",fontSmall);
//        paragraph.add(chunk);
////        chunk = new Chunk("+1 203 556-50-69",fontSmallGreen);
////        paragraph.add(chunk);
//        //        chunk = new Chunk("\ncontact@",fontSmall);
//        //        paragraph.add(chunk);
//        chunk = new Chunk("www.vmccnc.com",fontSmallGreen);
//        paragraph.add(chunk);
//        paragraph.setAlignment(Element.ALIGN_LEFT);
//        return paragraph;
//    }

    public static String createPDFLetter(String path, Letter message) throws Exception {
        Document document = new Document(PageSize.A4,70,30,30,10);
        String pathPdf = path + "/letter.pdf";
        PdfWriter.getInstance(document, new FileOutputStream(pathPdf));
        document.open();


        if(message.getTypeOfLetter().equals("Chocolate")){
            document.add(getHeaderTableChocolateLetter(path));
            setForChocolateLetter(document, message, message.getCompany());
        }
//        else if  (message.getTypeofletter().equals("Elevator")){
//            document.add(getHeaderTableForElevator(path));
//            setForElevator(document, message, message.getCompany());
//        }
        else {
//                 setForMachineCnc(document, message, message.getCompany());
            document.add(getFooterParagraph());
        }

//        document.add(getItemTable(path, machine, showPrice));
//      document.add(getFooterParagraph());


        document.close();
        return pathPdf;
    }


}
