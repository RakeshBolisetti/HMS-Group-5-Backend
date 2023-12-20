package com.team5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.team5.beans.Patient;
import com.team5.dto.PatientDTO;
import com.team5.repository.PatientDao;
import com.team5.repository.PhysicianDao;
import com.team5.services.PatientServiceImpl;

@TestMethodOrder(MethodOrderer.DisplayName.class)
class PatientServiceTest {


    @Mock
    private PatientDao patientRepository;

    @Mock
    private PhysicianDao physicianRepository;

    @InjectMocks
    private PatientServiceImpl patientService;

    @SuppressWarnings("deprecation")
    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("1_Find All Patients With Physician")
    void testFindAllPatientsWithPhysician() {

        Integer physicianid = 1;
        List<Patient> expectedPatients = new ArrayList<>();
        expectedPatients.add(new Patient());
        when(patientRepository.findByPhysician_Employeeid(physicianid)).thenReturn(expectedPatients);

        List<Patient> actualPatients = patientService.findAllPatientsWithPhysician(physicianid);

        assertEquals(expectedPatients.size(), actualPatients.size());
    }

    @Test
    @DisplayName("2_Find All Patients With Physician With Patient")
    void testFindAllPatientsWithPhysicianWithPatient() {

        Integer physicianid = 1;
        Integer patientid = 2;
        Patient expectedPatient = new Patient();
        when(patientRepository.findPatientWithPhysician(physicianid, patientid))
                .thenReturn(Optional.of(expectedPatient));

        Patient actualPatient = patientService.findAllPatientsWithPhysicianWithPatient(physicianid, patientid);

        assertEquals(expectedPatient, actualPatient);
    }

    @Test
    @DisplayName("3_Find InsuranceId By SSN")
    void testFindInsuranceIdBySsn() {

        Integer ssn = 123;
        Integer expectedInsuranceId = 456;
        when(patientRepository.getInsuranceIdBySsn(ssn)).thenReturn(Optional.of(expectedInsuranceId));

        Integer actualInsuranceId = patientService.findInsuranceIdBySsn(ssn);

        assertEquals(expectedInsuranceId, actualInsuranceId);
    }

    @Test
    @DisplayName("4_Update Address")
    void testUpdateAddress() {

        Integer ssn = 123;
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setAddress("123 Main St");
        Patient expectedPatient = new Patient();
        expectedPatient.setAddress(patientDTO.getAddress());
        when(patientRepository.findById(ssn)).thenReturn(Optional.of(expectedPatient));
        when(patientRepository.save(any(Patient.class))).thenReturn(expectedPatient);

        Patient actualPatient = patientService.updateAddress(ssn, patientDTO);

        assertEquals(expectedPatient.getAddress(), actualPatient.getAddress());
    }

    @Test
    @DisplayName("5_Update Phone")
    void testUpdatePhone() {

        Integer ssn = 123;
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setPhone("555-1234");
        Patient expectedPatient = new Patient();
        expectedPatient.setPhone(patientDTO.getPhone());
        when(patientRepository.findById(ssn)).thenReturn(Optional.of(expectedPatient));
        when(patientRepository.save(any(Patient.class))).thenReturn(expectedPatient);

        Patient actualPatient = patientService.updatePhone(ssn, patientDTO);

        assertEquals(expectedPatient.getPhone(), actualPatient.getPhone());
    }

    @Test
    @DisplayName("6_Update PatientDTO")
    void testUpdatePatientDTO() {

        Integer ssn = 123;
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setName("John Doe");
        patientDTO.setAddress("123 Main St");
        patientDTO.setPhone("555-1234");
        patientDTO.setInsuranceid(456);
        Patient expectedPatient = new Patient();
        expectedPatient.setName(patientDTO.getName());
        expectedPatient.setAddress(patientDTO.getAddress());
        expectedPatient.setPhone(patientDTO.getPhone());
        expectedPatient.setInsuranceid(patientDTO.getInsuranceid());
        when(patientRepository.findById(ssn)).thenReturn(Optional.of(expectedPatient));
        when(patientRepository.save(any(Patient.class))).thenReturn(expectedPatient);

        Patient actualPatient = patientService.updatePatientDTO(ssn, patientDTO);

        assertEquals(expectedPatient.getName(), actualPatient.getName());
        assertEquals(expectedPatient.getAddress(), actualPatient.getAddress());
        assertEquals(expectedPatient.getPhone(), actualPatient.getPhone());
        assertEquals(expectedPatient.getInsuranceid(), actualPatient.getInsuranceid());
    }
}
