package logica;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CODTABLA")
public class CodTabla implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "CTA_ID")
  private Long ctaId;
  @Column(name = "CTA_CODIGO")
  private String ctaCodigo;
  @Column(name = "CTA_OPCION")
  private String ctaOpcion;
  @Column(name = "CTA_DESCRIPCION")
  private String ctaDescripcion;
  @Column(name = "CTA_ORDEN")
  private String ctaOrden;

  public CodTabla() {
  }

  public CodTabla(Long ctaId, String ctaCodigo, String ctaOpcion, String ctaDescripcion,
          String ctaOrden) {
    this.ctaId = ctaId;
    this.ctaCodigo = ctaCodigo;
    this.ctaOpcion = ctaOpcion;
    this.ctaDescripcion = ctaDescripcion;
    this.ctaOrden = ctaOrden;
  }

  public Long getCtaId() {
    return ctaId;
  }

  public void setCtaId(Long ctaId) {
    this.ctaId = ctaId;
  }

  public String getCtaCodigo() {
    return ctaCodigo;
  }

  public void setCtaCodigo(String ctaCodigo) {
    this.ctaCodigo = ctaCodigo;
  }

  public String getCtaOpcion() {
    return ctaOpcion;
  }

  public void setCtaOpcion(String ctaOpcion) {
    this.ctaOpcion = ctaOpcion;
  }

  public String getCtaDescripcion() {
    return ctaDescripcion;
  }

  public void setCtaDescripcion(String ctaDescripcion) {
    this.ctaDescripcion = ctaDescripcion;
  }

  public String getCtaOrden() {
    return ctaOrden;
  }

  public void setCtaOrden(String ctaOrden) {
    this.ctaOrden = ctaOrden;
  }

}
