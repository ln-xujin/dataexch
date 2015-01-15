package ln.xujin.dataexch.model;

import java.util.List;

public class DownOrder {
	
	private String companyCode;

	private String erpOrder;
	
	private String carrierCode;
	
	private String carrierName;
	
	private List<DownCarrierService> carrierServices;
	
	private List<DownOrderDetail> orderDetails;

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getErpOrder() {
		return erpOrder;
	}

	public void setErpOrder(String erpOrder) {
		this.erpOrder = erpOrder;
	}

	public String getCarrierCode() {
		return carrierCode;
	}

	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public List<DownCarrierService> getCarrierServices() {
		return carrierServices;
	}

	public void setCarrierServices(List<DownCarrierService> carrierServices) {
		this.carrierServices = carrierServices;
	}

	public List<DownOrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<DownOrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

}