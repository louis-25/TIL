package emp;
//DTO-DATA TRANSFER OBJECT
//EMPLOYEES 11개 컬럼들
public class EmployeeDTO { // 1개 EMPLOYEES 행 레코드
	int employee_id, manager_id, department_id; //사번 변수
	String first_name, last_name, email, phone_number, job_id, hire_date;
	double salary, commission_pct;
	//생성자
	//setter / getter
	//toString
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public String getHire_date() {
		return hire_date;
	}
	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getCommission_pct() {
		return commission_pct;
	}
	public void setCommission_pct(double commission_pct) {
		this.commission_pct = commission_pct;
	}
	
}
//EMPLOYEE_ID                                 NOT NULL NUMBER(6)
//FIRST_NAME                                  VARCHAR2(20)
//LAST_NAME                                   NOT NULL VARCHAR2(25)
//EMAIL                                       NOT NULL VARCHAR2(25)
//PHONE_NUMBER                               VARCHAR2(20)
//HIRE_DATE                                   NOT NULL DATE
//JOB_ID                                      NOT NULL VARCHAR2(10)
//SALARY                                      NUMBER(8,2)
//COMMISSION_PCT                              NUMBER(2,2)
//MANAGER_ID                                  NUMBER(6)
//DEPARTMENT_ID                               NUMBER(4)