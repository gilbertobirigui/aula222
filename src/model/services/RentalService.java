/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.services;

import java.time.Duration;
import model.entities.CarRental;
import model.entities.Invoice;

/**
 *
 * @author Ilha Edição
 */
public class RentalService {
    
    private Double pricePerHour;
    private Double pricePerDay;
    
    private BrasilTaxService taxService;
    
    // nao vou fazer o contrutor sem argmento para obrigar cara digitar

    public RentalService(Double pricePerHour, Double pricePerDay, BrasilTaxService taxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = taxService;
    }
    
    
    
    public void processInvoice(CarRental carRental){
        // between encontra duracao entre duas instancia
        // toMinutes para achar em minutos
        
        double minutes = Duration.between(carRental.getStart(), carRental.getFisish()).toMinutes();
                
        // encontrar duracao em horas em fracao de horas
        double hours = minutes / 60.0;
        
        double basicPayment;   // variavel 
        
        if (hours <= 12.00) {
            basicPayment = pricePerHour * Math.ceil(hours);     // preciso arredondar pra cima ou baixo usa math.ceil -> cima
        } else {
            basicPayment = pricePerDay * Math.ceil(hours / 24.00);     // como pego em hours = horas e transformo em dia so dividir por 24
        }
        
        
        // vamos calcular imposto
        double tax = taxService.tax(basicPayment); // tax = imposto
        
        
        // Invoice = fatura  preparado pra qualquer valor
        carRental.setInvoice(new Invoice(basicPayment, tax));
    }
    
}
