package com.launchacademy.reviews.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

  @NotBlank
  @Column
  private String description;

  @NotNull
  @DecimalMin("0.1")
  @Column(columnDefinition = "numeric")
  private Double distance;

  @NotNull
  @Min(0)
  @Column(columnDefinition = "numeric")
  private Double elevationGain;

  @NotBlank
  @Column
  private String difficulty;

  @NotBlank
  @Pattern(regexp = "^\\d{5}$")
  @Column
  private String zipCode;

  @NotBlank
  @Column
  private String imgUrl;

  @OneToMany(mappedBy = "trail")
  @JsonIgnoreProperties("trail")
  private List<Review> reviews;
}
