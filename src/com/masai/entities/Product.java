package com.masai.entities;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {
	
	private double unit;
	private double price=10;
	public Product() {
		super();
	}
	public Product(double unit) {
		super();
		this.unit=unit;
	}
	public double getUnit() {
		return unit;
	}
	public void setUnit(double unit) {
		this.unit = unit;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [unit=" + unit + ", price=" + price + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(price, unit);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Double.doubleToLongBits(unit) == Double.doubleToLongBits(other.unit);
	}
	
	

}
