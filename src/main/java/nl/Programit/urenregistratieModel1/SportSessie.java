package nl.Programit.urenregistratieModel1;

public class SportSessie {
	private int trainer;//empId van de trainer
	private int klant;//klantIdNummer van de klant
	private boolean bevestigd;//training is doorgegaan

	public int getTrainer() {
		return trainer;
	}

	public void setTrainer(int trainer) {
		this.trainer = trainer;
	}

	public int getKlant() {
		return klant;
	}

	public void setKlant(int klant) {
		this.klant = klant;
	}

	public boolean isBevestigd() {
		return bevestigd;
	}

	public void setBevestigd(boolean bevestigd) {
		this.bevestigd = bevestigd;
	}
}
