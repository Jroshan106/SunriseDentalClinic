package Tests;

import model.Bill;
import org.junit.Test;
import static org.junit.Assert.*;

public class BillCalculationTest {

    @Test
    public void testAutomaticBillCalculation() {

        Bill bill = new Bill();

        bill.setConsultationFee(2000.00);
        bill.setTreatmentFee(5000.00);
        bill.setDiscount(500.00);

        double total = bill.calculateTotal();

        assertEquals(
            "The total bill should be Rs. 6500.00",
            6500.00,
            total,
            0.01
        );
    }
}