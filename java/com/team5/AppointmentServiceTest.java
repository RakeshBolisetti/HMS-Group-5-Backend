package com.team5;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.team5.beans.Appointment;
import com.team5.beans.Patient;
import com.team5.beans.Physician;
import com.team5.dto.AppointmentDTO;
import com.team5.repository.AppointmentDao;
import com.team5.services.AppointmentServiceImpl;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class AppointmentServiceTest {

    @Mock
    private AppointmentDao mockAppointmentRepository;
    
    @InjectMocks
    private AppointmentServiceImpl appointmentService;
    
    @SuppressWarnings("deprecation")
    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    // 1. getAll
    @Test
    public void testGetAllAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        appointments.add(new Appointment());
        appointments.add(new Appointment());
        Mockito.when(mockAppointmentRepository.findAll()).thenReturn(appointments);
        List<Appointment> result = appointmentService.getAll();
        Mockito.verify(mockAppointmentRepository, Mockito.times(1)).findAll();
        Assertions.assertEquals(result.size(), 2);
    }

    // 2. create
    @Test
    public void testCreateAppointment() {
        AppointmentDTO appointmentDTO = new AppointmentDTO();
        appointmentDTO.setPatient(100000001);
        appointmentDTO.setPhysician(2);
        appointmentDTO.setAppointmentDateTime(new Timestamp(System.currentTimeMillis()));
        appointmentDTO.setExaminationroom("Room 1");

        Appointment appointment = new Appointment();
        appointment.setAppointmentid(93216603);

        Mockito.when(mockAppointmentRepository.save(Mockito.any(Appointment.class))).thenReturn(appointment);

        Appointment result = appointmentService.create(appointmentDTO);

        Mockito.verify(mockAppointmentRepository, Mockito.times(1)).save(Mockito.any(Appointment.class));
        Assertions.assertEquals(result.getAppointmentid().getClass(), Integer.class);
    }

    // 3. findAllByStarto
    @Test
    public void testFindAllByStartDate() {
        List<Appointment> appointments = new ArrayList<>();
        appointments.add(new Appointment());
        appointments.add(new Appointment());
        Mockito.when(mockAppointmentRepository.findAllByAppointmentDateTime(Mockito.any(Date.class))).thenReturn(appointments);
        List<Appointment> result = appointmentService.findAllByStarto(new Date(System.currentTimeMillis()));
        Mockito.verify(mockAppointmentRepository, Mockito.times(1)).findAllByAppointmentDateTime(Mockito.any(Date.class));
        Assertions.assertEquals(result.size(), 2);
    }

    // 4. findPatient
    @Test
    public void testFindPatient() {
        Patient patient = new Patient();
        Mockito.when(mockAppointmentRepository.findPatientByAppointmentId(Mockito.anyInt())).thenReturn(Optional.of(patient));
        Patient result = appointmentService.findPatient(1);
        Mockito.verify(mockAppointmentRepository, Mockito.times(1)).findPatientByAppointmentId(Mockito.anyInt());
        Assertions.assertEquals(result, patient);
    }

    // 5. findPhysician
    @Test
    public void testFindPhysician() {
        Physician physician = new Physician();
        Mockito.when(mockAppointmentRepository.findPhysicianByAppointmentId(Mockito.anyInt())).thenReturn(Optional.of(physician));
        Physician result = appointmentService.findPhysician(1);
        Mockito.verify(mockAppointmentRepository, Mockito.times(1)).findPhysicianByAppointmentId(Mockito.anyInt());
        Assertions.assertEquals(result, physician);
    }

    // 6. findPhysicianByPatientId
    @Test
    public void testFindPhysicianByPatientId() {
        List<Physician> physicians = new ArrayList<>();
        physicians.add(new Physician());
        physicians.add(new Physician());
        Mockito.when(mockAppointmentRepository.findPhysicianByPatientId(Mockito.anyInt())).thenReturn(physicians);
        List<Physician> result = appointmentService.findPhysicianByPatientId(1);
        Mockito.verify(mockAppointmentRepository, Mockito.times(1)).findPhysicianByPatientId(Mockito.anyInt());
        Assertions.assertEquals(result.size(), 2);
    }

    // 7. findPhysicians
    @Test
    public void testFindPhysicians() {
        List<Physician> physicians = new ArrayList<>();
        physicians.add(new Physician());
        physicians.add(new Physician());
        Mockito.when(mockAppointmentRepository.findPhysicians()).thenReturn(physicians);
        List<Physician> result = appointmentService.findPhysicians();
        Mockito.verify(mockAppointmentRepository, Mockito.times(1)).findPhysicians();
        Assertions.assertEquals(result.size(), 2);
    }
}