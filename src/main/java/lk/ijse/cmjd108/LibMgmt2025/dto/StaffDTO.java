package lk.ijse.cmjd108.LibMgmt2025.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffDTO implements Serializable {
    private String staffId;
    private String firstName;
    private String lastName;
    private String email;
    private String joinDate;
    private String lastUpdate;
    private String phone;
    private Role role;
}
