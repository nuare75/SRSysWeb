package com.sdm.srsys.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "STUDENTINFO")
public class StudentInfo implements Serializable {

	private static final long serialVersionUID = 3799496882400942671L;

	@Id
	@NotEmpty
	@Column(name ="MY_KID_NO")
	private String noMyKid;
	
	@NotEmpty
	@Size(max=30)
	@Column(name ="CARD_NAME")
	private String surname;
	
	@NotEmpty
	@Size(max=250)
	@Column(name ="FULL_NAME")
	private String fullname;
	
	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Past
	@Column(name ="DATE_OF_BIRTH")
	private Date dateOfBirth;
	
	@NotEmpty
	@Column(name ="STUDENT_ID")
	private BigInteger studentiId;
	
	@NotEmpty
	@Column(name ="YEAR_JOIN")
	private int yearJoin;
	
	@NotEmpty
	@Column(name ="GRADE_ENTER")
	private int gradeEnter;
	
	@Size(max=250)
	@Column(name ="ADDRESS1")
	private String address1;
	
	@Size(max=250)
	@Column(name ="ADDRESS2")
	private String address2;
	
	@Size(max=100)
	@Column(name ="CITY")
	private String city;
	
	@Size(max=10)
	@Column(name ="POSTCODE")
	private String postcode;
	
	@Size(max=100)
	@Column(name ="STATE")
	private String state;
	
	@Size(max=100)
	@Column(name ="CONTACT_NUM")
	private String contactNum;
	
	@NotEmpty
	@Size(max=10)
	@Column(name ="GENDER")
	private String gender;
	
	@Size(max=100)
	@Column(name ="RACE")
	private String race;
	
	@Column(name ="GRADE_COMPLETED")
	private int gradeCompleted;
	
	@Column(name ="YEAR_COMPLETED")
	private int yearCompleted;
	
	@NotNull
	@Column(name ="DATE_INSERT")
	private Timestamp dateInsert;
	
	@NotNull
	@Column(name ="DATE_UPDATE")
	private Timestamp dateUpdate;

	public String getNoMyKid() {
		return noMyKid;
	}

	public void setNoMyKid(String noMyKid) {
		this.noMyKid = noMyKid;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public BigInteger getStudentiId() {
		return studentiId;
	}

	public void setStudentiId(BigInteger studentiId) {
		this.studentiId = studentiId;
	}

	public int getYearJoin() {
		return yearJoin;
	}

	public void setYearJoin(int yearJoin) {
		this.yearJoin = yearJoin;
	}

	public int getGradeEnter() {
		return gradeEnter;
	}

	public void setGradeEnter(int gradeEnter) {
		this.gradeEnter = gradeEnter;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getContactNum() {
		return contactNum;
	}

	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public int getGradeCompleted() {
		return gradeCompleted;
	}

	public void setGradeCompleted(int gradeCompleted) {
		this.gradeCompleted = gradeCompleted;
	}

	public int getYearCompleted() {
		return yearCompleted;
	}

	public void setYearCompleted(int yearCompleted) {
		this.yearCompleted = yearCompleted;
	}

	public Timestamp getDateInsert() {
		return dateInsert;
	}

	public void setDateInsert(Timestamp dateInsert) {
		this.dateInsert = dateInsert;
	}

	public Timestamp getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Timestamp dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	@Override
	public String toString() {
		return "StudentInfo [noMyKid=" + noMyKid + ", surname=" + surname + ", fullname=" + fullname + ", dateOfBirth=" + dateOfBirth + ", studentiId=" + studentiId + ", yearJoin=" + yearJoin
				+ ", gradeEnter=" + gradeEnter + ", address1=" + address1 + ", address2=" + address2 + ", city=" + city + ", postcode=" + postcode + ", state=" + state + ", contactNum=" + contactNum
				+ ", gender=" + gender + ", race=" + race + ", gradeCompleted=" + gradeCompleted + ", yearCompleted=" + yearCompleted + ", dateInsert=" + dateInsert + ", dateUpdate=" + dateUpdate
				+ "]";
	}

}
