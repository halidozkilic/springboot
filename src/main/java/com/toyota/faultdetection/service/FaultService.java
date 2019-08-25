package com.toyota.faultdetection.service;

import com.toyota.faultdetection.dao.FaultRepository;
import com.toyota.faultdetection.domain.Fault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaultService {

  // private final FaultRepository faultRepository;

   // public FaultService(FaultRepository faultRepository) {this.faultRepository = faultRepository;}

    @Autowired
    private  FaultRepository faultRepository;


    public List<Fault> getAll() {
        return faultRepository.findAll();
    }


    public Fault save(Fault fault) { return faultRepository.save(fault);
    }


    public void delete(Long faultId) {
        faultRepository.deleteById(faultId);
    }
}