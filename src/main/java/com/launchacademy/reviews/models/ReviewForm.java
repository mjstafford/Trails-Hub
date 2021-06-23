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

  @NotNull
  private Integer trailId;

  @NotBlank
  private String name;

  @NotNull
  private Integer rating;

  private String comment;

  @URL
  private String imgUrl;
}