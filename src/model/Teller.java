package model;

public class Teller extends Employee{
    private String stasiun_number;

    public Teller(String stasiun_number, int employee_id, String first_name, String last_name, String username, String password, String start_work_date, String end_work_date, Object role_id) {
        super(employee_id, first_name, last_name, username, password, start_work_date, end_work_date, role_id);
        this.stasiun_number = stasiun_number;
    }

    public String getStasiun_number() {
        return stasiun_number;
    }

    public void setStasiun_number(String stasiun_number) {
        this.stasiun_number = stasiun_number;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
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

    public String getStart_work_date() {
        return start_work_date;
    }

    public void setStart_work_date(String start_work_date) {
        this.start_work_date = start_work_date;
    }

    public String getEnd_work_date() {
        return end_work_date;
    }

    public void setEnd_work_date(String end_work_date) {
        this.end_work_date = end_work_date;
    }

    public Object getRole_id() {
        return role_id;
    }

    public void setRole_id(Object role_id) {
        this.role_id = role_id;
    }
    
}
