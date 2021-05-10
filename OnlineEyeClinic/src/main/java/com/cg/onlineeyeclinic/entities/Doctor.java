package com.cg.onlineeyeclinic.entities; 
 
import java.util.List; 
import javax.persistence.CascadeType; 
import javax.persistence.Column; 
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType; 
import javax.persistence.Id; 
import javax.persistence.OneToMany; 
import com.fasterxml.jackson.annotation.JsonIgnore; 

//************************************Doctor Entity Class**************************************//

@Entity  
public class Doctor  
{ 
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name="Doctor_Id") 
	private int doctorId; 
	 
	@Column(name="Name") 
	private String name; 
	 
	@Column(name="Username") 
	private String userName; 
	 
	
	@Column(name="Password") 
	private String password; 
	
	@Column(name="Email") 
	private String email; 
	 
	@Column(name="Consultation_Time") 
	private String consultationTime; 
	 
	
	@Column(name="Mobile_Number") 
	private String mobile; 
	 
	
	@Column(name="Address") 
	private String address; 
	 
	@OneToMany(cascade=CascadeType.ALL,mappedBy="doctor") 
	private List<Appointment> appointments; 
	
	 
	//getters and setters
	public int getDoctorId() { 
		return doctorId; 
	} 
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getName() { 
		return name; 
	} 
	public void setName(String name) { 
		this.name = name; 
	} 
	public String getAddress() { 
		return address; 
	} 
	public void setAddress(String address) { 
		this.address = address; 
	} 
	public String getUserName() { 
		return userName; 
	} 
	public void setUserName(String userName) { 
		this.userName = userName; 
	} 
	public String getPassword() { 
		return password; 
	} 
	public void setPassword(String password) { 
		this.password = password; 
	} 
	public String getEmail() { 
		return email; 
	} 
	public void setEmail(String email) { 
		this.email = email; 
	} 
	public String getConsultationTime() { 
		return consultationTime; 
	} 
	public void setConsultationTime(String consultationTime) { 
		this.consultationTime = consultationTime; 
	} 
	public String getMobile() { 
		return mobile; 
	} 
	public void setMobile(String mobile) { 
		this.mobile = mobile; 
	} 
	 
		@JsonIgnore 
		public List<Appointment> getAppointments() { 
			return appointments; 
		} 
		@JsonIgnore 
		public void setAppointments(List<Appointment> appointments) { 
			this.appointments = appointments; 
		} 
	 
	//constructors
	public Doctor() {
		super();
	}
	public Doctor(int doctorId, String name, String userName, String password, String email, String consultationTime,
			String mobile, String address) {
		super();
		this.doctorId = doctorId;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.consultationTime = consultationTime;
		this.mobile = mobile;
		this.address = address;
	}

	
}
