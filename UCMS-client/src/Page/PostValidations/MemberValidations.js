import * as yup from "yup";

const MemberAddvalidations = yup.object({
    email: yup.string().email("Geçerli bir email girin").required("Zorunlu alan"),
    gender:yup.string().required("Zorunlu alan"),
    memberName:yup.string().required("Zorunlu alan"),
    department:yup.string().required("Zorunlu alan"),
    position:yup.string().required("Zorunlu alan"),

})



export default MemberAddvalidations;