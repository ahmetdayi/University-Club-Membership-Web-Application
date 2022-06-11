import * as yup from "yup";

const ClubMembervalidations = yup.object({
    
    clubId:yup.number().required("Zorunlu alan"),
    memberId:yup.number().required("Zorunlu alan"),
    
})





export default ClubMembervalidations;
