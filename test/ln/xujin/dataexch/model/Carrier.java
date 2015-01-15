package ln.xujin.dataexch.model;

import java.util.List;

public class Carrier {

	private String code;
	
	private String name;
	
	private List<CarrierService> carrierServices;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CarrierService> getCarrierServices() {
		return carrierServices;
	}

	public void setCarrierServices(List<CarrierService> carrierServices) {
		this.carrierServices = carrierServices;
	}
	
}
