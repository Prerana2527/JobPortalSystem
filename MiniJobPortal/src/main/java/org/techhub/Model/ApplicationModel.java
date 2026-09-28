package org.techhub.Model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApplicationModel extends JobModel{
	
	private int id;
	private int jobId;
	private int userId;
	private int status;
	private String title;
	private String name;
	private String contact;
	private String email;

}
