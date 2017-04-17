package com.springapp.mvc.service.implementions;

//import com.springapp.mvc.dao.interfaces.CommonDao;
import com.springapp.mvc.dao.interfaces.*;

import com.springapp.mvc.domain.product.hmc.LiveTool;
import com.springapp.mvc.domain.product.robots.Robots;
import com.springapp.mvc.service.interfaces.WorkWithFilesService;
import com.springapp.mvc.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

@Service
public class WorkWithFilesServiceImpl implements WorkWithFilesService {
  
    @Autowired
    private LiveToolDAO liveToolDAO;
    
    @Autowired
    private BrandFilterDAO brandFilterDAO;

    @Autowired
    private RobotsDAO robotsDAO;

    @Autowired
    private ManufacturerFilterDAO manufacturerFilterDAO;

    @Autowired
    private LocationFilterDAO locationFilterDAO;

    @Transactional
    public ResponseEntity<byte[]> getPDFOffer(String path, String products, String company, String director, boolean showPrice) throws Exception {
        String[] productsArr = products.split(";");
        LiveTool[] machines = new LiveTool[productsArr.length];
        for (int i = 0; i < machines.length; i++) {
            machines[i] = liveToolDAO.getMachine(productsArr[i].split(",")[0]);
        }

        String pathPdf = GeneratePdfUtil.createPDF(path, products, machines, company, director, showPrice);

        File file = new File(pathPdf);
        byte[] contents = new byte[(int) file.length()];
        new FileInputStream(file).read(contents);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        String filename = "VMC-HMC-offer.pdf";
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        return new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<byte[]> getPDFOfferSingle(String path, String productId, String company, String director, boolean showPrice) throws Exception {
        LiveTool machine = liveToolDAO.getMachine(productId);

        String pathPdf = GeneratePdfUtil.createPDFSingle(path, machine, company, director, showPrice);

        File file = new File(pathPdf);
        byte[] contents = new byte[(int) file.length()];
        new FileInputStream(file).read(contents);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        String filename = "VMC-HMC-offer-" + productId + ".pdf";
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        return new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
    }

    @Transactional
    public void uploadMachines(String path, MultipartFile[] machines) {
        for (int i = 0; i < machines.length; i++) {
            try {
                File uploadFile = UploadMultipartFileUtil.uploadFile(path, machines[i]);
                LiveTool machine = ParserExcelUtil.readLiveTool(uploadFile);
                liveToolDAO.addMachine(machine);
                uploadFile.delete();
                System.out.println("Successfully uploaded machine: " + machines[i].getOriginalFilename());
            } catch (IOException e) {
                System.out.println("Failed to upload machine file: " + e.getMessage());
            }
        }
    }

    @Transactional
    public void uploadRobot(String path, MultipartFile[] machines) {
        for (int i = 0; i < machines.length; i++) {
            try {
                File uploadFile = UploadMultipartFileUtil.uploadFile(path, machines[i]);
                Robots robots = ParserExcelUtil.readRobot(uploadFile);
                robotsDAO.addRobot(robots);
                manufacturerFilterDAO.addManufacturer(robots.getManufacturer());
                uploadFile.delete();
                System.out.println("Successfully uploaded machine: " + machines[i].getOriginalFilename());
            } catch (IOException e) {
                System.out.println("Failed to upload machine file: " + e.getMessage());

            }
        }
    }


//    @Transactional
//    public void uploadLathes(String path, MultipartFile[] machines) {
//        for (int i = 0; i < machines.length; i++) {
//            try {
//                File uploadFile = UploadMultipartFileUtil.uploadFile(path, machines[i]);
//                List<LanguageEntity> languages = commonDAO.listLanguage();
//                Map<String, Object> lathes = ReadExcelUtil.readLathes(uploadFile, languages);
//
//                latheDAO.addLatheShort((LatheShortEntity)lathes.get("latheShort"));
//                latheDAO.addLatheFull((LatheFullEntity) lathes.get("latheFull"));
//                LatheLangShortEntity[] latheLangShort = (LatheLangShortEntity[])lathes.get("latheLangShort");
//                LatheLangFullEntity[] latheLangFull = (LatheLangFullEntity[])lathes.get("latheLangFull");
//                for (int k = 0; k < latheLangShort.length; k++) {
//                    latheDAO.addLatheLangShort(latheLangShort[k]);
//                    latheDAO.addLatheLangFull(latheLangFull[k]);
//                }
//
//                uploadFile.delete();
//                System.out.println("Successfully uploaded lathe: " + machines[i].getOriginalFilename());
//            } catch (Exception e) {
//                System.out.println("Failed to upload lathe file: " + e.getMessage());
//            }
//        }
//    }

    @Transactional
    public void uploadImages(String path, MultipartFile[] images) {
        for (int i = 0; i < images.length; i++) {
            try {
                UploadMultipartFileUtil.uploadImage(path, images[i]);
                System.out.println("Successfully uploaded photo: " + images[i].getOriginalFilename());
            } catch (IOException e) {
                System.out.println("Failed to upload photo: " + e.getMessage());
            }
        }
    }
    @Transactional
    public void uploadImagesLathe(String path, MultipartFile[] images) {
        for (int i = 0; i < images.length; i++) {
            try {
                UploadMultipartFileUtil.uploadImage(path, images[i]);
                System.out.println("Successfully uploaded photo: " + images[i].getOriginalFilename());
            } catch (IOException e) {
                System.out.println("Failed to upload photo: " + e.getMessage());
            }
        }
    }

    @Transactional
    public String[] listImage(String path) {
        return ImageUtil.getListImage(path);
    }
 


    @Transactional
    public void removeImage(String path, String image) {
        ImageUtil.removeImage(path, image);
    }

                // Print in File
     protected void printInFile(String fileName, String str){    // For Check             
         File file = new File("d:\\2\\"+fileName);         
//            File file = new File("HMC exeption2.txt");
         FileWriter fileWriter =null;
        try  {
         fileWriter=  new FileWriter(file, true);
            fileWriter.write("-------> "+new Date()+"): \n");
            fileWriter.write(str + "\n\n");
            fileWriter.close();
            fileWriter.flush();
            
        } catch (IOException ex) {
//            Logger.getLogger(ControllerMachine.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        } 
}
