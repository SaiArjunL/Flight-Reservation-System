package com.FRS;

public class PassengerRegistration {

    private static class Address {
        String street, city, state;

        public Address(String street, String city, String state) {
            this.street = street;
            this.city = city;
            this.state = state;
        }

        public String getStreet(){
            return this.street;
        }

        public void updateStreet(String street){
            this.street = street;
        }

        public String getCity(){
            return this.city;
        }

        public void updateCity(String city){
            this.city = city;
        }

        public String getState(){
            return this.state;
        }

        public void updateState(String state){
            this.state = state;
        }
    }
    private Address address;

    private static class Contact {
        String name, phone, email;

        public Contact(String name, String phone, String email) {
            this.name = name;
            this.phone = phone;
            this.email = email;
        }

        public String getName(){
            return this.name;
        }

        public void updateName(String name){
            this.name = name;
        }

        public String getPhone(){
            return this.phone;
        }

        public void updatePhone(String phone){
            this.phone = phone;
        }

        public String getEmail(){
            return this.email;
        }

        public void updateEmail(String email){
            this.email = email;
        }
    }
    private Contact contact;

    public PassengerRegistration(String addressStreet, String addressCity, String addressState,
                                 String contactName, String contactPhone, String contactEmail){

        this.address = new Address(addressStreet, addressCity, addressState);
        this.contact = new Contact(contactName, contactPhone, contactEmail);
    }

    public String getAddressDetails() {
        return address.street + ", " + address.city + ", " + address.state;
    }

    public String getContactDetails() {
        return contact.name + ", " + contact.phone + ", " + contact.email;
    }

}
