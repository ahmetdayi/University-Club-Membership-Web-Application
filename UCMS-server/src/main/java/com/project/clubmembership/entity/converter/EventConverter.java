package com.project.clubmembership.entity.converter;

import com.project.clubmembership.entity.Event;
import com.project.clubmembership.entity.dto.EventResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EventConverter {

    private final ClubConverter clubConverter;

    public EventResponse convert(Event from){
        return new EventResponse
                (
                        from.getId(),
                        from.getName(),
                        from.getDatetime(),
                        from.getEventPlace()


                );
    }

    public List<EventResponse> convert(List<Event> fromList){
        return fromList.stream().map(event -> new EventResponse
                (
                        event.getId(),
                        event.getName(),
                        event.getDatetime(),
                        event.getEventPlace()
                )).collect(Collectors.toList());
    }
}
