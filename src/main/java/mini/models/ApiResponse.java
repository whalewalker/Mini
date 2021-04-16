package mini.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {
   private boolean isSuccessFul;
   private String message;
}
