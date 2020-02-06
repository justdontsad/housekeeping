package com.vio.Entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@DynamicUpdate
public class CategoryItem {
  @Id
  private String categoryItemId;
  private String categoryItemName;
  private java.sql.Timestamp createTime;
  private String categoryId;


  public String getCategoryItemId() {
    return categoryItemId;
  }

  public void setCategoryItemId(String categoryItemId) {
    this.categoryItemId = categoryItemId;
  }


  public String getCategoryItemName() {
    return categoryItemName;
  }

  public void setCategoryItemName(String categoryItemName) {
    this.categoryItemName = categoryItemName;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }


  public String getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(String categoryId) {
    this.categoryId = categoryId;
  }

}
