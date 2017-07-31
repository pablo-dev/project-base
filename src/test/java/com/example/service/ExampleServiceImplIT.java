package com.example.service;

import com.example.Application;
import com.example.entity.Example;
import com.example.repository.ExampleRepository;
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

/**
 * Integration tests for the ExampleService
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ExampleServiceImplIT/beforeTestRun.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:ExampleServiceImplIT/afterTestRun.sql")
})
public class ExampleServiceImplIT {

    @Autowired
    private ExampleService exampleService;

    @Autowired
    private ExampleRepository exampleRepository;

    @Test
    public void find() {
        final String id = "10";
        final String name = "Paco";

        List<Example> exampleList = exampleService.findByName(name);
        assertNotNull(exampleList);
        assertEquals(1, exampleList.size());
        assertEquals(name, exampleList.get(0).getName());
        assertEquals(id, exampleList.get(0).getId());
    }

}
