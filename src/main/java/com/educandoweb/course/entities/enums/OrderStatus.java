package com.educandoweb.course.entities.enums;

public enum OrderStatus {
    // Definição dos valores da enumeração com seus códigos associados
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    // Atributo privado para armazenar o código associado a cada valor da enumeração
    private int enumCode;

    // Construtor privado para inicializar o código da enumeração
    private OrderStatus(int enumCode){
        this.enumCode = enumCode;
    }

    // Método público para obter o código da enumeração
    public int getEnumCode(){
        return enumCode;
    }

    // Método estático para obter a enumeração com base no código fornecido
    public static OrderStatus valueOf(int enumCode) {
        // Percorre todos os valores da enumeração
        for(OrderStatus value : OrderStatus.values()){
            // Se encontrar um valor com o código correspondente, retorna esse valor
            if(value.getEnumCode() == enumCode)
                return value;
        }
        // Se nenhum valor com o código correspondente for encontrado, lança uma exceção
        throw new IllegalArgumentException("Invalid OrderStatus enumCode");
    }
}
