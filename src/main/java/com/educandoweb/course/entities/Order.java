package com.educandoweb.course.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable { //order == pedido

    private static final long serialversionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;//antes usavámos Date , mais depois do java 8 começou a se usar mair a classe Instant

    @ManyToOne
    @JoinColumn(name = "client_id")//nome da chave estrangeira que vai ter no BD
    private User client;

    public Order() {
    }

    public Order(Long id, Instant moment, User client) {
        this.id = id;
        this.moment = moment;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id.equals(order.id) && Objects.equals(moment, order.moment) && Objects.equals(client, order.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, moment, client);
    }
}
