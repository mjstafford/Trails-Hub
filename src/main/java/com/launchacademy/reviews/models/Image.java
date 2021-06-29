package com.launchacademy.reviews.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="images")
public class Image {
  @Id
  @SequenceGenerator(name="images_generator", sequenceName = "images_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "images_generator")
  @Column(nullable = false, unique = true)
  private Integer id;

  @Column
  String location;

  @Column
  String imageName;

  public Image(String imageName, String location) {
    this.imageName = imageName;
    this.location = location;
  }

}