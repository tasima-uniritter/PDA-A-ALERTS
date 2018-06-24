package br.com.unirriter.bobsin.pdaaalert.service;

import br.com.unirriter.bobsin.pdaaalert.domain.Metric;
import br.com.unirriter.bobsin.pdaaalert.repository.MetricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class MetricService {
    @Autowired
    private MetricRepository metricRepository;

    public void create(Metric metric) {
        metricRepository.save(metric);
    }

    public List<Metric> listAll() {
        return metricRepository.findAll();
    }

    public Metric findById(Long id) {
        return metricRepository.findByCode(id);
    }

    public Metric findByName(String name) {
        return metricRepository.findByName(name);
    }

    public void delete(Long id) {
        metricRepository.deleteById(id);
    }

}