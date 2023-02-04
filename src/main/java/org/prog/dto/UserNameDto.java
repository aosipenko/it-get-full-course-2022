package org.prog.dto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserNameDto {
  private String title;
  private String first;
  private String last;


  public UserNameDto(String title, String first, String last) {
    this.title = title;
    this.first = first;
    this.last = last;
  }


  public String getTitle() {
    return title;
  }

  public String getFirst() {
    return first;
  }

  public String getLast() {
    return last;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setFirst(String first) {
    this.first = first;
  }

  public void setLast(String last) {
    this.last = last;
  }
}
