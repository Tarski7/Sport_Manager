package pl.coderslab.entity;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Player {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@NotEmpty(message = "First name can not be empty")
	private String firstName;
	@NotEmpty(message = "Last name can not be empty")
	private String lastName;
	@NotEmpty(message = "Nationality can not be empty")
	private String nationality;
	//@NotEmpty(message = "Position can not be empty")
	private String position;
	@Min(value = 1, message = "Too low number")
	@Max(value = 99, message = "Too high number")
	private int tShirtNumber;
	private int goa;
	private int def;
	private int mid;
	private int off;
	
	@ManyToOne
	@JoinColumn(name = "team_id")
	private Team team;
	
	public Player() {
		Random r = new Random();
		setGoa(r.nextInt(100));
		setDef(r.nextInt(100));
		setMid(r.nextInt(100));
		setOff(r.nextInt(100));
		
		int max = this.getGoa();
		setPosition("Goalkeeper");
		if (max < this.getDef()) {
			max = this.getDef();
			setPosition("Defender");
		}
		if (max < this.getMid()) {
			max = this.getMid();
			setPosition("Midfielder");
		}
		if (max < this.getOff()) {
			max = this.getOff();
			setPosition("Forward");
		}
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int gettShirtNumber() {
		return tShirtNumber;
	}

	public void settShirtNumber(int tShirtNumber) {
		this.tShirtNumber = tShirtNumber;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public int getGoa() {
		return goa;
	}

	public void setGoa(int goa) {
		this.goa = goa;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public int getOff() {
		return off;
	}

	public void setOff(int off) {
		this.off = off;
	}
	
}
