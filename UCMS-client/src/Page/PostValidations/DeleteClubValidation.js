import * as yup from "yup";

const ClubDeletevalidations = yup.object({
    
    clubId:yup.number().required("Zorunlu alan")
    
})

export default ClubDeletevalidations;