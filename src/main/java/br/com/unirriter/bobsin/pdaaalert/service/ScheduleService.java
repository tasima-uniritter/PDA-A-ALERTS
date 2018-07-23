package br.com.unirriter.bobsin.pdaaalert.service;

import br.com.unirriter.bobsin.pdaaalert.domain.Schedule;
import br.com.unirriter.bobsin.pdaaalert.domain.Team;
import br.com.unirriter.bobsin.pdaaalert.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    public void save(Schedule schedule) {
        scheduleRepository.save(schedule);
    }

    public void delete(Long scheduleId) {
        scheduleRepository.deleteById(scheduleId);
    }

    public List<Schedule> listAll() {
        return scheduleRepository.findAll();
    }

    public Schedule findByScheduleId(Long scheduleId) throws EntityNotFoundException {
        return this.scheduleRepository.getOne(scheduleId);
    }
}