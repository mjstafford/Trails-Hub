package com.launchacademy.reviews.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
  @Column(columnDefinition = "numeric")
  private Double distance;

  @Column(columnDefinition = "numeric")
  private Double elevationGain;

  @Column
  private String difficulty;

  @Column
  private String zipCode;

  @Column
  private String imgUrl;
}
