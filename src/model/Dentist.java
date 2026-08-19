/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Pc
 */

public class Dentist {
    private int dentistId;
    private String name;
    private String email;
    private String phone;
    private String specialization;

    public int getDentistId() 
    {
        return dentistId; 
    }
    
    public void setDentistId(int dentistId) 
    {
        this.dentistId = dentistId; 
    }

    public String getName() 
    {
        return name; 
    }
    public void setName(String name) 
    {
        this.name = name; 
    }

    public String getEmail() 
    
    {
        return email;
    }
    public void setEmail(String email) 
    {
        this.email = email; 
    }

    public String getPhone() 
    {
        return phone; 
    }
    
    public void setPhone(String phone) 
    {
        this.phone = phone; 
    }

    public String getSpecialization() 
    {
        return specialization; 
    }
    
    public void setSpecialization(String specialization) 
    {
        this.specialization = specialization; 
    }

    @Override
    public String toString() {
        return name;
    }
}
