import java.time.LocalDateTime;

class Payment {
	PaymentMethod method;
	float value;
	LocalDateTime dateTime;

	public Payment(PaymentMethod method, float value, LocalDateTime dateTime) {
        this.method = method;
        this.value = value;
        this.dateTime = dateTime;
    }
}