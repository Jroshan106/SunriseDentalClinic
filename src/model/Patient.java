/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Pc
 */

public class Patient {
    private int patientId;
    private String name;
    private String address;
    private String contactNo;

    public int getPatientId() 
    { 
        return patientId; 
    }
    public void setPatientId(int patientId) 
    {
        this.patientId = patientId;
    }

    public String getName() 
    {
        return name; 
    }
    public void setName(String name) 
    {
        this.name = name; 
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
}
