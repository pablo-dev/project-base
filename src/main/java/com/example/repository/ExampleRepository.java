package com.example.repository;

import com.example.entity.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository for the Example entity
 *
 * @author Pablo Carnero Liñán
 */
public interface ExampleRepository extends JpaRepository<Example, String> {
    /**
     * Find by name. I will search any entity that contain the given parameter in the name.
     *
     * @param name name
     * @return entity list list
     */
    @Query("SELECT e FROM Example e WHERE e.name like %:name%")
    List<Example> findByName(@Param("name") String name);
}
