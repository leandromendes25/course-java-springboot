package com.leandroprojeto.entites.enums;

public enum OrderStatus {
	//Boa praticar numerar para facilitar manutenção
	WAITING_PAYMENT(1),
	PAID(2),
	DELIVERED(3),
	CANCELED(4);
	private int code;
	
	//Construtor do tipo enumerado é especial tem que ser private
	private OrderStatus(int code) {
		this.code = code;
	}
	public int getCode() {
		return code;
	}
	//static = sem precisar instanciar
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid orderStatus code");
	}
}
