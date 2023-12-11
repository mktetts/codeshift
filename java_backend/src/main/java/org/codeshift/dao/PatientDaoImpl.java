package org.codeshift.dao;

import jakarta.enterprise.context.ApplicationScoped;

import org.codeshift.model.Patient;

@ApplicationScoped
public class PatientDaoImpl implements PatientDao {

	@Override
	public Patient findByEmail(String email) {
		return find("email", email).firstResult();
	}
	
	@Override
	public void deleteByEmail(String email) {
		delete("email", email);
	}
}




