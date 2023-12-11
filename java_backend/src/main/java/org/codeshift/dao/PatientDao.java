package org.codeshift.dao;

import org.codeshift.model.Patient;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

public interface PatientDao extends PanacheRepository<Patient> {

	Patient findByEmail(final String email);
	void deleteByEmail(final String email);
}




