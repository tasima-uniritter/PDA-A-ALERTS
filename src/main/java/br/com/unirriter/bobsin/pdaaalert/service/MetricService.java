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

    public Metric save(Metric metric) {
        return this.metricRepository.save(metric);
    }

    public void delete(Long metricId) {
        metricRepository.deleteById(metricId);
    }

    public List<Metric> listAll() {
        return metricRepository.findAll();
    }

    public Metric findByMetricId(Long metricId) {
        return metricRepository.findByMetricId(metricId);
    }

    public Metric findByMetricName(String metricName) {
        return metricRepository.findByMetricName(metricName);
    }
}