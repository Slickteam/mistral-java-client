package fr.slickteam.mistralai.client.model;

public record PaginationInfo(
    Integer total_items,
    Integer total_pages,
    Integer current_page,
    Integer page_size,
    Boolean has_more
) {}
