package modelo;

public class Measure {
	
	
	private String medida;
    private String unidad;
    private Integer id;

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }


	
	public Measure()
	{
		
	}

	public Measure(String medida) {
		super();
		this.medida = medida;
	}

	public String getMedida() {
		return medida;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
