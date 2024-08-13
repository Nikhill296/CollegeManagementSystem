package com.college.DTO;

import java.time.LocalDateTime;

import org.hibernate.annotations.CurrentTimestamp;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString

public class UserDetailsDto {
	
	private int user_id ;
	
	private String user_name;	
	private String isd_code;
    private String mob_number;
	private String email_id;
	private String gender;
	private String age;
	private LocalDateTime user_creation_date;
	private String active_user;	
	private LocalDateTime modified_date;
    private String birth_date;	
	
}
