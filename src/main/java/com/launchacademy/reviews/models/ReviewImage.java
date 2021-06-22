package com.launchacademy.reviews.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="review_images")
public class ReviewImage {
  @Id
  @SequenceGenerator(name="review_images_generator", sequenceName = "review_images_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_images_generator")
  @Column(nullable = false, unique = true)
  private Integer id;

  @NotBlank
  @Column
  private String imgUrl;

  @ManyToOne
  @JoinColumn(name="review_id")
  @JsonIgnoreProperties("reviewImages")
  private Review review;

}
