package fr.slickteam.mistralai.client.model;

import java.util.List;

/**
 * Response model for listing jobs.
 */
public class JobsResponse {
    public String object;
    public List<JobResponse> data;
}