package com.project.clubmembership.entity.converter;

import com.project.clubmembership.entity.Sponsor;
import com.project.clubmembership.entity.dto.SponsorResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SponsorConverter {

    public SponsorResponse convert(Sponsor from){
        return new SponsorResponse
                (from.getId(),
                        from.getCompanyName());
    }

    public List<SponsorResponse> convert(List<Sponsor> fromList){
        return fromList.stream().map(sponsor -> new SponsorResponse
                (
                        sponsor.getId(),
                        sponsor.getCompanyName()
                )).collect(Collectors.toList());
    }
}
