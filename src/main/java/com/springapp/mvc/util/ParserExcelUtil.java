package com.springapp.mvc.util;

import com.springapp.mvc.domain.product.Letter;
import com.springapp.mvc.domain.product.hmc.LiveToolEntity;
import com.springapp.mvc.domain.product.robots.Robots;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ParserExcelUtil {

    private static Workbook getWorkbook(FileInputStream inputStream, String excelFilePath) throws IOException {
        Workbook workbook = null;
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        }
        return workbook;
    }

    public static LiveToolEntity readLiveTool(File file) throws IOException{
        FileInputStream fis = new FileInputStream(file);
        Workbook workbook = getWorkbook(fis,file.getPath());
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = firstSheet.iterator();
        DataFormatter df = new DataFormatter();

        LiveToolEntity hmc = new LiveToolEntity();
        hmc.setProductId(df.formatCellValue(rowIterator.next().getCell(1)).trim());
        hmc.setType(df.formatCellValue(rowIterator.next().getCell(1)).trim());
        hmc.setManufacturer(df.formatCellValue(rowIterator.next().getCell(1)));
        hmc.setModel(df.formatCellValue(rowIterator.next().getCell(1)));
        hmc.setD(Integer.parseInt(df.formatCellValue(rowIterator.next().getCell(1))));
        hmc.setToolHolder(df.formatCellValue(rowIterator.next().getCell(1)));
        hmc.setClampingRange(df.formatCellValue(rowIterator.next().getCell(1)).trim());
        hmc.setS(Double.parseDouble(df.formatCellValue(rowIterator.next().getCell(1)).trim()));
        hmc.setSpeedMax(Integer.parseInt(df.formatCellValue(rowIterator.next().getCell(1))));
        hmc.setI(df.formatCellValue(rowIterator.next().getCell(1)).trim());
        hmc.setA(Double.parseDouble(df.formatCellValue(rowIterator.next().getCell(1)).trim()));
        hmc.setB(Double.parseDouble(df.formatCellValue(rowIterator.next().getCell(1))));
        hmc.setC(Double.parseDouble(df.formatCellValue(rowIterator.next().getCell(1))));
        hmc.setE(Double.parseDouble(df.formatCellValue(rowIterator.next().getCell(1))));
        hmc.setM(Double.parseDouble(df.formatCellValue(rowIterator.next().getCell(1))));
        hmc.setCodeNo(df.formatCellValue(rowIterator.next().getCell(1)));
        hmc.setOrderNo(df.formatCellValue(rowIterator.next().getCell(1)));
        hmc.setCoolantSupply(df.formatCellValue(rowIterator.next().getCell(1)));
        hmc.setDin(df.formatCellValue(rowIterator.next().getCell(1)));
        hmc.setPhoto1(df.formatCellValue(rowIterator.next().getCell(1)));
        hmc.setPhoto2(df.formatCellValue(rowIterator.next().getCell(1)));
        hmc.setPhoto3(df.formatCellValue(rowIterator.next().getCell(1)));
        hmc.setDescription(df.formatCellValue(rowIterator.next().getCell(1)));
        hmc.setIsSold("No");
//        if(hmc.getIsSold().equals("")) {
//            hmc.setIsSold("No");
//        }
        fis.close();
        return hmc;

    }

    public static Robots readRobot(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        Workbook workbook = getWorkbook(fis,file.getPath());
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = firstSheet.iterator();
        DataFormatter df = new DataFormatter();

        Robots robot = new Robots();
        robot.setProductId(df.formatCellValue(rowIterator.next().getCell(1)).trim());
        robot.setType(df.formatCellValue(rowIterator.next().getCell(1)).trim());
        robot.setModel(df.formatCellValue(rowIterator.next().getCell(1)));
        robot.setBrand(df.formatCellValue(rowIterator.next().getCell(1)).trim());
        robot.setYear(Integer.parseInt(df.formatCellValue(rowIterator.next().getCell(1))));
        robot.setCondition(df.formatCellValue(rowIterator.next().getCell(1)).trim());
        robot.setLocation(df.formatCellValue(rowIterator.next().getCell(1)).trim());
        robot.setAxes(df.formatCellValue(rowIterator.next().getCell(1)));
        robot.setLoad(Integer.parseInt(df.formatCellValue(rowIterator.next().getCell(1))));
        robot.setReach(Integer.parseInt(df.formatCellValue(rowIterator.next().getCell(1))));
        robot.setFootprint(df.formatCellValue(rowIterator.next().getCell(1)));
        robot.setRepeatability(Integer.parseInt(df.formatCellValue(rowIterator.next().getCell(1))));
        robot.setWeight(Integer.parseInt(df.formatCellValue(rowIterator.next().getCell(1))));
        robot.setPrice(Integer.parseInt(df.formatCellValue(rowIterator.next().getCell(1))));
        robot.setPhoto1(df.formatCellValue(rowIterator.next().getCell(1)));
        robot.setPhoto2(df.formatCellValue(rowIterator.next().getCell(1)));
        robot.setPhoto3(df.formatCellValue(rowIterator.next().getCell(1)));
        robot.setDescriptionEn(df.formatCellValue(rowIterator.next().getCell(1)));
        robot.setDescriptionRu(df.formatCellValue(rowIterator.next().getCell(1)));
        robot.setVideo1(df.formatCellValue(rowIterator.next().getCell(1)));
        robot.setVideo2(df.formatCellValue(rowIterator.next().getCell(1)));
        robot.setVideo3(df.formatCellValue(rowIterator.next().getCell(1)));
        robot.setSold("No");
//        if(!robot.getSold().equals("Yes")) {
//            robot.setSold("No");
//        }
        fis.close();
        return robot;
    }

    public static Letter readLetter(File file) throws IOException{
        FileInputStream fis = new FileInputStream(file);
        Workbook workbook = getWorkbook(fis,file.getPath());
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = firstSheet.iterator();
        DataFormatter df = new DataFormatter();

        Letter letter = new Letter();
        letter.setTypeOfLetter(df.formatCellValue(rowIterator.next().getCell(1)).trim());
        letter.setWebsite(df.formatCellValue(rowIterator.next().getCell(1)).trim());
        letter.setCompany(df.formatCellValue(rowIterator.next().getCell(1)).trim());
        letter.setPosition(df.formatCellValue(rowIterator.next().getCell(1)).trim());
        letter.setContactName(df.formatCellValue(rowIterator.next().getCell(1)).trim());
        letter.setAddress(df.formatCellValue(rowIterator.next().getCell(1)).trim());
        letter.setEmail(df.formatCellValue(rowIterator.next().getCell(1)).trim());
        letter.setDescription(df.formatCellValue(rowIterator.next().getCell(1)).trim());
        letter.setManager(df.formatCellValue(rowIterator.next().getCell(1)).trim());
        letter.setEmailManager(df.formatCellValue(rowIterator.next().getCell(1)).trim());
        letter.setPhoneManager(df.formatCellValue(rowIterator.next().getCell(1)).trim());
        fis.close();
        return letter;
    }


}
