package com.example.service;

import com.example.entity.Example;
import com.example.repository.ExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Example services implementation
 *
 * @author Pablo Carnero Liñán
 */
@Service
public class ExampleService {

    @Autowired
    private ExampleRepository exampleRepository;

    /**
     * Find by name
     *
     * @param name entity name
     * @return list of coincidences
     */
    @Transactional
    public List<Example> findByName(String name) {
        return exampleRepository.findByName(name);
    }

}
