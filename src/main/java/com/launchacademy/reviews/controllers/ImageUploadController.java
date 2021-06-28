package com.launchacademy.reviews.controllers;

import com.launchacademy.reviews.models.Image;
import com.launchacademy.reviews.repositories.ImageRepository;
import com.launchacademy.reviews.services.ImageService;
import com.launchacademy.reviews.services.ImageStorageService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping("/images")
public class ImageUploadController {

  private final ImageService imageService;

  @Autowired
  public ImageUploadController(ImageService imageService) {
    this.imageService = imageService;
  }

//  @GetMapping("/files/{filename:.+}")
//  @ResponseBody
//  public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
//
//    Resource file = storageService.loadAsResource(filename);
//    return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
//        "attachment; filename=\"" + file.getFilename() + "\"").body(file);
//  }

  @PostMapping
  public ResponseEntity<Integer> handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
    Image newImage = new Image();
    newImage.setContent(file.getBytes());
    return new ResponseEntity(imageService.save(newImage), HttpStatus.ACCEPTED);
  }

}
