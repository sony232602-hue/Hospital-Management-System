import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class HospitalManagementTest {

    @Test
    public void testPatientRegistration() {

        Hospital hospital = new Hospital();

        Patient patient =
            new Patient(1, "Rahul", 25, "Fever");

        hospital.addPatient(patient);

        assertNotNull(
            hospital.findPatient("Rahul")
        );
    }

    @Test
    public void testDoctorRegistration() {

        Hospital hospital = new Hospital();

        Doctor doctor =
            new Doctor(1, "Dr. Kumar", "Cardiology");

        hospital.addDoctor(doctor);

        assertNotNull(
            hospital.findDoctor("Dr. Kumar")
        );
    }

    @Test
    public void testAppointmentBooking() {

        Hospital hospital = new Hospital();

        hospital.addPatient(
            new Patient(1, "Rahul", 25, "Fever")
        );

        hospital.addDoctor(
            new Doctor(1, "Dr. Kumar", "Cardiology")
        );

        boolean result =
            hospital.bookAppointment(
                "Rahul",
                "Dr. Kumar"
            );

        assertTrue(result);
    }

    @Test
    public void testInvalidAppointment() {

        Hospital hospital = new Hospital();

        boolean result =
            hospital.bookAppointment(
                "Unknown",
                "Dr. Kumar"
            );

        assertFalse(result);
    }
}