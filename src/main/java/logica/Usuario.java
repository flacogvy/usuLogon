package logica;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="USUARIO")
public class Usuario implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column (name="USR_ID")
  private Long usr_id;
  
  @Column (name="USR_ALIAS")
  private String usr_alias;
  @Column (name="PER_ID")
  private Long per_id;
  @Column (name="USR_PASSWORD")
  private String usr_password;
  @Column (name="USR_TIPO")
  private String usr_tipo;
  @Column (name="USR_ESTADO")
  private String usr_estado;
  @Column (name="USR_ULTLOGON")
  private String usr_ultlogon;
  @Column (name="USR_FEHOCREA")
  private String usr_fehocrea;
  @Column (name="USR_USUCREA")
  private String usr_usucrea;
  @Column (name="USR_MODCREA")
  private String usr_modcrea;
  @Column (name="USR_FEHOMODI")
  private String usr_fehomodi;
  @Column (name="USR_USUMODI")
  private String usr_usumodi;
  @Column (name="USR_MODMODI")
  private String usr_modmodi;

  public Usuario() {
  }

  public Usuario(Long usr_id, String usr_alias, Long per_id, String usr_password, 
          String usr_tipo, String usr_estado, String usr_ultlogon, String usr_fehocrea, 
          String usr_usucrea, String usr_modcrea, String usr_fehomodi, String usr_usumodi, 
          String usr_modmodi) {
    this.usr_id = usr_id;
    this.usr_alias = usr_alias;
    this.per_id = per_id;
    this.usr_password = usr_password;
    this.usr_tipo = usr_tipo;
    this.usr_estado = usr_estado;
    this.usr_ultlogon = usr_ultlogon;
    this.usr_fehocrea = usr_fehocrea;
    this.usr_usucrea = usr_usucrea;
    this.usr_modcrea = usr_modcrea;
    this.usr_fehomodi = usr_fehomodi;
    this.usr_usumodi = usr_usumodi;
    this.usr_modmodi = usr_modmodi;
  }

  public Long getUsr_id() {
    return usr_id;
  }

  public void setUsr_id(Long usr_id) {
    this.usr_id = usr_id;
  }

  public String getUsr_alias() {
    return usr_alias;
  }

  public void setUsr_alias(String usr_alias) {
    this.usr_alias = usr_alias;
  }

  public Long getPer_id() {
    return per_id;
  }

  public void setPer_id(Long per_id) {
    this.per_id = per_id;
  }

  public String getUsr_password() {
    return usr_password;
  }

  public void setUsr_password(String usr_password) {
    this.usr_password = usr_password;
  }

  public String getUsr_tipo() {
    return usr_tipo;
  }

  public void setUsr_tipo(String usr_tipo) {
    this.usr_tipo = usr_tipo;
  }

  public String getUsr_estado() {
    return usr_estado;
  }

  public void setUsr_estado(String usr_estado) {
    this.usr_estado = usr_estado;
  }

  public String getUsr_ultlogon() {
    return usr_ultlogon;
  }

  public void setUsr_ultlogon(String usr_ultlogon) {
    this.usr_ultlogon = usr_ultlogon;
  }

  public String getUsr_fehocrea() {
    return usr_fehocrea;
  }

  public void setUsr_fehocrea(String usr_fehocrea) {
    this.usr_fehocrea = usr_fehocrea;
  }

  public String getUsr_usucrea() {
    return usr_usucrea;
  }

  public void setUsr_usucrea(String usr_usucrea) {
    this.usr_usucrea = usr_usucrea;
  }

  public String getUsr_modcrea() {
    return usr_modcrea;
  }

  public void setUsr_modcrea(String usr_modcrea) {
    this.usr_modcrea = usr_modcrea;
  }

  public String getUsr_fehomodi() {
    return usr_fehomodi;
  }

  public void setUsr_fehomodi(String usr_fehomodi) {
    this.usr_fehomodi = usr_fehomodi;
  }

  public String getUsr_usumodi() {
    return usr_usumodi;
  }

  public void setUsr_usumodi(String usr_usumodi) {
    this.usr_usumodi = usr_usumodi;
  }

  public String getUsr_modmodi() {
    return usr_modmodi;
  }

  public void setUsr_modmodi(String usr_modmodi) {
    this.usr_modmodi = usr_modmodi;
  }

  @Override
  public String toString() {
    return "Usuario{" + "usr_id=" + usr_id + ", usr_alias=" + usr_alias + ", per_id=" 
            + per_id + ", usr_tipo=" + usr_tipo + ", usr_estado=" + usr_estado + '}';
  }

}
