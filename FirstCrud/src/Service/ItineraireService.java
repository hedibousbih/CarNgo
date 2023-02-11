/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.itineraire;
import java.util.List;
import java.sql.*;
import BD.MyConnection;
import java.time.Clock;
import java.util.ArrayList;

/**
 *
 * @author mhcab
 */
public class ItineraireService implements InterfaceItineraire{
  
    Connection cnx;

    public ItineraireService() {
        cnx = MyConnection.getInstance().getCnx();
    }

    @Override
    public void ajouterItineraire(itineraire i) {
         try {
            String sql = "insert into itineraire(idUser,idRes,pointDepart,pointDestination,DureéEstime)"
                    + "values (?,?,?,?,?)";
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setInt(1, i.getIdUser());
            ste.setInt(2, i.getIdRes());
            ste.setString(3, i.getPointDepart());
            ste.setString(4, i.getPointDestination());
            ste.setInt(5, i.getDureéEstime());
            ste.executeUpdate();
            System.out.println("********************itineraire ajoutée*******************************");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
    }

    @Override
    public void modifierItineraire(int id,itineraire i) {
    String sql = "update itineraire set pointDepart=?,pointDestination=?,DureéEstime=? where idUser=?";
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setString(1, i.getPointDepart());
            ste.setString(2, i.getPointDestination());
            ste.setInt(3, i.getDureéEstime());
            ste.setInt(4,id);
            ste.executeUpdate();
            System.out.println("********************** MODIFIED ****************************************");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimerItineraire(itineraire i) {

        String sql = "delete from itineraire where idUser=?";
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setInt(1, i.getIdUser());
            ste.executeUpdate();
            System.out.println("*********************** DELETED ************************");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    }

    @Override
    public List<itineraire> afficherItineraire() {

 List<itineraire> itineraires = new ArrayList<>();
        try {
            String sql = "select pointDepart,pointDestination,DureéEstime from itineraire";
            Statement ste = cnx.createStatement();
            ResultSet s = ste.executeQuery(sql);
            while (s.next()) {

                itineraire i = new itineraire(s.getString(1),s.getString(2),s.getInt(3));
                itineraires.add(i);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return itineraires;
    }

    @Override
    public List<itineraire> Selectionparid(int id) {
 List<itineraire> itineraires = new ArrayList<>();
        try {
            String sql = "select pointDepart,pointDestination,DureéEstime from itineraire where id=?";
           PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setInt(4, id);
            ste.executeUpdate();
            ResultSet s = ste.executeQuery(sql);
            while (s.next()) {

                itineraire i = new itineraire(s.getString(1),s.getString(2),s.getInt(3));
                itineraires.add(i);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return itineraires;
    }

}
