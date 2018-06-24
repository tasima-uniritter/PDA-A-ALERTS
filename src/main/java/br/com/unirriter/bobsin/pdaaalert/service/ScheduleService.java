package br.com.unirriter.bobsin.pdaaalert.service;

import br.com.unirriter.bobsin.pdaaalert.domain.Schedule;
import br.com.unirriter.bobsin.pdaaalert.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    public void create(Schedule schedule) {
        scheduleRepository.save(schedule);
    }

    public List<Schedule> listAll() {
        return scheduleRepository.findAll();
    }

    public void delete(Long id) {
        scheduleRepository.deleteById(id);
    }

}