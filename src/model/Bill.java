/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Pc
 */

public class Bill {
    private int billId;
    private String appointmentNo;
    private double consultationFee;
    private double treatmentFee;
    private double discount;
    private double total;
    private String billDate;

    public int getBillId() 
    { 
        return billId; 
    }
    
    public void setBillId(int billId) 
    {
        this.billId = billId; 
    }

    public String getAppointmentNo() 
    {
        return appointmentNo; 
    }
    
    public void setAppointmentNo(String appointmentNo) 
    {
        this.appointmentNo = appointmentNo; 
    }

    public double getConsultationFee() 
    {
        return consultationFee; 
    }
    
    public void setConsultationFee(double consultationFee) 
    {
        this.consultationFee = consultationFee; 
    }

    public double getTreatmentFee() 
    {
        return treatmentFee; 
    }
    
    public void setTreatmentFee(double treatmentFee) 
    {
        this.treatmentFee = treatmentFee; 
    }

    public double getDiscount() 
    {
        return discount; 
    }
    
    public void setDiscount(double discount) 
    {
        this.discount = discount; 
    }

    public double getTotal() 
    {
        return total; 
    }
    
    public void setTotal(double total) 
    {
        this.total = total; 
    }

    public String getBillDate() 
    {
        return billDate; 
    }
    
    public void setBillDate(String billDate) 
    {
        this.billDate = billDate; 
    }

    public double calculateTotal() {
        total = consultationFee + treatmentFee - discount;
        return total;
    }
}
