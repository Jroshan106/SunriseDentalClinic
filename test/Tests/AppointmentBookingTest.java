
package Tests;

import dao.AppointmentDAO;
import org.junit.Test;
import static org.junit.Assert.*;

public class AppointmentBookingTest {

    @Test
    public void testDoubleBookingConflict() {

        AppointmentDAO dao = new AppointmentDAO();

        boolean booked = dao.isDentistBooked(
            1,
            "2026-09-10",
            "10:00:00"
        );

        assertTrue(
            "The selected dentist and time are already booked. Double booking should be prevented.",
            booked
        );
    }
}

