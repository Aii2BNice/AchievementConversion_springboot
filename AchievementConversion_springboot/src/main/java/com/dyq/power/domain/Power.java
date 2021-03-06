package com.dyq.power.domain;

public class Power {
	
	private Integer powerId;
	private String powerName;
	public Power() {
		super();
	}
	public Power(Integer powerId, String powerName) {
		super();
		this.powerId = powerId;
		this.powerName = powerName;
	}
	public Integer getPowerId() {
		return powerId;
	}
	public void setPowerId(Integer powerId) {
		this.powerId = powerId;
	}
	public String getPowerName() {
		return powerName;
	}
	public void setPowerName(String powerName) {
		this.powerName = powerName;
	}
	@Override
	public String toString() {
		return "Power [powerId=" + powerId + ", powerName=" + powerName + "]";
	}
	
}
