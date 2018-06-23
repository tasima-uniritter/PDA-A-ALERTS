package br.com.unirriter.bobsin.tdaalert.service;

import br.com.unirriter.bobsin.tdaalert.domain.Metric;
import br.com.unirriter.bobsin.tdaalert.repository.MetricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional

public class MetricService {
    @Autowired
    private MetricRepository metricRepository;

    public void cadastrar(Metric metric) {
        metricRepository.save(metric);
    }

    public List<Metric> listarTodos() {
        return metricRepository.findAll();
    }

    public Metric buscarPorId(Long id) {
        return metricRepository.findByCode(id);
    }

    public Metric buscarPorName(Long name) {
        return metricRepository.findByName(name);
    }

    public void deletar(long id) {
        metricRepository.delete(id);
    }
}