package com.cypher.blog_app_apis.payloads;

import com.cypher.blog_app_apis.payloads.Dtos.CategoryDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class CategoryResponse {

    private List<CategoryDto> content;
    private int pageNumber;
    private int pageSize;
    private int totalPages;
    private int totalElements;
    private boolean lastPage;
}
