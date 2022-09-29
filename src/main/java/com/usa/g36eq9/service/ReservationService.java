package com.usa.g36eq9.service;

import com.usa.g36eq9.model.Reservation;
import com.usa.g36eq9.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    public Optional<Reservation> getReservation(int idReservation){
        return reservationRepository.getReservation(idReservation);
    }
    public Reservation save(Reservation r){
        if(r.getIdReservation() == null){
            return reservationRepository.save(r);
        }else{
            Optional<Reservation> raux = reservationRepository.getReservation(r.getIdReservation());
            if(raux.isPresent()){
                return r;
            }else{
                return reservationRepository.save(r);
            }
        }
    }
    public Reservation update(Reservation r){
        if(r.getIdReservation() != null){
            Optional<Reservation> q = reservationRepository.getReservation(r.getIdReservation());
            if(q.isPresent()){
                if(r.getStarDate() != null){
                    q.get().setStarDate(r.getStarDate());
                }
                if(r.getDevolutionDate() != null){
                    q.get().setDevolutionDate(r.getDevolutionDate());
                }
                reservationRepository.save(q.get());
                return q.get();
            }else{
                return r;
            }
        }else{
            return r;
        }
    }
    public boolean delete(int idReservation){
        boolean flag = false;
        Optional<Reservation> r = reservationRepository.getReservation(idReservation);
        if(r.isPresent()){
            reservationRepository.delete(r.get());
            flag = true;
        }
        return flag;
    }

}
