package ru.boost.charity.rest_api.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.boost.charity.rest_api.entity.Task;
import ru.boost.charity.rest_api.model.TaskModel;

@Mapper(componentModel = "spring")
public interface TaskConverter {

    @Mappings({
            @Mapping(target = "taskTypeId", source = "taskType.id"),
            @Mapping(target = "taskStatusId", source = "taskStatus.id"),
            @Mapping(target = "parentTaskId", source = "parentTask.id"),
            @Mapping(target = "reporterId", source = "reporter.id"),
            @Mapping(target = "moderatorId", source = "moderator.id"),
            @Mapping(target = "executorId", source = "executor.id")
    })
    TaskModel entityToModel (Task task);


}
