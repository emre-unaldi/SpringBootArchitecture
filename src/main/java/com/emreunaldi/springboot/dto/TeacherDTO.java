package com.emreunaldi.springboot.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2
public class TeacherDTO {
    private Long teacherId;

    @NotEmpty(message = "ad soyad alanını boş geçemezsiniz")
    @Size(min=1,max=255)
    private String teacherNameSurname;

    @NotEmpty(message = "email alanını boş geçemezsiniz")
    @Email(message = "uygun formatta mail girmediniz")
    private String teacherEmail;

    @NotEmpty(message = "şifreyi boş geçemezsiniz")
    //    @Min(value=10,message="minumum 10 karakter olmalıdır.")
    //    @Max(value=18,message="maksimum 18 karakter olmalıdır.")
    @Size(min=10,max=18)
    private String teacherPassword;
}
