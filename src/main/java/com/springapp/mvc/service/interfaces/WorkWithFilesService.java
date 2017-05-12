package com.springapp.mvc.service.interfaces;

import com.springapp.mvc.domain.product.Letter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface WorkWithFilesService {
    public ResponseEntity<byte[]> getPDFOffer(String path, String products, String company, String director, boolean showPrice) throws Exception;
    public ResponseEntity<byte[]> getPDFOfferSingle(String path, String productId,
                                                    String company, String director, boolean showPrice) throws Exception;
    public ResponseEntity<byte[]> getPDFLetter(String path, Letter letter) throws Exception;
    public void uploadMachines(String path, MultipartFile[] machines);
    public void uploadRobot(String path, MultipartFile[] robots);
    public void uploadImages(String path, MultipartFile[] images);
    public Letter uploadInformationLetter(String path, MultipartFile letter);
    public String[] listImage(String path);

    public void removeImage(String path, String image);

}
