package com.launchacademy.reviews.services;

import com.launchacademy.reviews.models.Image;
import com.launchacademy.reviews.repositories.FileSystemRepository;
import com.launchacademy.reviews.repositories.ImageRepository;
import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class FileLocationService {
  private final ImageRepository dbRepository;
  private final FileSystemRepository fsRepository;

  @Autowired
  FileLocationService(ImageRepository dbRepository,
      FileSystemRepository fsRepository) {
    this.dbRepository = dbRepository;
    this.fsRepository = fsRepository;
  }

  public Image save(byte[] bytes, String imageName) throws Exception {
    String location = fsRepository.save(bytes, imageName);

    File image = new File(location);
    return dbRepository.save(new Image(image.getName(), location));
  }

  public FileSystemResource find(String imageName) {
    Image image = dbRepository.findByImageName(imageName)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    return fsRepository.findInFileSystem(image.getLocation());
  }
}