package com.team5.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.team5.beans.Appointment;
import com.team5.beans.Nurse;
import com.team5.beans.Patient;
import com.team5.beans.Physician;

public interface AppointmentDao extends JpaRepository<Appointment, Integer> {

	List<Appointment> findAllByAppointmentDateTime(Date appointmentDateTime);

	@Query("SELECT app.patient2 FROM Appointment app WHERE app.appointmentid= :id")
	Optional<Patient> findPatientByAppointmentId(Integer id);

	@Query("SELECT app.physician2 FROM Appointment app WHERE app.appointmentid= :id")
	Optional<Physician> findPhysicianByAppointmentId(Integer id);

	@Query("SELECT app.physician2 FROM Appointment app WHERE app.patient2.ssn= :id")
	List<Physician> findPhysicianByPatientId(Integer id);

	@Query("SELECT app.physician2 FROM Appointment app")
	List<Physician> findPhysicians();

	@Query("SELECT app.nurse FROM Appointment app WHERE app.appointmentid= :id")
	Optional<Nurse> findNurseByAppointmentId(Integer id);

	@Query("SELECT app.nurse FROM Appointment app WHERE app.patient2.ssn= :id")
	List<Nurse> findNurseByPatientId(Integer id);

	@Query("SELECT app.nurse FROM Appointment app")
	List<Nurse> findNurses();

	@Query("SELECT app.appointmentDateTime FROM Appointment app WHERE app.patient2.ssn= :id")
	List<Object[]> getAppointmentDatesOfPatient(Integer id);

	@Query("SELECT a.patient2 FROM Appointment a WHERE a.physician2.employeeid = ?1")
	List<Patient> getPatientsAttendedByPhysician(Integer physicianid);

	@Query("SELECT a.patient FROM Appointment a WHERE a.physician2.employeeid = ?1 AND a.appointmentDateTime = ?2")
	List<Patient> getPatientsAttendedByPhysicianOnDate(Integer physicianid, Date date);

	@Query("SELECT a.patient FROM Appointment a WHERE a.physician2.employeeid = ?1 AND a.patient2.ssn = ?2")
	Patient getPatientCheckedByPhysicianById(Integer physicianid, Integer patientid);

	@Query("SELECT a.patient FROM Appointment a WHERE a.nurse.employeeid = ?1")
	List<Patient> getPatientsCheckedByNurse(Integer nurseid);

	@Query("SELECT a.patient FROM Appointment a WHERE a.nurse.employeeid = ?1 AND a.patient2.ssn = ?2")
	Patient getPatientCheckedByNurseById(Integer nurseid, Integer patientid);

	@Query("SELECT a.patient FROM Appointment a WHERE a.nurse.employeeid = ?1 AND a.appointmentDateTime = ?2")
	List<Patient> getPatientsCheckedByNurseOnDate(Integer nurseid, Date date);

	@Query("select a from Appointment a join a.physician2 p where p.employeeid=:employeeid")
	List<Appointment> findByPhysicianId(@Param("employeeid") int employeeid);

	List<Appointment> findByPatient2Ssn(Integer patientId);

}
