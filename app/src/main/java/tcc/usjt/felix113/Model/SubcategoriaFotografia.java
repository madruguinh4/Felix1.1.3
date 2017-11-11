package tcc.usjt.felix113.Model;

public class SubcategoriaFotografia {
	

	private Long id;
	

	private Long idProfissional;

	private String corporativos;

	private String infantis;

	private String casamento;
	

	private String batizado;
	

	private String aniversario;
	

	private Integer mediaProfisional;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdProfissional() {
		return idProfissional;
	}

	public void setIdProfissional(Long idProfissional) {
		this.idProfissional = idProfissional;
	}
	
	public String getCorporativos() {
		return corporativos;
	}

	public void setCorporativos(String corporativos) {
		this.corporativos = corporativos;
	}

	public String getInfantis() {
		return infantis;
	}

	public void setInfantis(String infantis) {
		this.infantis = infantis;
	}

	public String getCasamento() {
		return casamento;
	}

	public void setCasamento(String casamento) {
		this.casamento = casamento;
	}

	public String getBatizado() {
		return batizado;
	}

	public void setBatizado(String batizado) {
		this.batizado = batizado;
	}

	public String getAniversario() {
		return aniversario;
	}

	public void setAniversario(String aniversario) {
		this.aniversario = aniversario;
	}

	public Integer getMediaProfisional() {
		return mediaProfisional;
	}

	public void setMediaProfisional(Integer mediaProfisional) {
		this.mediaProfisional = mediaProfisional;
	}

}
