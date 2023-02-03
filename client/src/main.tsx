import React from 'react'
import ReactDOM from 'react-dom/client'
import Login from './Login'
import {
    createBrowserRouter,
    RouterProvider,
} from "react-router-dom";
import {OAuthCallbackHandler} from "./OAuthCallbackHandler";

const router = createBrowserRouter([
    {
        path: "/",
        element: <Login/>,
    },
    {
        path: "/oauth-callback",
        element: <OAuthCallbackHandler/>,
    },
]);

ReactDOM.createRoot(document.getElementById('root') as HTMLElement).render(
    <React.StrictMode>
        <RouterProvider router={router}/>
    </React.StrictMode>,
)
