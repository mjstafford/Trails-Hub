package com.launchacademy.reviews.models;

import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

  private List<Image> images;
}