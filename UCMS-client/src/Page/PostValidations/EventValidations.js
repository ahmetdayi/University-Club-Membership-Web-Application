import * as yup from "yup";

const EventAddvalidations = yup.object({
    eventName:yup.string().required("Zorunlu alan"),
    datetime:yup.string().required("Zorunlu alan"),
    clubId:yup.number().required("Zorunlu alan"),

})



export default EventAddvalidations;