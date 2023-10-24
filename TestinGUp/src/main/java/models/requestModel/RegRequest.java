package models.requestModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegRequest {
    public String email;
    public String password;

    public RegRequest(String email){
        this.email = email;
    }
}
