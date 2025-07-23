
package com.mycompany.exceptionsjava;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.DomainException;
import model.entities.Reservation;


public class ExceptionsJava {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");    
        
        try{
            System.out.println("Room number: ");
            int number = sc.nextInt();
            System.out.println("Check-in date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.println("Check-Out date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());


            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println("");
            System.out.println("Enter data to update the reservation: ");
            System.out.println("Check-in date (dd/MM/yyyy): ");
            sdf.parse(sc.next());
            System.out.println("Check-Out date (dd/MM/yyyy): ");
            sdf.parse(sc.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);     
        }
        catch(ParseException e){
            System.out.println("Data Invalida");
        }
        catch(DomainException e){
            System.out.println("Erro na reserva" + e.getMessage());
        }
        catch(RuntimeException e){
            System.out.println("Unexpected error");
        }

        sc.close();
    }
}
