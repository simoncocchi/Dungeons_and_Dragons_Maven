package fr.campus.warriors.engine;

public class CaseEmpty extends Case {
	
	private String caseEmpty;
	
	public CaseEmpty () {
		this.caseEmpty = "Case vide";
	}
	
	@Override
	public String toString() {
		return "Vous êtes sur : " + caseEmpty;
		
	}

	@Override
	public void open(Player myHero) {
		// TODO Auto-generated method stub
		
	}

}
