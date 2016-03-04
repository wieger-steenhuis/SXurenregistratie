package test;
import java.util.Date;

public interface SessionManageable {
	Session createSession();
	boolean VerifySession();
	void showSession(Trainer t, Date... d); 
	void showTrainers();
	Session selectSession(int sessionId);
	Trainer selectTrainer(int trainerId);
}
