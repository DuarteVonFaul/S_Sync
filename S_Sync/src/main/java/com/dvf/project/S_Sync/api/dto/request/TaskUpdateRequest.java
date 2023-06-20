package com.dvf.project.S_Sync.api.dto.request;

import com.dvf.project.S_Sync.domain.model.PriorityTask;
import com.dvf.project.S_Sync.domain.model.StatusTaks;
import com.dvf.project.S_Sync.domain.model.TypeTask;
import lombok.Getter;
import lombok.Setter;


@Setter@Getter
public class TaskUpdateRequest {

    private String title;
    private String description;

    private TypeTask type;
    private StatusTaks status;
    private PriorityTask priority;

}
