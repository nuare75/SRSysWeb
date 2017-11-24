package com.sdm.srsys.dao;

import java.util.List;

import com.sdm.srsys.model.StudentInfo;

public interface StudentInfoDao {
	
	StudentInfo findStudentInfoByMyKidNo(String myKidNo);
	
	StudentInfo findByMyKidNo(String myKidNo);
	
	void saveStudentInfo(StudentInfo stu);
	
	void updateStudentInfo(StudentInfo stu);
	
	void deleteStudentInfo(String myKidNo);
	
	List<StudentInfo> findAllStudent();
	
	public Long countStudentInfo(StudentInfo o);
	
	public List<StudentInfo> findStudentInfo(StudentInfo o, Integer first, Integer max, String sort, String seq); 
}
