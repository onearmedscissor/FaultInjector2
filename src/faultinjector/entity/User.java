package faultinjector.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the User database table.
 * 
 */
@Entity
@Table(name="User")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="User_id")
	private int user_id;

	@Column(name="Administrator")
	private boolean administrator;

	@Column(name="Email")
	private String email;

	@Column(name="Institution")
	private String institution;

	@Column(name="Name")
	private String name;

	@Column(name="Password")
	private String password;

	@Column(name="Username")
	private String username;

	//bi-directional many-to-one association to Experiment
	@OneToMany(mappedBy="user", cascade = CascadeType.PERSIST)
	private List<Experiment> experiments;

	public User() {
	}

	public int getUser_id() {
		return this.user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public boolean getAdministrator() {
		return this.administrator;
	}

	public void setAdministrator(boolean administrator) {
		this.administrator = administrator;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInstitution() {
		return this.institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Experiment> getExperiments()
	{
		if(this.experiments==null)
			this.experiments = new ArrayList<Experiment>();
		
		return this.experiments;
	}

	public void setExperiments(List<Experiment> experiments) {
		this.experiments = experiments;
	}

	public Experiment addExperiment(Experiment experiment)
	{
		getExperiments().add(experiment);
		experiment.setUser(this);

		return experiment;
	}

	public Experiment removeExperiment(Experiment experiment) {
		getExperiments().remove(experiment);
		experiment.setUser(null);

		return experiment;
	}

}