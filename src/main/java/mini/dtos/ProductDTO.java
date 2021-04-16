package mini.dtos;

import lombok.Data;
import lombok.NonNull;
import mini.models.ProductCategory;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class ProductDTO {

    @NotNull
    @NonNull
    private String name;

    @NotNull
    @NonNull
    private String Description;

    @NotNull
    @NonNull
    private BigDecimal price;

    @NotNull
    @NonNull
    private String image;

    @NotNull
    @NonNull
    private ProductCategory category;

    @UniqueElements
    @NonNull
    private String identifier;
}
