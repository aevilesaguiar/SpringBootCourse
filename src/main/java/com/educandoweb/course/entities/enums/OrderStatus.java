package com.educandoweb.course.entities.enums;

public enum OrderStatus {

    WAITING_PAYMENT(1),
        PAID(2),
    SHIPED(3),
    DELIVERED(4),
    CANCELED(5);

    //criar um código do tipo enumerado
    private int code;

    //construtor do tipo Enumerado é private

    private OrderStatus(int code){
        this.code = code;
    }

    //para que o private int code ficar acessivel ao mundo exterior eu crio um método publico para acessar esse código.
    public int getCode(){
        return code;
    }

    //método estatico para converter um valor numérico para um tipo enumerado
    public static OrderStatus valueOf(int code){

        for (OrderStatus value:OrderStatus.values()
             ) {
                if(value.getCode()== code){
                    return value;
                }
        }
        throw new IllegalArgumentException("Inválid OrderStatus Code");
    }


}
