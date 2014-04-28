package modelo;

public class Indicator {
	
	
	
	private String indicador;

    public Integer getId() {
        return id;
    }

    public Indicator(){

    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer id;

	public Indicator(String indicador) {
		super();
		this.indicador = indicador;
	}

	public String getIndicador() {
		return indicador;
	}

	public void setIndicador(String indicador) {
		this.indicador = indicador;
	}
	
	

}
