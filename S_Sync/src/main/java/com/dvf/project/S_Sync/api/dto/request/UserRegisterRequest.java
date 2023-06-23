package com.dvf.project.S_Sync.api.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRegisterRequest {


    private String username;
    private String password;
    private Integer developer_id;


}
