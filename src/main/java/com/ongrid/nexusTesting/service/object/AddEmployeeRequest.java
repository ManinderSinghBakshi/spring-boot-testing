package com.ongrid.nexusTesting.service.object;

import com.ongrid.nexusTesting.model.Gender;
import lombok.Getter;

@Getter
public class AddEmployeeRequest {
    private String name;
    private String email;
    private Gender gender;
}
