package com.project.domain;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import com.cg.connection.MyConnection;
import com.cg.util.DateUtil;

public class Employee implements Serializable{
	private static final long serialVersionUID = 2632976247419906262L;
	private int empId;
	private String ename;
	private static String kinId;
	private String email;
	private String phoneNo;
	private String address;
	private String dob;
	private String doj;
	private int deptId;//10
	private int projId;//100
	private int roleId;//1000
	private static String strid;
	
	static{
		kinId=strid;
	}
	
	{
		kinId=(strid+(int) Math.random()*111.11);
	}
	
	public Employee() {
		
	}

	public Employee(int empId, String ename, String kinId, String email,
			String phoneNo, String address, String dob, String doj, int deptId,
			int roleId, int projId) {
		super();
		this.empId = empId;
		this.ename = ename;
		this.kinId = kinId;
		this.email = email;
		this.phoneNo = phoneNo;
		this.address = address;
		this.dob = dob;
		this.doj = doj;
		this.deptId = deptId;
		this.roleId = roleId;
		this.projId = projId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getKinId() {
		return kinId;
	}

	public void setKinId(String kinId) {
		this.kinId = kinId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getProjId() {
		return projId;
	}

	public void setProjId(int projId) {
		this.projId = projId;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", ename=" + ename + ", kinId="
				+ kinId + ", email=" + email + ", phoneNo=" + phoneNo
				+ ", address=" + address + ", dob=" + dob + ", doj=" + doj
				+ ", deptId=" + deptId + ", roleId=" + roleId + ", projId="
				+ projId + "]";
	}
	//business method
	public String getEmployee() {
		
		Connection con=null;
		Statement stmt=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String message="";
		String sql="insert into employee values (?,?,?,?,?,?,?,?,?,?,?)";
		try {		
			con=MyConnection.getConnection();
			System.out.println("Connection Obtained"+con);		
			stmt= con.createStatement();
			rs = stmt.executeQuery("select SQ_Emp.nextval from dual");
			if ( rs!=null && rs.next() ){
				 setEmpId(rs.getInt(1));
				 setKinId("KINID"+empId);
				System.out.println(empId);
				rs.close();
			}
			System.out.println("GetEmployee .... "+this);
			ps= con.prepareStatement(sql);	
			ps.setInt(1, getEmpId());
			ps.setString(2, getEname());
			ps.setString(3, getKinId());
			ps.setString(4,getEmail());
			ps.setString(5, getPhoneNo());
			ps.setString(6, getAddress());
			java.sql.Date sqlDob=
					DateUtil.convertStringtoSql(getDob());
			ps.setDate(7, sqlDob);
			java.sql.Date sqlDoj=
					DateUtil.convertStringtoSql(getDoj());
			ps.setDate(8, sqlDoj);
			ps.setInt(9, getDeptId());
			ps.setInt(10, getProjId());
			ps.setInt(11, getRoleId());
			
			int noOfRecords=ps.executeUpdate();	
			System.out.println(noOfRecords);
			if(noOfRecords==1){
				message="Employee Inserted successfully--->";					
			}else{
				message="Sorry Boss! Employee record"
						+ " not inserted";
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}finally{
			try {
				if(ps!=null)
					ps.close();
				if(con!=null)
					MyConnection.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}			
		}		
		return message;
	}
}
