

package model;

public class Customers {
    private int customer_id;
    private String first_name;
    private String last_name;
    private String email;
    private String username;
    private String password;
    private String phone_number;
    private String address;

    public Customers(int customer_id, String first_name, String last_name, String email, String username, String password, String phone_number, String address) {
        this.customer_id = customer_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.phone_number = phone_number;
        this.address = address;
    }
    public Customers(String first_name, String last_name, String email, String username, String password, String phone_number, String address) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.phone_number = phone_number;
        this.address = address;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
