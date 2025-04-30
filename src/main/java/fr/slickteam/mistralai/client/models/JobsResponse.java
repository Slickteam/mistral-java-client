package fr.slickteam.mistralai.client.models;

import java.util.List;

/**
 * Response model for listing jobs.
 */
public class JobsResponse {
    public String object;
    public List<JobResponse> data;
}