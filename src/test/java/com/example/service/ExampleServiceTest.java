package com.example.service;

import com.example.entity.Example;
import com.example.repository.ExampleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ExampleServiceTest {

    @InjectMocks
    ExampleService underTest;

    @Mock
    private ExampleRepository exampleRepository;

    /**
     * Example findByName test
     */
    @Test
    public void find() {

        // mock data
        final String id = "saqwer23412r12rqwerq";
        final String name = "Paco";
        Example example = new Example();
        example.setId(id);
        example.setName(name);
        List<Example> exampleList = new ArrayList<>();
        exampleList.add(example);
        when(exampleRepository.findByName(Mockito.anyString())).thenReturn(exampleList);

        // test method
        List<Example> resultList = underTest.findByName(name);
        assertNotNull(resultList);
        assertEquals(1, resultList.size());
        assertEquals(id, resultList.get(0).getId());
        assertEquals(name, resultList.get(0).getName());
    }

}
