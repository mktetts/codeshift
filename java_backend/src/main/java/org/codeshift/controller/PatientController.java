package org.codeshift.controller;

import org.codeshift.model.Patient;
import org.codeshift.service.PatientService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/patients")
public class PatientController {

	@Inject
    private PatientService patientService;

    @GET
    @Path("/getAllPatients")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<Patient> patients = patientService.findAll();
        return Response.ok(patients).build();
    }

    @GET
    @Path("/getPatientById/{patientId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("patientId") String patientId) {
        Patient patient = patientService.findById(Long.parseLong(patientId));
        return Response.ok(patient).build();
    }

    @GET
    @Path("/getPatientByEmail/{patientEmail}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByEmail(@PathParam("patientEmail") String patientEmail) {
        Patient patient = patientService.findByEmail(patientEmail);
        return Response.ok(patient).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(Patient patient) {
        patientService.save(patient);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Patient patient) {
        patientService.update(patient);
        return Response.ok().build();
    }

    @DELETE
    @Path("/deletePatientById/{patientId}")
    public Response deleteById(@PathParam("patientId") String patientId) {
        patientService.deleteById(Long.parseLong(patientId));
        return Response.ok().build();
    }

    @DELETE
    @Path("/deletePatientByEmail/{patientEmail}")
    public Response deleteByEmail(@PathParam("patientEmail") String patientEmail) {
        patientService.deleteByEmail(patientEmail);
        return Response.ok().build();
    }
}
