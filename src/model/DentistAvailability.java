/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Pc
 */

public class DentistAvailability {
    private int availabilityId;
    private int dentistId;
    private String dentistName;
    private String availableDate;
    private String startTime;
    private String endTime;
    private boolean available;

    public int getAvailabilityId() 
    { 
        return availabilityId; 
    }
    public void setAvailabilityId(int availabilityId) 
    {
        this.availabilityId = availabilityId; 
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

    public String getAvailableDate() 
    {
        return availableDate; 
    }
    public void setAvailableDate(String availableDate) 
    {
        this.availableDate = availableDate; 
    }

    public String getStartTime() 
    {
        return startTime; 
    }
    public void setStartTime(String startTime) 
    {
        this.startTime = startTime; 
    }

    
    public String getEndTime() 
    {
        return endTime; 
    
    }
    public void setEndTime(String endTime) 
    {
        this.endTime = endTime; }

    public boolean isAvailable() 
    { 
        return available; }
    
    public void setAvailable(boolean available) 
    {
        this.available = available; 
    }
}
