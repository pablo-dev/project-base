package com.example.repository;

import com.example.Application;
import com.example.entity.Example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ExampleRepositoryIT/beforeTestRun.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:ExampleRepositoryIT/afterTestRun.sql")
})
public class ExampleRepositoryIT {

    @Autowired
    private ExampleRepository exampleRepository;

    private final String name = "Paco";

    /**
     * Find by full name
     */
    @Test
    public void findByName() {
        List<Example> exampleList = exampleRepository.findByName(name);
        assertNotNull(exampleList);
        assertEquals(1, exampleList.size());
        assertEquals(name, exampleList.get(0).getName());
    }

    /**
     * Find by partial name
     */
    @Test
    public void findByNamePartial() {
        final String name = "Paco";
        List<Example> exampleList = exampleRepository.findByName("ac");
        assertNotNull(exampleList);
        assertEquals(1, exampleList.size());
        assertEquals(name, exampleList.get(0).getName());
    }

    /**
     * Try entity not found
     */
    @Test
    public void findByNameNotFound() {
        final String name = "asdf";
        List<Example> exampleList = exampleRepository.findByName(name);
        assertNotNull(exampleList);
        assertEquals(0, exampleList.size());
    }
}
