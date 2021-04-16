package mini.models;


import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Document(collection = "product")
@RequiredArgsConstructor

public class Product {
    @Id
    private String id;

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
