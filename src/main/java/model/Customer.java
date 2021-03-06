package model;

public class Customer {

    private String name;
    private String address;

    public Customer() {
    }

    public Customer(String name, String address) {
        this.setName(name);
        this.setAddress(address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean equals(Customer c) {
        return (c.getName().equals(this.name) && c.getAddress().equals(this.address));
    }
}
