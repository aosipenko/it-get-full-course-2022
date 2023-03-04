package org.prog.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Persons")
@Data
public class Persons {

  @Id
  @Column(name = "PersonID", nullable = false)
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long personId;

  @Column(name = "LastName")
  private String lastName;

  @Column(name = "FirstName")
  private String firstName;

  @Column(name = "Title")
  private String title;

  @Column(name = "Gender")
  private String gender;
}
