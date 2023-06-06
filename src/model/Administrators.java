package model;

public class Administrators{
    private int administrator_id;
    private String username,password;

    public Administrators(int administrator_id, String username, String password) {
        this.administrator_id = administrator_id;
        this.username = username;
        this.password = password;
    }

    public int getAdministrator_id() {
        return administrator_id;
    }

    public void setAdministrator_id(int administrator_id) {
        this.administrator_id = administrator_id;
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
}
