import axios from "axios"

export const fetchRegister = async(input)=>{
    const{data}= await axios.post( `http://localhost:8070/api/users/add`,input )
    return data;
}

export const memberAdd = async(input)=>{
    const {data}=await axios.post(`http://localhost:8070/api/members/add`,input) 
    return data;
}

export const memberUpdate = async(input)=>{
    const {data}=await axios.post(`http://localhost:8070/api/members/update`,input) 
    return data;
}

export const memberDelete = async(input)=>{
    const {data}=await axios.post(`http://localhost:8070/api/members/delete`,input) 
    return data;
}

// clubss

export const clubAdd = async(input)=>{
    const {data}=await axios.post(`http://localhost:8070/api/clubs/add`,input) 
    return data;
}

export const clubUpdate = async(input)=>{
    const {data}=await axios.post(`http://localhost:8070/api/clubs/update`,input) 
    return data;
}

export const clubDelete = async(clubId)=>{
    const {data}=await axios.delete(`http://localhost:8070/api/clubs/delete?clubId=${clubId}`) 
    return data;
}

export const clubMember = async(clubId, memberId)=>{
    const {data}=await axios.patch("http://localhost:8070/api/clubs/{clubId}/members/{memberId}?clubId="+{clubId}+ "&memberId= "+ {memberId}) 
    return data;
}

// event

export const eventAdd = async(input)=>{
    const {data}=await axios.post(`http://localhost:8070/api/event/add`,input) 
    return data;
}

export const eventUpdate = async(input)=>{
    const {data}=await axios.post(`http://localhost:8070/api/event/update`,input) 
    return data;
}

export const eventDelete = async(input)=>{
    const {data}=await axios.post(`http://localhost:8070/api/event/delete`,input) 
    return data;
}