package com.launchacademy.reviews.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="trails")
public class Trail {
  @Id
  @SequenceGenerator(name="trails_generator", sequenceName = "trails_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trails_generator")
  @Column(nullable = false, unique = true)
  private Integer id;

  @NotBlank
  @Column
  private String name;

  @NotBlank(message = "Please give us a description")
  @Column
  private String description;

  @NotNull(message = "Enter a distance of at least .1 miles")
  @DecimalMin(value = "0.1", message = "Enter a distance of at least .1 miles")
  @Column(columnDefinition = "numeric")
  private Double distance;

  @NotNull(message = "Enter a valid elevation gain")
  @Min(value = 0, message = "Enter a valid elevation gain")
  //@Pattern(regexp = "^\\d*\\.?\\d*$", message = "Enter a valid elevation gain")
  @Column(columnDefinition = "numeric")
  private Double elevationGain;

  @NotBlank(message = "Select a difficulty level for your trail")
  @Column
  private String difficulty;

  @NotBlank(message = "must be a 5 digit number")
  @Pattern(regexp = "^\\d{5}$", message = "must be a 5 digit number")
  @Column
  private String zipCode;

  @NotBlank(message = "must be valid")
  @URL(message = "must be valid")
  @Column
  private String imgUrl;
}