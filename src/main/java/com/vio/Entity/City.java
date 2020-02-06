package com.vio.Entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@DynamicUpdate
public class City {
  @Id
  private String id;
  private String code;
  private String pcode;
  private String logogram;
  private String name;
  private String spell;
  private String spellsx;
  private String parentName;

  public City() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }


  public String getPcode() {
    return pcode;
  }

  public void setPcode(String pcode) {
    this.pcode = pcode;
  }


  public String getLogogram() {
    return logogram;
  }

  public void setLogogram(String logogram) {
    this.logogram = logogram;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getSpell() {
    return spell;
  }

  public void setSpell(String spell) {
    this.spell = spell;
  }


  public String getSpellsx() {
    return spellsx;
  }

  public void setSpellsx(String spellsx) {
    this.spellsx = spellsx;
  }


  public String getParentName() {
    return parentName;
  }

  public void setParentName(String parentName) {
    this.parentName = parentName;
  }

}
