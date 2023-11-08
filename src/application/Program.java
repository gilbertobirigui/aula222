/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;
import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrasilTaxService;
import model.services.RentalService;

/**
 *
 * @author Ilha Edição
 */
public class Program {
    
    public static void main(String[] args){
        
        Locale.setDefault(Locale.US);  // considerar ponto e nao virgula nos decimais
        Scanner sc = new Scanner(System.in);
     
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern ("dd/MM/yyyy HH:mm"); // formatar data e hora
        
        
        System.out.println("Entre como os dados do Aluguel");
        
        System.out.print("Modelo do carro ");
        String carModel = sc.nextLine();  // nextline pra ler tudo q eu digitar ate quebra de linha
        
        System.out.print("Retirada: ");
        LocalDateTime  start = LocalDateTime.parse(sc.nextLine(),fmt);
        
        System.out.print("Retorno: ");
        LocalDateTime  finish = LocalDateTime.parse(sc.nextLine(),fmt);
        
        
        CarRental cr = new CarRental(start, finish, new Vehicle(carModel));
       
     /*   // simulacao somente
        BrasilTaxService taxService = new BrasilTaxService();
        System.out.println(taxService.tax(390.0));
        
        */
        
        System.out.print("Entre como o preço por hora ");
        double pricePerHour = sc.nextDouble();
        
        System.out.print("Entre como o preço por Dia ");
        double pricePerDay = sc.nextDouble();
        
        
        RentalService rentalService  = new RentalService(pricePerHour, pricePerDay, new BrasilTaxService());
     
        rentalService.processInvoice(cr);
        
        System.out.println("FATURA: ");
        System.out.println("Pagamento Basico: " + String.format("%.2f",cr.getInvoice().getBasicPayment()));
        System.out.println("Imposto: " + cr.getInvoice().getTax());
        System.out.println("Pagamento total: " + String.format("%.2f",cr.getInvoice().getTotalPayment()));
         
        
        // tem q transoformat tudo string
        // formata casas decimais %.2f
     
        sc.close();
    }
    
}
