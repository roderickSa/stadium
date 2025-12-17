package com.home.stadium.infrastructure.request;

import com.home.stadium.domain.model.ZoneStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ZoneRequest {
    @NotBlank(message = "name is required")
    @Size(max = 100)
    private String name;

    @Positive(message = "capacity must be positive")
    @NotNull(message = "capacity is required")
    private Integer capacity;

    private ZoneStatus status;

    @Size(max = 255)
    private String description;
}
