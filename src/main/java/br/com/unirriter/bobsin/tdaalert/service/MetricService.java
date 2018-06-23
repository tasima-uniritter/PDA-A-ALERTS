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

    public Metric buscarPorId(Long code) {
        return metricRepository.findByCode(code);
    }

    public Metric buscarPorName(String name) {
        return metricRepository.findByName(name);
    }

    /*public void deletar(Long id) {
        metricRepository.delete(id);
    }*/
}