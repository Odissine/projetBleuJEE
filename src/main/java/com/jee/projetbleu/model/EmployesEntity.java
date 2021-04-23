package com.jee.projetbleu.model;

import javax.persistence.*;

@Entity
@Table(name = "employes", schema = "javademo", catalog = "")
public class EmployesEntity {
  private int id;
  private String nom;
  private String prenom;
  private String teldom;
  private String telport;
  private String telpro;
  private String adresse;
  private String codepostal;
  private String ville;
  private String email;

  @Id
  @Column(name = "ID")
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Basic
  @Column(name = "NOM")
  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  @Basic
  @Column(name = "PRENOM")
  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  @Basic
  @Column(name = "TELDOM")
  public String getTeldom() {
    return teldom;
  }

  public void setTeldom(String teldom) {
    this.teldom = teldom;
  }

  @Basic
  @Column(name = "TELPORT")
  public String getTelport() {
    return telport;
  }

  public void setTelport(String telport) {
    this.telport = telport;
  }

  @Basic
  @Column(name = "TELPRO")
  public String getTelpro() {
    return telpro;
  }

  public void setTelpro(String telpro) {
    this.telpro = telpro;
  }

  @Basic
  @Column(name = "ADRESSE")
  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  @Basic
  @Column(name = "CODEPOSTAL")
  public String getCodepostal() {
    return codepostal;
  }

  public void setCodepostal(String codepostal) {
    this.codepostal = codepostal;
  }

  @Basic
  @Column(name = "VILLE")
  public String getVille() {
    return ville;
  }

  public void setVille(String ville) {
    this.ville = ville;
  }

  @Basic
  @Column(name = "EMAIL")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @SuppressWarnings("checkstyle:NeedBraces")
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    EmployesEntity that = (EmployesEntity) o;

    if (id != that.id) return false;
    if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
    if (prenom != null ? !prenom.equals(that.prenom) : that.prenom != null) return false;
    if (teldom != null ? !teldom.equals(that.teldom) : that.teldom != null) return false;
    if (telport != null ? !telport.equals(that.telport) : that.telport != null) return false;
    if (telpro != null ? !telpro.equals(that.telpro) : that.telpro != null) return false;
    if (adresse != null ? !adresse.equals(that.adresse) : that.adresse != null) return false;
    if (codepostal != null ? !codepostal.equals(that.codepostal) : that.codepostal != null) return false;
    if (ville != null ? !ville.equals(that.ville) : that.ville != null) return false;
    return email != null ? email.equals(that.email) : that.email == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (nom != null ? nom.hashCode() : 0);
    result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
    result = 31 * result + (teldom != null ? teldom.hashCode() : 0);
    result = 31 * result + (telport != null ? telport.hashCode() : 0);
    result = 31 * result + (telpro != null ? telpro.hashCode() : 0);
    result = 31 * result + (adresse != null ? adresse.hashCode() : 0);
    result = 31 * result + (codepostal != null ? codepostal.hashCode() : 0);
    result = 31 * result + (ville != null ? ville.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    return result;
  }
}
