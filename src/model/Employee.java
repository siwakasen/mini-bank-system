package model;

public abstract class Employee {
    protected int employee_id;
    protected String first_name;
    protected String last_name;
    protected String username;
    protected String password;
    protected String start_work_date;
    protected String end_work_date;
    protected Role role_id;

    public Employee(int employee_id, String first_name, String last_name, String username, String password, String start_work_date, String end_work_date, Role role_id) {
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.password = password;
        this.start_work_date = start_work_date;
        this.end_work_date = end_work_date;
        this.role_id = role_id;
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

    public Role getRole_id() {
        return role_id;
    }

    public void setRole_id(Role role_id) {
        this.role_id = role_id;
    }
}
