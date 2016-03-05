package nl.Programit.urenregistratieSessie;
import nl.Programit.administratie.*;

import java.util.*;

public interface SessionManageable {
	Session createSession();
	boolean VerifySession();
	void showSession(Trainer t, Date... d); 
	void showTrainers();
	Session selectSession(int sessionId);
	Trainer selectTrainer(int trainerId);
}
