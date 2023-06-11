/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;
import dao.AdministratorsDAO;
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
    public boolean searchAdministrators(Administrators a){
        if(adminDao.searchAdmin(a)) return true;
        return false;
    }
}
