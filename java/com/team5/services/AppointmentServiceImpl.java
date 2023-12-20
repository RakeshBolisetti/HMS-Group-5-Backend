package com.team5.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.beans.Appointment;
import com.team5.beans.Nurse;
import com.team5.beans.Patient;
import com.team5.beans.Physician;
import com.team5.dto.AppointmentDTO;
import com.team5.repository.AppointmentDao;
import com.team5.repository.PatientDao;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentDao appointmentRepository;


    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }

    public Appointment create(AppointmentDTO appointmentDTO) {
        Appointment appointment = new Appointment();
        appointment.setPatient(appointmentDTO.getPatient());
        appointment.setPhysician(appointmentDTO.getPhysician());
        appointment.setAppointmentDateTime(appointmentDTO.getAppointmentDateTime());
        appointment.setExaminationroom(appointmentDTO.getExaminationroom());
//        Integer addedAppointmentId = appointmentRepository.save(appointment).getAppointmentid();
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> findAllByStarto(Date startDate) {
        return appointmentRepository.findAllByAppointmentDateTime(startDate);
    }

    public Patient findPatient(Integer appointmentid) {
        Optional<Patient> op = appointmentRepository.findPatientByAppointmentId(appointmentid);
        return op.orElse(null);
    }

    public Physician findPhysician(Integer appointmentid) {
        Optional<Physician> op = appointmentRepository.findPhysicianByAppointmentId(appointmentid);
        return op.orElse(null);
    }

    public List<Physician> findPhysicianByPatientId(Integer id) {
        List<Physician> found = appointmentRepository.findPhysicianByPatientId(id);
        if (!found.isEmpty()) {
            return found;
        } else {
            return null;
        }
    }

    public List<Physician> findPhysicians() {
        List<Physician> found = appointmentRepository.findPhysicians();
        if (!found.isEmpty()) {
            return found;
        } else {
            return null;
        }
    }

    public Nurse findNurse(Integer appointmentid) {
        Optional<Nurse> op = appointmentRepository.findNurseByAppointmentId(appointmentid);
        return op.orElse(null);
    }

    public List<Nurse> findNurseByPatientId(Integer id) {
        List<Nurse> found = appointmentRepository.findNurseByPatientId(id);
        if (!found.isEmpty()) {
            return found;
        } else {
            return null;
        }
    }

    public List<Nurse> findNurses() {
        List<Nurse> found = appointmentRepository.findNurses();
        if (!found.isEmpty()) {
            return found;
        } else {
            return null;
        }
    }

    public List<Object[]> findAppointmentDatesOfPatient(Integer id) {
        List<Object[]> found = appointmentRepository.getAppointmentDatesOfPatient(id);
        if (!found.isEmpty()) {
            return found;
        } else {
            return null;
        }
    }

    public List<Patient> findPatientsCheckedByPhysician(Integer physicianid) {
        return appointmentRepository.getPatientsAttendedByPhysician(physicianid);
    }

    public List<Patient> findPatientsCheckedByPhysicianOnDate(Integer physicianid, Date date) {
        return appointmentRepository.getPatientsAttendedByPhysicianOnDate(physicianid, date);
    }

    public Patient findPatientCheckedByPhysicianById(Integer physicianid, Integer patientid) {
        return appointmentRepository.getPatientCheckedByPhysicianById(physicianid, patientid);
    }

    public List<Patient> findPatientsCheckedByNurse(Integer nurseid) {
        return appointmentRepository.getPatientsCheckedByNurse(nurseid);
    }

    public Patient findPatientCheckedByNurseById(Integer nurseid, Integer patientid) {
        return appointmentRepository.getPatientCheckedByNurseById(nurseid, patientid);
    }

    public List<Patient> findPatientsCheckedByNurseOnDate(Integer nurseid, Date date) {
        return appointmentRepository.getPatientsCheckedByNurseOnDate(nurseid, date);
    }

    public List<Appointment> getAppointmentsByPhysician(Integer physicianId) {
        return appointmentRepository.findByPhysicianId(physicianId);
    }

    @Autowired
    private PatientDao patientRepository;

    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }

	public List<Appointment> findAllAppointmentsByPatientId(Integer patientId) {
		List<Appointment> appointments = appointmentRepository.findByPatient2Ssn(patientId);
		
		return appointments;
	}

}
