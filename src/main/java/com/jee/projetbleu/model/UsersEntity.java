package com.jee.projetbleu.model;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "javademo")
public class UsersEntity {
    private int id;
    private String login;
    private String mdp;
    
    @Id
    @Column(name = "IDUSERS")
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    @Basic
    @Column(name = "LOGIN")
    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    @Basic
    @Column(name = "MDP")
    public String getMdp() {
        return mdp;
    }
    
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        UsersEntity that = (UsersEntity) o;
        
        if (id != that.id) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        return mdp != null ? mdp.equals(that.mdp) : that.mdp == null;
    }
    
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (mdp != null ? mdp.hashCode() : 0);
        return result;
    }
}
