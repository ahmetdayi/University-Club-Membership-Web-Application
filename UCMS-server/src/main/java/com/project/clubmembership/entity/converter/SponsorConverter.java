package com.project.clubmembership.entity.converter;


import com.project.clubmembership.entity.Sponsor;
import com.project.clubmembership.entity.dto.ImageResponse;
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

    public ImageResponse convertImage(Sponsor from){
        return new ImageResponse(from.getImage().getImageId(), from.getImage().getUrl());
    }

    public List<ImageResponse> convertImage(List<Sponsor> fromList){
        if (fromList == null){
            return null;
        }
        return fromList.stream().map(from->new ImageResponse(from.getImage().getImageId(), from.getImage().getUrl()))
                .collect(Collectors.toList());
    }
}
