package service.interfaces;

import model.Payment;

/**
 *
 * @author VJames
 */
public interface IPaymentService {

    public Payment findPaymentById(String id);

    public void updatePaymentStatus(String id, boolean isPaid);

    public void updatePaymentCode(String id, String payCode);

    public void createNewPaymentInfo(String id, String amount, String fullname, String phone, String email, String address, String userId, int tourId);
}
