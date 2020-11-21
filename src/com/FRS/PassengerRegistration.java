package com.FRS;

public class PassengerRegistration {

    private static int idCounter;
    private int id;
    private float credit;

    private static class Address {
        String street, city, state;

        public Address(String street, String city, String state) {
            this.street = street;
            this.city = city;
            this.state = state;
        }

    }
    private final Address address;

    private static class Contact {
        String name, phone, email;

        public Contact(String name, String phone, String email) {
            this.name = name;
            this.phone = phone;
            this.email = email;
        }

    }
    private final Contact contact;

    public PassengerRegistration(String addressStreet, String addressCity, String addressState,
                                 String contactName, String contactPhone, String contactEmail, float creditMoney){

        this.id = idCounter++;
        this.address = new Address(addressStreet, addressCity, addressState);
        this.contact = new Contact(contactName, contactPhone, contactEmail);
        this.credit = creditMoney;
        System.out.println("Thank you for registering...");
    }

    public int getPassengerCount(){
        return idCounter;
    }

    public String getAddressDetails() {
        return address.street + ", " + address.city + ", " + address.state;
    }

    public String getContactDetails() {
        return contact.name + ", " + contact.phone + ", " + contact.email;
    }

    public void setCredit(float updatedCredit){
        this.credit = updatedCredit;
    }

    public void addCredit(float updatedCredit){
        this.credit = this.credit + updatedCredit;
    }

    public float checkDue(){

        return (float)Math.floor((this.credit * 100) / 100);
    }

}
