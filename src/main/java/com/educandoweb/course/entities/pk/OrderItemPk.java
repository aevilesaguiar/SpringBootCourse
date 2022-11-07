package com.educandoweb.course.entities.pk;


import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.Product;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable //Classe auxiliar
public class OrderItemPk implements Serializable {

    private static final long serialversionUID=1L;

    @ManyToOne
    @JoinColumn(name = "order_id")//nome da chave estrangeira na tabela do BD relacioal
    private Order order;
    @ManyToOne
    @JoinColumn(name = "product_id")//nome da chave estrangeira na tabela do BD relacioal
    private Product product;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemPk that = (OrderItemPk) o;
        return order.equals(that.order) && product.equals(that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }
}
