package models.requestModel;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogRequest {
    public String email;
    public String password;

    public LogRequest(String email){
        this.email = email;
    }
}
