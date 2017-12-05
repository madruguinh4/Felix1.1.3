package tcc.usjt.felix113.Model;

public class SubcategoriaCasa {
	

	private Long id;
	

	private Long idProfissional;

	private String eletricista;
	

	private String pintor;
	

	private String diarista;
	

	private String cozinheira;
	

	private String jardineiro;

	private String motorista;
	

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

	public String getEletricista() {
		return eletricista;
	}

	public void setEletricista(String eletricista) {
		this.eletricista = eletricista;
	}

	public String getPintor() {
		return pintor;
	}

	public void setPintor(String pintor) {
		this.pintor = pintor;
	}

	public String getDiarista() {
		return diarista;
	}

	public void setDiarista(String diarista) {
		this.diarista = diarista;
	}

	public String getCozinheira() {
		return cozinheira;
	}

	public void setCozinheira(String cozinheira) {
		this.cozinheira = cozinheira;
	}

	public String getJardineiro() {
		return jardineiro;
	}

	public void setJardineiro(String jardineiro) {
		this.jardineiro = jardineiro;
	}

	public String getMotorista() {
		return motorista;
	}

	public void setMotorista(String motorista) {
		this.motorista = motorista;
	}

	public Integer getMediaProfisional() {
		return mediaProfisional;
	}

	public void setMediaProfisional(Integer mediaProfisional) {
		this.mediaProfisional = mediaProfisional;
	}

	public void set(String campo, String valor){
		if("pintor".equalsIgnoreCase(campo)){
			setPintor(valor);
		}else if("eletricista".equalsIgnoreCase(campo)){
			setEletricista(valor);
		}else if("cozinheira".equalsIgnoreCase(campo)){
			setCozinheira(valor);
		}else if("jardineiro".equalsIgnoreCase(campo)){
			setJardineiro(valor);
		}else if("motorista".equalsIgnoreCase(campo)) {
			setMotorista(valor);
		}else if("diarista".equalsIgnoreCase(campo)) {
			setDiarista(valor);
		}
	}

}
