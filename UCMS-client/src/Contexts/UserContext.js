import {useState,createContext,useEffect,useContext} from "react";

const UserContext = createContext();

const UserProvider = ({ children}) => {
    const [user, setUser] = useState(null)
    const [loggedIn, setLoggedIn] = useState(false)

    const login = (data) => {
        setLoggedIn(true);
        setUser(data.data.user);
        console.log("data1",data)

    };

    const values = {
        loggedIn,
        user,
        login
    };

    return <UserContext.Provider value={values}>{children}</UserContext.Provider>
};

const useAuth = ()=> useContext(UserContext);
export{UserProvider,useAuth};