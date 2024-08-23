package com.example.demo2.DTO;

import com.example.demo2.entity.AdressEntity;
import com.example.demo2.entity.Department;
import com.example.demo2.entity.EmployeeRole;
import com.example.demo2.entity.MissionEntity;

import java.time.LocalDate;
import java.util.List;

public class EmployeeDTO {
    private int id;
    private int identifer;
    private String firtname;
    private String lastname;
    private String email;
    private LocalDate date;
    private EmployeeRole role;
    private AdressEntity adressEntityList;
    private Department department;
    private List<MissionEntity> missions;
    public EmployeeDTO(){
    }
    public EmployeeDTO(int id,int identifer, String firtname, String lastname, String email, LocalDate date, EmployeeRole role) {
        this.id = id;
        this.identifer = identifer;
        this.firtname = firtname;
        this.lastname = lastname;
        this.email = email;
        this.date = date;
        this.role = role;
    }

    public AdressEntity getAdressEntityList() {
        return adressEntityList;
    }

    public void setAdressEntityList(AdressEntity adressEntityList) {
        this.adressEntityList = adressEntityList;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public EmployeeRole getRole() {
        return role;
    }

    public void setRole(EmployeeRole role) {
        this.role = role;
    }

    public List<MissionEntity> getMissions() {
        return missions;
    }

    public void setMissions(List<MissionEntity> missions) {
        this.missions = missions;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getIndentifer() {
        return identifer;
    }

    public void setIndentifer(int identifer) {
        this.identifer = identifer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirtname() {
        return firtname;
    }

    public void setFirtname(String firtname) {
        this.firtname = firtname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
