package alioune;

public class Person {
	
	private String nom;
	private String prenom;
	private boolean isGentille;
	private boolean isGood;
	
	public Person(String nom, String prenom, boolean isGentille, boolean isGood) {
		this.nom = nom;
		this.prenom = prenom;
		this.isGentille = isGentille;
		this.isGood = isGood;
	}
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public boolean isGentille() {
		return isGentille;
	}
	public void setGentille(boolean isGentille) {
		this.isGentille = isGentille;
	}
	public boolean isGood() {
		return isGood;
	}
	public void setGood(boolean isGood) {
		this.isGood = isGood;
	}
	
	@Override
	public String toString() {
		return "[Person: " + "Nom: "+ this.getNom() + " Prenom: "+this.getPrenom()
		+ " Gentille: "+this.isGentille() + " Good: "+this.isGood() +"]"; 
	}
}
