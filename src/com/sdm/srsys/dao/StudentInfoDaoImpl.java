package com.sdm.srsys.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.sdm.srsys.model.StudentInfo;

@Repository("studentInfoDao")
public class StudentInfoDaoImpl extends AbstractDao<Integer, StudentInfo> implements StudentInfoDao {

	public StudentInfo findStudentInfoByMyKidNo(String myKidNo) {
		return null;
	}
	
	public StudentInfo findByMyKidNo(String myKidNo) {
		try {
			return (StudentInfo) getEntityManager().createQuery("SELECT e FROM StudentInfo e WHERE e.mykidno = :mykidno").setParameter("mykidno", myKidNo).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public void saveStudentInfo(StudentInfo stu) {
		insert(stu);
	}
	
	public void updateStudentInfo(StudentInfo stu) {
		update(stu);
	}

	public void deleteStudentInfo(String myKidNo) {
		delete(findByMyKidNo(myKidNo));
	}

	@SuppressWarnings("unchecked")
	public List<StudentInfo> findAllStudent() {
		List<StudentInfo> list = getEntityManager().createQuery("SELECT e FROM StudentInfo e ORDER BY e.fullname ASC").getResultList();
		return list;
	}

	public Long countStudentInfo(StudentInfo o) {
		return (long) getEntityManager().createQuery("SELECT COUNT(o) FROM StudentInfo o ").getFirstResult();
	}

	@SuppressWarnings("unchecked")
	public List<StudentInfo> findStudentInfo(StudentInfo o, Integer first, Integer max, String sort, String seq) {
		List<StudentInfo> list = getEntityManager().createQuery("SELECT e FROM StudentInfo e ORDER BY e.fullname ASC").setFirstResult(first).setMaxResults(max).getResultList();
		return list;
	}

	

}
