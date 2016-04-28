package domain.person;

public enum Roles {
	
	DIRECTOR,
	ACTOR;
	
	private String roleType;
	




	public String getRoleType() {
		return roleType;
	}



	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	
	@Override
	public String toString(){
		return this.getRoleType();
	}

}
