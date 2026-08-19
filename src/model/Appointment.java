/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Pc
 */

public class Appointment {
    private String appointmentNo;
    private int patientId;
    private String patientName;
    private String address;
    private String contactNo;
    private int dentistId;
    private String dentistName;
    private int treatmentTypeId;
    private String treatmentType;
    private double treatmentFee;
    private String appointmentDate;
    private String appointmentTime;
    private String status;
    private int createdBy;

    public String getAppointmentNo() { 
        return appointmentNo; 
    }
    public void setAppointmentNo(String appointmentNo) 
        {
            this.appointmentNo = appointmentNo; 
        }

    public int getPatientId() 
    {
        return patientId; 
    }
    public void setPatientId(int patientId) 
    {
        this.patientId = patientId; 
    }

    public String getPatientName() 
    {
        return patientName; 
    }
    
    public void setPatientName(String patientName) 
    { 
        this.patientName = patientName; 
    }

    public String getAddress()
    {
        return address; 
    }
    
    public void setAddress(String address) 
    {
        this.address = address; 
    }

    public String getContactNo() 
    {
        return contactNo; 
    }
    
    public void setContactNo(String contactNo) 
    {
        this.contactNo = contactNo; 
    }

    public int getDentistId() 
    {
        return dentistId; 
    }
    
    public void setDentistId(int dentistId) 
    {
        this.dentistId = dentistId; 
    }
    
    public String getDentistName() 
    {
        return dentistName; 
    }
    
    public void setDentistName(String dentistName) 
    {
        this.dentistName = dentistName; 
    }

    public int getTreatmentTypeId() 
    {
        return treatmentTypeId; 
    }
    
    public void setTreatmentTypeId(int treatmentTypeId) 
    {
        this.treatmentTypeId = treatmentTypeId; 
    }

    public String getTreatmentType() 
    {
        return treatmentType; 
    }
    
    public void setTreatmentType(String treatmentType) 
    {
        this.treatmentType = treatmentType; 
    }

    public double getTreatmentFee() 
    {
        return treatmentFee; 
    }
    
    public void setTreatmentFee(double treatmentFee) 
    {
        this.treatmentFee = treatmentFee; 
    }

    public String getAppointmentDate() 
    {
        return appointmentDate; 
    }
    
    public void setAppointmentDate(String appointmentDate) 
    {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() 
    {
        return appointmentTime; 
    }
    
    public void setAppointmentTime(String appointmentTime) 
    {
        this.appointmentTime = appointmentTime;
    }

    public String getStatus() 
    {
        return status; 
    }
    
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public int getCreatedBy() 
    {
        return createdBy; 
    }
    
    public void setCreatedBy(int createdBy) 
    {
        this.createdBy = createdBy; 
    }
}
