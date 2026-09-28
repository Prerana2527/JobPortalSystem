package org.techhub.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobApplicationModel extends UserModel {
    private int id;
    private int userId;
    private int jobId;
    private String status;
    private String appliedDate;
}
