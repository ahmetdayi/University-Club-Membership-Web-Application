package com.ahmetpoyraz.databaseproject.entities.dtos;


import com.ahmetpoyraz.databaseproject.entities.concretes.Members;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {

    private String eventName;

    private String datetime;

    private int clubId;




}
