package ru.netology.model;

public class Post {
  private long id = 0;
  private String content;

  public Post() {
  }

  public Post(String content) {
    this.id ++;
    this.content = content;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
