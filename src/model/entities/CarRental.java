/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import java.time.LocalDateTime;

/**
 *
 * @author Ilha Edição
 */


// Classe CarRental
public class CarRental {
    
    private LocalDateTime start;
    private LocalDateTime fisish;
    
    
    // fazer associacao CarRental com Invoice
    private Vehicle vehicle;
    private Invoice invoice;
    
    
    // construtor padrao
    public CarRental(){
    }

    public CarRental(LocalDateTime start, LocalDateTime fisish, Vehicle vehicle) {
        this.start = start;
        this.fisish = fisish;
        this.vehicle = vehicle;
     
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getFisish() {
        return fisish;
    }

    public void setFisish(LocalDateTime fisish) {
        this.fisish = fisish;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
    
    
    
    
    
    
}
