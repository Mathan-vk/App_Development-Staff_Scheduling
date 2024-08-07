package com.example.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.model.StaffScheduling;
import com.example.project.repository.StaffRepo;


@Service
public class StaffSchedulingService{
    @Autowired
    private StaffRepo pr;
    public StaffScheduling createPatient(StaffScheduling p){
        return pr.save(p);
    }

    public List<StaffScheduling> getAllPatients(){
        return pr.findAll();
    }
    public Optional<StaffScheduling> getPatientById(Integer StaffId){
        return pr.findById(StaffId);
    }
    public boolean updateDetails(int StaffId,StaffScheduling l)
    {
        if(this.getPatientById(StaffId)==null)
        {
            return false;
        }
        try{
            pr.save(l);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
public boolean deleteStudent(int StaffId)
    {
        if(this.getPatientById(StaffId) == null)
        {
            return false;
        }
        pr.deleteById(StaffId);
        return true;
    }
public List<StaffScheduling> getall() 
{
    return pr.getall();
}

}