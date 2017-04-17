package com.springapp.mvc.util;

//import com.springapp.mvc.domain.common.LanguageEntity;


//import com.springapp.mvc.domain.lathe.*;
import com.springapp.mvc.domain.product.hmc.LiveTool;
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

    public static LiveTool readLiveTool(File file) throws IOException{
        FileInputStream fis = new FileInputStream(file);
        Workbook workbook = getWorkbook(fis,file.getPath());
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = firstSheet.iterator();
        DataFormatter df = new DataFormatter();

        LiveTool hmc = new LiveTool();
        hmc.setProductId(df.formatCellValue(rowIterator.next().getCell(1)).trim());
        hmc.setType(df.formatCellValue(rowIterator.next().getCell(1)).trim());
        Row tmp = rowIterator.next();
        hmc.setInstrumentTypeEn(df.formatCellValue(tmp.getCell(1)));
        hmc.setInstrumentTypeRu(df.formatCellValue(tmp.getCell(2)).trim());
        hmc.setModel(df.formatCellValue(rowIterator.next().getCell(1)));
        hmc.setBrand(df.formatCellValue(rowIterator.next().getCell(1)).trim());
        hmc.setProducingCountry(df.formatCellValue(rowIterator.next().getCell(1)));
        hmc.setLandingDiameter(df.formatCellValue(rowIterator.next().getCell(1)).trim());
        hmc.setDriveType(df.formatCellValue(rowIterator.next().getCell(1)).trim());
        hmc.setToolHolder(df.formatCellValue(rowIterator.next().getCell(1)));
        hmc.setClampingRange(df.formatCellValue(rowIterator.next().getCell(1)));
        hmc.setN1_n2(df.formatCellValue(rowIterator.next().getCell(1)));
        hmc.setTorqueMax(df.formatCellValue(rowIterator.next().getCell(1)).trim());
        hmc.setLengthWorkingPart(df.formatCellValue(rowIterator.next().getCell(1)).trim());
        hmc.setDisplacement(df.formatCellValue(rowIterator.next().getCell(1)));
        hmc.setInternalSupply(df.formatCellValue(rowIterator.next().getCell(1)));
        hmc.setWeight(Integer.parseInt(df.formatCellValue(rowIterator.next().getCell(1))));
        hmc.setPhoto1(df.formatCellValue(rowIterator.next().getCell(1)));
        hmc.setPhoto2(df.formatCellValue(rowIterator.next().getCell(1)));
        hmc.setPhoto3(df.formatCellValue(rowIterator.next().getCell(1)));
        hmc.setDrawing(df.formatCellValue(rowIterator.next().getCell(1)));
        hmc.setPrice(Double.parseDouble(df.formatCellValue(rowIterator.next().getCell(1))));
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
        robot.setManufacturer(df.formatCellValue(rowIterator.next().getCell(1)).trim());
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
    


}
