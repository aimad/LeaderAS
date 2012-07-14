/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Reservation;
import java.util.List;
/**
 *
 * @author ELKAOUMI
 */
public interface ReservationDao {
     public List getAllReservation();

    public Reservation getReservation(String id);

    public void update(Reservation reservation);

    public void insert(Reservation reservation);

    public void delete(String id);
}
