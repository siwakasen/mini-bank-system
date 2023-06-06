<<<<<<< HEAD
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

/**
 *
 * @author USER
 * Fathur Rosi 210711562
 */
=======
package model;

>>>>>>> devPanji
public class Administrator {
    private int administrator_id;
    private String username,password;

    public Administrator(int administrator_id, String username, String password) {
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
