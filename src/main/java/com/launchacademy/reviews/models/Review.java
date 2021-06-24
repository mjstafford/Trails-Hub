package com.launchacademy.reviews.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

@Getter
@Setter
@NoArgsConstructor
@DynamicInsert
@Entity
@Table(name="reviews")
public class Review {

  @Id
  @SequenceGenerator(name = "reviews_generator", sequenceName = "reviews_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reviews_generator")
  @Column(nullable = false, unique = true)
  private Integer id;

  @NotNull
  @Column
  private Integer rating;

  @Column
  private String comment;

  @Column
  private Timestamp createdAt;

  @NotNull
  @ManyToOne
  @JoinColumn(name="trail_id")
  @JsonIgnoreProperties("reviews")
  private Trail trail;

  @NotNull
  @ManyToOne
  @JoinColumn(name="user_id")
  @JsonIgnoreProperties("reviews")
  private User user;

  @OneToMany(mappedBy = "review")
  @JsonIgnoreProperties("review")
  private List<ReviewImage> reviewImages;
}