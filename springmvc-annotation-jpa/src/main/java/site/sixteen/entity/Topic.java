package site.sixteen.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Topic {

  @Id
  private long id;
  private String title;
  private String content;
  private long praise;
  private long hit;
  @Column(name = "user_id")
  private long userId;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public long getPraise() {
    return praise;
  }

  public void setPraise(long praise) {
    this.praise = praise;
  }


  public long getHit() {
    return hit;
  }

  public void setHit(long hit) {
    this.hit = hit;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

}
