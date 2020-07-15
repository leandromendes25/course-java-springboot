package com.leandroprojeto.entites;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.leandroprojeto.entites.enums.OrderStatus;
@Entity 
@Table(name = "tb_order")
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	
//Para realizar o instant da compra é melhor sempre utlizar Instant
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//mostrado no formato string do formato iso 8601, pattern = definir formato
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",timezone = "GMT")
	private Instant moment;
	//Grava no banco valores númericos, porém para o mundo externo continua sendo orderStatus, permitindo controlar o
	//código dos order
	private Integer orderStatus;
	
	@ManyToOne // Serve para instruir o JPA a construir chave estrangeira
	@JoinColumn(name = "client_id") //nome chave estrangeira
	private User client;
	// É pq o OrderItem já tem os id, e que por sua vez já tem o Id do pedido
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<>();
	//No um para um nós estamos mapeando duas entidades para ter o mesmo id, entoa coloca cascade..
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Payment	payment;
	
	
	public Order() {
	}

	public Order(Long id, Instant moment,OrderStatus orderStatus, User client) {
		super();
		this.id = id;
		this.moment = moment;
		setOrderStatus(orderStatus);
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}
	

	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}
	//recebe orderStatus, guarda internamente em um num inteiro
	public void setOrderStatus(OrderStatus orderStatus) {
		if (orderStatus != null) {
		this.orderStatus = orderStatus.getCode();
		}	
	}
	
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	public Set<OrderItem> getItems(){
		return items;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
