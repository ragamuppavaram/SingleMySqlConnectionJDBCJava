package com.sqlex.project.sqldemo;

public class Demo {
	public static void main(String args[]) throws Exception {
		try {
			MySqlConnect.getConnection();
		} catch (Exception e) {
			System.out.println(e);
		}
		PersonDAO personDao = new PersonDAO();
		personDao.insert("raga", 10);
		personDao.update("seenu", 35, 10001);
		personDao.getAll();
	}
}
