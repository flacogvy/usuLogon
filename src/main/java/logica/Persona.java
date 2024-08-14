package logica;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="PERSONA")
public class Persona implements Serializable {
  
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="PER_ID")
  private Long per_id;
  
	@Column(name="PER_TIPDOC")
  private String per_tipdoc;
	@Column(name="PER_NUMCOD")
  private String per_numcod;
	@Column(name="PER_NOMBRE")
  private String per_nombre;
	@Column(name="PER_PATERNO")
  private String per_paterno;
	@Column(name="PER_MATERNO")
  private String per_materno;
	@Column(name="PER_FECHNAC")
  private String per_fechnac;
	@Column(name="PER_CELULAR")
  private String per_celular;
	@Column(name="PER_ESTADO")
  private String per_estado;
	@Column(name="PER_SEXO")
  private String per_sexo;
	@Column(name="PER_FEHOCREA")
  private String per_fehocrea;
	@Column(name="PER_USUCREA")
  private String per_usucrea;
	@Column(name="PER_MODCREA")
  private String per_modcrea;
	@Column(name="PER_FEHOMODI")
  private String per_fehomodi;
	@Column(name="PER_USUMODI")
  private String per_usumodi;
	@Column(name="PER_MODMODI")
  private String per_modmodi;

  public Persona() {
  }

  public Persona(Long per_id, String per_tipdoc, String per_numcod, String per_nombre, 
          String per_paterno, String per_materno, String per_fechnac, String per_celular, 
          String per_estado, String per_sexo, String per_fehocrea, String per_usucrea, 
          String per_modcrea, String per_fehomodi, String per_usumodi, 
          String per_modmodi) {
    this.per_id = per_id;
    this.per_tipdoc = per_tipdoc.toUpperCase();
    this.per_numcod = per_numcod;
    this.per_nombre = per_nombre.toUpperCase();
    this.per_paterno = per_paterno.toUpperCase();
    this.per_materno = per_materno.toUpperCase();
    this.per_fechnac = per_fechnac;
    this.per_celular = per_celular;
    this.per_estado = per_estado.toUpperCase();
    this.per_sexo = per_sexo.toUpperCase();
    this.per_fehocrea = per_fehocrea;
    this.per_usucrea = per_usucrea;
    this.per_modcrea = per_modcrea;
    this.per_fehomodi = per_fehomodi;
    this.per_usumodi = per_usumodi;
    this.per_modmodi = per_modmodi;
  }

  public Long getPer_id() {
    return per_id;
  }

  public void setPer_id(Long per_id) {
    this.per_id = per_id;
  }

  public String getPer_tipdoc() {
    return per_tipdoc;
  }

  public void setPer_tipdoc(String per_tipdoc) {
    this.per_tipdoc = per_tipdoc.toUpperCase();
  }

  public String getPer_numcod() {
    return per_numcod;
  }

  public void setPer_numcod(String per_numcod) {
    this.per_numcod = per_numcod;
  }

  public String getPer_nombre() {
    return per_nombre;
  }

  public void setPer_nombre(String per_nombre) {
    this.per_nombre = per_nombre.toUpperCase();
  }

  public String getPer_paterno() {
    return per_paterno;
  }

  public void setPer_paterno(String per_paterno) {
    this.per_paterno = per_paterno.toUpperCase();
  }

  public String getPer_materno() {
    return per_materno;
  }

  public void setPer_materno(String per_materno) {
    this.per_materno = per_materno.toUpperCase();
  }

  public String getPer_fechnac() {
    return per_fechnac;
  }

  public void setPer_fechnac(String per_fechnac) {
    this.per_fechnac = per_fechnac;
  }

  public String getPer_celular() {
    return per_celular;
  }

  public void setPer_celular(String per_celular) {
    this.per_celular = per_celular;
  }

  public String getPer_estado() {
    return per_estado;
  }

  public void setPer_estado(String per_estado) {
    this.per_estado = per_estado.toUpperCase();
  }

  public String getPer_sexo() {
    return per_sexo;
  }

  public void setPer_sexo(String per_sexo) {
    this.per_sexo = per_sexo.toUpperCase();
  }

  public String getPer_fehocrea() {
    return per_fehocrea;
  }

  public void setPer_fehocrea(String per_fehocrea) {
    this.per_fehocrea = per_fehocrea;
  }

  public String getPer_usucrea() {
    return per_usucrea;
  }

  public void setPer_usucrea(String per_usucrea) {
    this.per_usucrea = per_usucrea;
  }

  public String getPer_modcrea() {
    return per_modcrea;
  }

  public void setPer_modcrea(String per_modcrea) {
    this.per_modcrea = per_modcrea;
  }

  public String getPer_fehomodi() {
    return per_fehomodi;
  }

  public void setPer_fehomodi(String per_fehomodi) {
    this.per_fehomodi = per_fehomodi;
  }

  public String getPer_usumodi() {
    return per_usumodi;
  }

  public void setPer_usumodi(String per_usumodi) {
    this.per_usumodi = per_usumodi;
  }

  public String getPer_modmodi() {
    return per_modmodi;
  }

  public void setPer_modmodi(String per_modmodi) {
    this.per_modmodi = per_modmodi;
  }

  @Override
  public String toString() {
    return "Persona: {" + "per_id=" + per_id + ", per_tipdoc=" + per_tipdoc 
            + ", per_numcod=" + per_numcod + ", per_nombre=" + per_nombre 
            + ", per_paterno=" + per_paterno + ", per_materno=" + per_materno + '}';
  }
  
}
