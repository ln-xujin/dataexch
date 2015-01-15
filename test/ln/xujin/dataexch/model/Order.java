package ln.xujin.dataexch.model;

import java.util.List;

public class Order extends RequestObject {

	private String erpOrder;
	
	private Carrier carrier;
	
	private List<OrderDetail> orderDetails;

	public String getErpOrder() {
		return erpOrder;
	}

	public void setErpOrder(String erpOrder) {
		this.erpOrder = erpOrder;
	}

	public Carrier getCarrier() {
		return carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
}
