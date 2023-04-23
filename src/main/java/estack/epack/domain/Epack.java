package estack.epack.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.OffsetDateTime;
import java.util.List;


@Data
@Schema(description = "DTO model of epack data")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Epack {

    private Long epackId;

    private String epackName;

    private String description;

    private Long managerId;

    private Double price;

    private Long categoryId;

    @CreatedDate
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    private OffsetDateTime lastUpdated;

    private Boolean isActive;

    public List<Long> ordersId;
}