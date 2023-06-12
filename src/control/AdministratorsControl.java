/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;
import dao.AdministratorsDAO;
import dao.EmployeesDAO;
import model.Administrators;
import table.TableAdministrators;
import java.util.List;
/**
 * @author 
 * Made Riksi Purnama Sadnya Agung / 210711396
 * Pemrograman Berorientasi Obyek C
 */
public class AdministratorsControl {
    private AdministratorsDAO adminDao = new AdministratorsDAO();
    
    public TableAdministrators showAdministrator(String query){
        List<Administrators> listAdmin = adminDao.showListAdministrator();
        TableAdministrators tabelAdministrator = new TableAdministrators(listAdmin);
        return tabelAdministrator;
    }
    public void insertAdministrator(Administrators admin){
        adminDao.insertAdministrator(admin);
    }
    public void updateAdministrator(Administrators admin){
        adminDao.updateAdministrator(admin);
    }
    public void deleteAdministrator(int id){
        adminDao.deleteAdministrator(id);
    }
    public Administrators searchAdministrators(Administrators admin){
        if(adminDao.searchAdmin(admin)!=null) return adminDao.searchAdmin(admin);
        return null;
    }
    public Administrators searchByUsername(String user){
        adminDao.searchByUsername(user);
        return null;
    }
    
    public int countAdmin(){
        return showAdministrator("").getRowCount();
    }
    public int autoGenerateID(){
        List<Administrators> listAdmin = adminDao.showListAdministrator();
        return listAdmin.get(listAdmin.size()-1).getAdministrator_id()+1;
    }
}
