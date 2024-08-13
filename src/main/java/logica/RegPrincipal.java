package logica;

public class RegPrincipal {
  
  private Long idUsuario; 
  private Long idPersona;
  private String aliasUsu;
  private String nombreUsu;
  private String estadoUsu; 
  private String tipoUus;
  private String ultLogonUsu;

  public RegPrincipal() {
  }

  public RegPrincipal(Long idUsuario, Long idPersona, String aliasUsu, String nombreUsu, String estadoUsu, String tipoUus, String ultLogonUsu) {
    this.idUsuario = idUsuario;
    this.idPersona = idPersona;
    this.aliasUsu = aliasUsu;
    this.nombreUsu = nombreUsu;
    this.estadoUsu = estadoUsu;
    this.tipoUus = tipoUus;
    this.ultLogonUsu = ultLogonUsu;
  }

  public Long getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Long idUsuario) {
    this.idUsuario = idUsuario;
  }

  public Long getIdPersona() {
    return idPersona;
  }

  public void setIdPersona(Long idPersona) {
    this.idPersona = idPersona;
  }

  public String getAliasUsu() {
    return aliasUsu;
  }

  public void setAliasUsu(String aliasUsu) {
    this.aliasUsu = aliasUsu;
  }

  public String getNombreUsu() {
    return nombreUsu;
  }

  public void setNombreUsu(String nombreUsu) {
    this.nombreUsu = nombreUsu;
  }

  public String getEstadoUsu() {
    return estadoUsu;
  }

  public void setEstadoUsu(String estadoUsu) {
    this.estadoUsu = estadoUsu;
  }

  public String getTipoUus() {
    return tipoUus;
  }

  public void setTipoUus(String tipoUus) {
    this.tipoUus = tipoUus;
  }

  public String getUltLogonUsu() {
    return ultLogonUsu;
  }

  public void setUltLogonUsu(String ultLogonUsu) {
    this.ultLogonUsu = ultLogonUsu;
  }
  
  
  
}
