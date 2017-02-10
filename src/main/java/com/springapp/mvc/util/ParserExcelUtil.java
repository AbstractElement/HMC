package com.springapp.mvc.util;

//import com.springapp.mvc.domain.common.LanguageEntity;

import com.springapp.mvc.domain.hmc.Hmc;

//import com.springapp.mvc.domain.lathe.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

    public static Hmc readHmc(File file) throws IOException{
        FileInputStream fis = new FileInputStream(file);
        Workbook workbook = getWorkbook(fis,file.getPath());
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = firstSheet.iterator();
        DataFormatter df = new DataFormatter();

        Hmc hmc = new Hmc();
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

    
    


}
