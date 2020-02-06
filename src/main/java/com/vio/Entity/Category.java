package  com.vio.Entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@DynamicUpdate
public class Category {
  @Id
  private String categoryId;
  private String categoryName;
  private java.sql.Timestamp createTime;
  private String categoryImge;


  public String getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(String categoryId) {
    this.categoryId = categoryId;
  }


  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }


  public String getCategoryImge() {
    return categoryImge;
  }

  public void setCategoryImge(String categoryImge) {
    this.categoryImge = categoryImge;
  }

}
