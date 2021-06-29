package com.launchacademy.reviews.controllers;

import com.launchacademy.reviews.models.Image;
import com.launchacademy.reviews.repositories.ImageRepository;
import com.launchacademy.reviews.services.FileLocationService;
import com.launchacademy.reviews.services.ImageService;
import com.launchacademy.reviews.services.ImageStorageService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping("/images")
public class ImageController {

  private final FileLocationService fileLocationService;

  @Autowired
  public ImageController(FileLocationService fileLocationService) {
    this.fileLocationService = fileLocationService;
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
  public Image uploadImage(@RequestParam MultipartFile file) throws Exception {
    return fileLocationService.save(file.getBytes(), file.getOriginalFilename());
  }

  @GetMapping(value = "/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
  public FileSystemResource downloadImage(@PathVariable String imageName) throws Exception {
    return fileLocationService.find(imageName);
  }
}