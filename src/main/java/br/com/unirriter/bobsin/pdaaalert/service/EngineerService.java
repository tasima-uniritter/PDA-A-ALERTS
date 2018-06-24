package br.com.unirriter.bobsin.pdaaalert.service;

import br.com.unirriter.bobsin.pdaaalert.domain.Engineer;
import br.com.unirriter.bobsin.pdaaalert.repository.EngineerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class EngineerService {
    @Autowired
    private EngineerRepository engineerRepository;

    public void create(Engineer engineer) {
        engineerRepository.save(engineer);
    }

    public List<Engineer> listAll() {
        return engineerRepository.findAll();
    }

    public Engineer findByName(String name) {
        return engineerRepository.findByName(name);
    }

    public void delete(Long id) {
        engineerRepository.deleteById(id);
    }

}