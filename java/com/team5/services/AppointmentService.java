package com.team5.services;

import java.sql.Date;
import java.util.List;

import com.team5.beans.Appointment;
import com.team5.beans.Nurse;
import com.team5.beans.Patient;
import com.team5.beans.Physician;
import com.team5.dto.AppointmentDTO;

public interface AppointmentService  {
	
//	String addNewAppointmentService(AppointmentDto appointment);
//	
//	List<Appointment> getAllAppointmentService();
//	List<Appointment> getAllAppointmentByDateService(LocalDateTime startDate);
//	
//	Patient getPatientInformation(int appointmentId);
//	Physician getPhysician(int appointmentId);
//	
//	Nurse getNurse(int appointmentId);
//	String getExaminationRoomService(int appointmentId);
//	List<Physician> getAllPhysicianByPatientIdService(int patientId);
//	Physician getPhysicianOnParticularDate(Date appointmentDate,int patientId);
//	List<Nurse> getAllNurseByPatientIdService(int patientId);
//	Nurse getNurseOnParticularDate(Date appointmentDate,int patientId);
//	List<Date> getAllDates(int patientId);
//	List<Patient> getAllPatientsByPhysician(int physicianId);
//	List<Patient> getAllPatientByPhysicianOnDateService(int physicianId,Date date);
//	Patient getPatientByPhysicianByPatientIdService(int physicianId,int patientId);
//	List<Patient> getAllPatientByNurse(int nurseId);
//	Patient getPatientByPatientIdByNurse(int nurseId,int patiendId);
//	List<Patient> getAllPatientByNurseOnDate(int nurseId,Date dateConv);
//	String getRoomByPatientIdOnDate(int patientId,Date date);
//
//	List<String> getAllRoomByPhysicianIdOnDate(int physicianId, Date dateConv);
//
//	List<String> getAllRoomByNurseIdOnDate(int nurseId, Date dateConv);
//
//	String updateRoomById(int appointmentId,String room);
	Appointment create(AppointmentDTO appointmentDTO);
	List<Appointment> getAll();
	List<Appointment> findAllByStarto(Date startDate);
	Patient findPatient(Integer appointmentid);
	Physician findPhysician(Integer appointmentid);
	List<Physician> findPhysicianByPatientId(Integer id);
	List<Physician> findPhysicians();
	Nurse findNurse(Integer appointmentid);
	List<Nurse> findNurseByPatientId(Integer id);
	List<Nurse> findNurses();
	List<Object[]> findAppointmentDatesOfPatient(Integer id);
	List<Patient> findPatientsCheckedByPhysician(Integer physicianid);
	List<Patient> findPatientsCheckedByPhysicianOnDate(Integer physicianid, Date date);
	Patient findPatientCheckedByPhysicianById(Integer physicianid, Integer patientid);
	List<Patient> findPatientsCheckedByNurse(Integer nurseid);
	Patient findPatientCheckedByNurseById(Integer nurseid, Integer patientid);
	List<Patient> findPatientsCheckedByNurseOnDate(Integer nurseid, Date date);
	List<Appointment> getAppointmentsByPhysician(Integer physicianId);
	List<Patient> findAllPatients();
	List<Appointment> findAllAppointmentsByPatientId(Integer patientId);
}
