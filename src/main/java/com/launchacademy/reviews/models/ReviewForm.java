package com.launchacademy.reviews.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

@Getter
@Setter
@NoArgsConstructor
public class ReviewForm {

  // trailId
  @NotNull
  private Integer trailId;

  // user data
  @NotBlank
  private String name;

  // review data
  @NotNull
  private Integer rating;

  private String comment;

  // image data
  @URL
  private String imgUrl;
}