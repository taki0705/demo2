package com.example.demo2.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employee_entity")
public class EmployeeEntity {

 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private int id;

 @Column(nullable = false)
 private int indentifer;

 @Column(nullable = false)
 private String firtname;

 @Column(nullable = false)
 private String lastname;

 @Column(nullable = false)
 private String email;

 @Column(nullable = false)
 private LocalDate date;

 @Enumerated(EnumType.STRING)
 @Column
 private EmployeeRole role;

 @OneToOne
 @JoinColumn(name = "address_id")
 private AdressEntity adressEntityList;

 @ManyToOne
 @JoinColumn(name = "department_id")
 private Department department;

 @ManyToMany
 @JoinTable(
         name = "employee_mission",
         joinColumns = @JoinColumn(name = "employee_id"),
         inverseJoinColumns = @JoinColumn(name = "mission_id")
 )
 private List<MissionEntity> missions;

 // Default constructor
 public EmployeeEntity() {}

 // Parameterized constructors
 public EmployeeEntity(int id, int indentifer, String firtname, String lastname, String email, LocalDate date, EmployeeRole role) {
  this.id = id;
  this.indentifer = indentifer;
  this.firtname = firtname;
  this.lastname = lastname;
  this.email = email;
  this.date = date;
  this.role = role;
 }
 // Getters and setters
 public int getId() {
  return id;
 }

 public void setId(int id) {
  this.id = id;
 }

 public int getIndentifer() {
  return indentifer;
 }

 public void setIndentifer(int indentifer) {
  this.indentifer = indentifer;
 }

 public String getFirstname() {
  return firtname;
 }

 public void setFirstname(String firstname) {
  this.firtname = firstname;
 }

 public String getLastname() {
  return lastname;
 }

 public void setLastname(String lastname) {
  this.lastname = lastname;
 }

 public String getEmail() {
  return email;
 }

 public void setEmail(String email) {
  this.email = email;
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

 public AdressEntity getAdressEntityList() {
  return adressEntityList;
 }

 public void setAdressEntityList(AdressEntity adressEntityList) {
  this.adressEntityList = adressEntityList;
 }

 public Department getDepartment() {
  return department;
 }

 public void setDepartment(Department department) {
  this.department = department;
 }

 public List<MissionEntity> getMissions() {
  return missions;
 }

 public void setMissions(List<MissionEntity> missions) {
  this.missions = missions;
 }
}
