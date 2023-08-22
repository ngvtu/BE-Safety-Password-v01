package com.example.besafetypassv1.Dto.Login;

import com.example.besafetypassv1.Security.EncryptUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginDto {
    private String username;
    private String password;

    public String authorizationKey() {
        String encodeString = String.format("%s:%s", username, password);
        return EncryptUtils.encodeBase64(encodeString);
    }
}
