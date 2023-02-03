import React, {useEffect} from "react";
import {useSearchParams} from "react-router-dom";

export const OAuthCallbackHandler: React.FC = () => {
    const [searchParams, setSearchParams] = useSearchParams();

    useEffect(() => {
        const code = searchParams.get("code")
        console.log(code)
    }, [])

    return (
        <>logging in progress...</>
    )
}