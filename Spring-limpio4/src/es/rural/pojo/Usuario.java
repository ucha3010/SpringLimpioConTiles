package es.rural.pojo;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import es.rural.util.Constants;
import es.rural.util.valid.PersistenceGroup;
import es.rural.util.valid.SpringFormGroup;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue
	private int idUsr;
	
	@NotEmpty(message=Constants.NOT_EMPTY,groups= {PersistenceGroup.class,SpringFormGroup.class})
	@Size(min=3, message=Constants.SIZE,groups= {SpringFormGroup.class})
	private String usuario;

	//@NotEmpty(message=Constants.NOT_EMPTY,groups= {PersistenceGroup.class,SpringFormGroup.class})
	//al ser la clave encriptada supera los 15 caracteres al guardarse con lo cual necesito usar lo de los groups
	//@Size(min=3, max=15, message=Constants.SIZE,groups= {SpringFormGroup.class})
	private String clave;

	@NotEmpty(message=Constants.NOT_EMPTY,groups= {PersistenceGroup.class,SpringFormGroup.class})
	private String permiso;
	
	private boolean habilitado;
	
	private Timestamp fechaCreacion;
	
	public int getIdUsr() {
		return idUsr;
	}
	public void setIdUsr(int idUsr) {
		this.idUsr = idUsr;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getPermiso() {
		return permiso;
	}
	public void setPermiso(String permiso) {
		this.permiso = permiso;
	}
	public boolean isHabilitado() {
		return habilitado;
	}
	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	@Override
	public String toString() {
		return "Usuarios [idUsr=" + idUsr + ", usuario=" + usuario + ", clave=" + clave + ", permiso=" + permiso
				+ ", habilitado=" + habilitado + ", fechaCreacion=" + fechaCreacion + "]";
	}
	
	

}
