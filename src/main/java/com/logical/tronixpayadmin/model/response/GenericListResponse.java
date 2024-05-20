package com.logical.tronixpayadmin.model.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenericListResponse<T> {
    private boolean result;
    private String message;
    private List<T> data;
}
