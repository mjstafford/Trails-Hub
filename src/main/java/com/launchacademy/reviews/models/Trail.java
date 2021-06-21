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
@Table(name="trails")
public class Trail {
  @Id
  @SequenceGenerator(name="trails_generator", sequenceName = "trails_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trails_generator")
  @Column(nullable = false, unique = true)
  private Integer id;

  @Column
  private String name;

  @Column
  private String description;

  @Column
  private Double distance;

  @Column
  private Double elevationGain;

  @Column
  private String difficulty;

  @Column
  private String zipCode;

  @Column
  private String imgUrl;
}
