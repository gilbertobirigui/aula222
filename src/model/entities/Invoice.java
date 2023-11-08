/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;


public class Invoice {   // fatura
    private Double basicPayment; 
    private Double tax;    // imposto
    
    
    public Invoice(){
        
    }
    
    // contrutor com argumentos

    public Invoice(Double basicPayment, Double tax) {
        this.basicPayment = basicPayment;
        this.tax = tax;
    }

    public Double getBasicPayment() {
        return basicPayment;
    }

    public void setBasicPayment(Double basicPayment) {
        this.basicPayment = basicPayment;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }
    
    
    
    // criar o dado calculado ele representado pelo UML ASSIM 
    //   - /totalPayment
    
    public Double getTotalPayment(){
        // usando get e nao o atributo melhor porque se mudar alto la ta pronto
        return getBasicPayment() + getTax();
        
    }
    
    
    
    
}
