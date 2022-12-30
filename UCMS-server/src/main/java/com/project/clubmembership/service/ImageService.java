package com.project.clubmembership.service;

import com.project.clubmembership.core.constant.Constant;
import com.project.clubmembership.core.exception.ImageNotFoundException;
import com.project.clubmembership.entity.Image;
import com.project.clubmembership.repository.ImageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepo imageRepo;
    private final CloudStorageService cloudStorageService;

    private final SequenceGeneratorService sequenceGeneratorService;


    protected Image getImageByImageId(int imageId) {
        return imageRepo.findById(imageId).orElseThrow(() -> new ImageNotFoundException(Constant.IMAGE_NOT_FOUND));
    }

    //bır tane AddImageClub vb sınıfı olustur .veya nasıl null deger dondurmeyecegını coz
    protected Image addImage
    (MultipartFile multipartFile) {
        Map<?, ?> upload = cloudStorageService.upload(multipartFile);
        Image image = new Image
                (
                        sequenceGeneratorService.getSequenceNumber(Image.SEQUENCE_NAME),
                        upload.get("url").toString()
                );
        return imageRepo.save(image);
    }

    public void deleteImageByImageId(int imageId) {
        imageRepo.deleteById(getImageByImageId(imageId).getImageId());
    }

}