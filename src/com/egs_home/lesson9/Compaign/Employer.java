package com.egs_home.lesson9.Compaign;

public class Employer {

        String firstName;
        String lastName;
        int positonNumber;
        Double salary;


        public Employer(String firstName, String lastName,int positonNumber, Double salary) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.positonNumber = positonNumber;
            this.salary = salary;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getpositonNumber() {
            return positonNumber;
        }

        public void setPositon(String positon) {
            this.positonNumber = positonNumber;
        }

        public Double getSalary() {
            return salary;
        }

        public void setSalary(Double salary) {
            this.salary = salary;
        }

}
