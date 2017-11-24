package com.sdm.srsys.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sdm.srsys.dao.StudentInfoDao;
import com.sdm.srsys.model.StudentInfo;

@Service("studentInfoService")
@Transactional
public class StudentInfoServiceImpl implements StudentInfoService {
	
	@Autowired
	private StudentInfoDao studentInfoDao;
	
	public StudentInfo findStudentInfoByMyKidNo(String myKidNo) {
		return studentInfoDao.findStudentInfoByMyKidNo(myKidNo);
	}

	public StudentInfo findByMyKidNo(String myKidNo) {
		return studentInfoDao.findByMyKidNo(myKidNo);
	}

	public void saveStudentInfo(StudentInfo stu) {
		studentInfoDao.saveStudentInfo(stu);
	}
	
	public void updateStudentInfo(StudentInfo stu) {
		if (StringUtils.isNotBlank(stu.getNoMyKid())) {
			StudentInfo stun = findByMyKidNo(stu.getNoMyKid());
			if (stun != null) {
				studentInfoDao.updateStudentInfo(stu);
			}
		}
	}

	public void deleteStudentInfo(String myKidNo) {
		studentInfoDao.deleteStudentInfo(myKidNo);
	}

	public List<StudentInfo> findAllStudent(){
		return studentInfoDao.findAllStudent();
	}
	
	public Long countStudentInfo(StudentInfo o) {
		return studentInfoDao.countStudentInfo(o);
	}

	public List<StudentInfo> findStudentInfo(StudentInfo o, Integer first, Integer max, String sort, String seq){
		return studentInfoDao.findStudentInfo(o, first, max, sort, seq);
	}


}
