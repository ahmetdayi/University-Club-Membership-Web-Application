import * as yup from "yup";

const ClubAddvalidations = yup.object({
    
    clubName:yup.string().required("Zorunlu alan")
    
})





export default ClubAddvalidations;
