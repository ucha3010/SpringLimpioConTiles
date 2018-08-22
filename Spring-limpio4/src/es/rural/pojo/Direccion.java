package es.rural.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Direccion")
public class Direccion {
	
	@Id
	@GeneratedValue
	private int idDir;
	private String calle;
	private String cp;
	
	@ManyToOne
	@JoinColumn(name="idAd")
	private Admin admin;
	
	public Direccion() {
		
	}

	public Direccion(int idDir, String calle, String cp) {
		super();
		this.idDir = idDir;
		this.calle = calle;
		this.cp = cp;
	}

	public int getIdDir() {
		return idDir;
	}

	public void setIdDir(int idDir) {
		this.idDir = idDir;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "Direccion [idDir=" + idDir + ", calle=" + calle + ", cp=" + cp + "]";
	}

	
}
