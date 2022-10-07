package ca.ntro.cards.examen2.models.gr1;

import java.io.Serializable;

import ca.ntro.app.models.Value;

public class Animal implements Value, Serializable {

	private static final long serialVersionUID = 5015424701346122874L;

	private int age;
	private Groupe membreDe;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Groupe getMembreDe() {
		return membreDe;
	}

	public void setMembreDe(Groupe membreDe) {
		this.membreDe = membreDe;
	}
	
	

}
