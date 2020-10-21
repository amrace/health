package com.example.health.parameterRepository;

import java.util.List;

import org.json.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.health.model.Parameter;
import com.example.health.model.Patient;

@Repository
public interface ParameterRepo extends JpaRepository<Parameter, Integer> {

	List<Parameter> findAll();
	Patient getParameterById(Integer id);

}
