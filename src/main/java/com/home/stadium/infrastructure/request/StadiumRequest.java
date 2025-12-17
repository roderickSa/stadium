package com.home.stadium.infrastructure.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class StadiumRequest {
    @NotBlank(message = "name is required")
    @Size(max = 100)
    private String name;

    @Size(max = 255)
    private String description;
}
